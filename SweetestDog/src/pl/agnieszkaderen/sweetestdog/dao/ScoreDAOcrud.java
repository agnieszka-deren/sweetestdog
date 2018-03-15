package pl.agnieszkaderen.sweetestdog.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

//import pl.agnieszkaderen.sweetestdog.model.Photo;
import pl.agnieszkaderen.sweetestdog.model.Score;
//import pl.agnieszkaderen.sweetestdog.model.User;
import pl.agnieszkaderen.sweetestdog.util.DatabaseConnection;

public class ScoreDAOcrud implements ScoreDAO {
	
    private static final String CREATE_SCORE = "INSERT INTO scores(photo_id, user_id, date) "
            + "VALUES (:photo_id, :user_id, :date);";
    private static final String READ_SCORE = "SELECT score_id, photo_id, user_id, date "
            + "FROM scores WHERE score_id = :score_id;";
    private static final String READ_SCORE_USING_PHOTO_ID_AND_USER_ID = "SELECT score_id, photo_id, user_id, date "
            + "FROM scores WHERE user_id = :user_id AND photo_id = :photo_id;";
    private static final String UPDATE_SCORE = "UPDATE score SET date=:date WHERE score_id=:score_id;";
     
    private NamedParameterJdbcTemplate template;
     
    public ScoreDAOcrud() {
        template = new NamedParameterJdbcTemplate(DatabaseConnection.getDataSourceInstance());
    }

	@Override
	public Score create(Score score) {
		Score resultScore = new Score(score);
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("photo_id", resultScore.getPhotoId());
		paramMap.put("user_id", resultScore.getUserId());
		paramMap.put("date", resultScore.getDate());
		
		KeyHolder holder = new GeneratedKeyHolder();
		SqlParameterSource sqlParameterSource = new MapSqlParameterSource(paramMap);
		int update = template.update(CREATE_SCORE, sqlParameterSource, holder);
		if(update > 0) {
			resultScore.setId((Long)holder.getKey());
		}
				
		return resultScore;
	}

	@Override
	public Score read(Long primaryKey) {
		 SqlParameterSource sqlParameterSource = new MapSqlParameterSource("score_id", primaryKey);
	        Score score = template.queryForObject(READ_SCORE, sqlParameterSource, new ScoreRowMapper());
	        return score;
		
	}

	@Override
	public boolean update(Score score) {
		  boolean result = false;
	        Map<String, Object> paramMap = new HashMap<>();
	        paramMap.put("date", score.getDate());
	        paramMap.put("vote_id", score.getId());
	        SqlParameterSource paramSource = new MapSqlParameterSource(paramMap);
	        int update = template.update(UPDATE_SCORE, paramSource);
	        if(update > 0) {
	            result = true;
	        }
	        return result;
		
	}

	@Override
	public boolean delete(Long primaryKey) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Score> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Score getScore(long userId, long photoId) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("user_id", userId);
		paramMap.put("photo_id", photoId);
		SqlParameterSource sqlParameterSource = new MapSqlParameterSource(paramMap);
		
		Score score = null;
		  try {
	            score = template.queryForObject(READ_SCORE_USING_PHOTO_ID_AND_USER_ID, sqlParameterSource, new ScoreRowMapper());
	        } catch(EmptyResultDataAccessException e) {
	            //vote not found
	        }
		return score;
	}
	
	
	
	
	private class ScoreRowMapper implements RowMapper<Score>{

		@Override
		public Score mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			
			Score score = new Score();
			score.setId(resultSet.getLong("score_id"));
			score.setPhotoId(resultSet.getLong("photo_id"));
			score.setUserId(resultSet.getLong("user_id"));
			score.setDate(resultSet.getTimestamp("date"));
			return score;
		}
		
	}
	

}
