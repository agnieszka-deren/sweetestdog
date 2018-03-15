package pl.agnieszkaderen.sweetestdog.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import pl.agnieszkaderen.sweetestdog.model.User;
import pl.agnieszkaderen.sweetestdog.util.DatabaseConnection;

public class UserDAOcrud implements UserDAO {
	
	private static final String CREATE_USER = "INSERT INTO user(username, email, password, is_active) "
											+ "VALUES(:username, :email, :password, :active);";
    private static final String READ_USER = 
    	      "SELECT user_id, username, email, password, is_active FROM user WHERE user_id = :id";
    
    private static final String READ_USER_USING_USERNAME = 
    	      "SELECT user_id, username, email, password, is_active FROM user WHERE username = :username";
	
		
	private NamedParameterJdbcTemplate template;
	
	public UserDAOcrud() {
		template = new NamedParameterJdbcTemplate(DatabaseConnection.getDataSourceInstance());
	}
	
	
	@Override
	public User create(User newUser) {
		User user = new User(newUser);
		KeyHolder keyHolder = new GeneratedKeyHolder();
		SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(newUser);
		int update = template.update(CREATE_USER, sqlParameterSource, keyHolder);
		if(update > 0) {
			user.setId((Long) keyHolder.getKey());
			setPrivigiles(user);
		}
		return user;
	}
	
	private void setPrivigiles(User user) {
		final String userRoleQuery = "INSERT INTO user_role(username) VALUES(:username)";
        SqlParameterSource paramSource = new BeanPropertySqlParameterSource(user);
        template.update(userRoleQuery, paramSource);
	}
	
	

	@Override
	public User read(Long primaryKey) {
		User readedUser= null;
		SqlParameterSource sqlParameterSource = new MapSqlParameterSource("id", primaryKey);
		readedUser = template.queryForObject(READ_USER, sqlParameterSource, new UserRowMapper());
		return readedUser;
	}

	@Override
	public boolean update(User updateObject) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Long primaryKey) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUser(String username) {
		User readedUser = null;
		SqlParameterSource sqlParameterSource = new MapSqlParameterSource("username", username);
		readedUser = template.queryForObject(READ_USER_USING_USERNAME, sqlParameterSource, new UserRowMapper());
		return readedUser;
	}
	
	private class UserRowMapper implements RowMapper<User> {

		@Override
		public User mapRow(ResultSet resultSet, int rowNumber) throws SQLException {
			User user = new User();
			user.setId(resultSet.getLong("user_id"));
			user.setUsername(resultSet.getString("username"));
			user.setEmail(resultSet.getString("email"));
			user.setPassword(resultSet.getString("password"));
			return user;
		}
		
	}
	
	

}
