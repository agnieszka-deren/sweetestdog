package pl.agnieszkaderen.sweetestdog.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import pl.agnieszkaderen.sweetestdog.model.Photo;
import pl.agnieszkaderen.sweetestdog.model.User;
import pl.agnieszkaderen.sweetestdog.util.DatabaseConnection;

public class PhotoDAOcrud implements PhotoDAO {
	
	private static final String CREATE_PHOTO = "INSERT INTO photo(name, description, photo_url, date, score, user_id)"
			+ "VALUES(:name, :description, :photo_url, :date, :score, :user_id);";
	
	private static final String READ_PHOTOS = "SELECT user.user_id, username, email, is_active, password, photo_id, "
			+ "name, description, photo_url, date, score FROM photo LEFT JOIN user ON photo.user_id=user.user_id;";

	 private static final String READ_SINGLE_PHOTO = 
		        "SELECT user.user_id, username, email, is_active, password,"
		        + " photo_id, name, description, photo_url, date, score "
		        + "FROM photo LEFT JOIN user ON photo.user_id=user.user_id"
		        + " WHERE photo_id=:photo_id;";
		    private static final String UPDATE_PHOTO = 
		        "UPDATE photo SET name=:name, description=:description, photo_url=:photo_url,"
		        + " date=:date, score=:score, user_id=:user_id"
		        + " WHERE photo_id=:photo_id;";

	
	
	private NamedParameterJdbcTemplate template;
	 
	public PhotoDAOcrud() {
		template = new NamedParameterJdbcTemplate(DatabaseConnection.getDataSourceInstance());
	}
	
	@Override
	public Photo create(Photo newPhoto) {
		Photo photo = new Photo(newPhoto);
		KeyHolder keyHolder = new GeneratedKeyHolder();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("name", photo.getName());
		paramMap.put("description", photo.getDesc());
		paramMap.put("photo_url", photo.getUrl());
		paramMap.put("date", photo.getTimestamp());
		paramMap.put("score", photo.getActualScore());
		paramMap.put("user_id", photo.getUser().getId());
		
		SqlParameterSource sqlParameterSource = new MapSqlParameterSource(paramMap);
		
		int update = template.update(CREATE_PHOTO, sqlParameterSource, keyHolder);
		if(update > 0) {
			photo.setId((Long)keyHolder.getKey());
		}
		return photo;
	}

	@Override
	public Photo read(Long primaryKey) {
		SqlParameterSource sqlParameterSource = new MapSqlParameterSource("photo_id", primaryKey);
		Photo photo = template.queryForObject(READ_SINGLE_PHOTO, sqlParameterSource, new PhotoRowMapper());
		return photo;
	}

	@Override
	public boolean update(Photo updatedPhoto) {
		boolean updated = false;
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("photo_id",updatedPhoto.getId());
		paramMap.put("name", updatedPhoto.getName());
		paramMap.put("description", updatedPhoto.getDesc());
		paramMap.put("photo_url", updatedPhoto.getUrl());
		paramMap.put("date", updatedPhoto.getTimestamp());
		paramMap.put("score", updatedPhoto.getActualScore());
		paramMap.put("user_id", updatedPhoto.getUser().getId());
		int update = template.update(UPDATE_PHOTO, paramMap);
		if(update>0) {
			updated = true;
		}
		return updated;
	}

	@Override
	public boolean delete(Long primaryKey) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Photo> getAll() {
		List<Photo> photos = template.query(READ_PHOTOS, new PhotoRowMapper());
		return photos;
	}
	
	private class PhotoRowMapper implements RowMapper<Photo> {

	@Override
	public Photo mapRow(ResultSet resultSet, int rowNumber) throws SQLException {
		
		Photo photo = new Photo();
		photo.setId(resultSet.getLong("photo_id"));
		photo.setName(resultSet.getString("name"));
		photo.setDesc(resultSet.getString("description"));
		photo.setUrl(resultSet.getString("photo_url"));
		photo.setActualScore(resultSet.getInt("score"));
		photo.setTimestamp(resultSet.getTimestamp("date"));
		
		User user = new User();
		user.setId(resultSet.getLong("user_id"));
		user.setUsername(resultSet.getString("username"));
		user.setEmail(resultSet.getString("email"));
		user.setPassword(resultSet.getString("password"));
		photo.setUser(user);
		return photo;
	}
	}
	
	
	
	
	

}
