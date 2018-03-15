package pl.agnieszkaderen.sweetestdog.service;

import java.sql.Timestamp;
import java.util.Date;

import pl.agnieszkaderen.sweetestdog.dao.DAOFactory;
//import pl.agnieszkaderen.sweetestdog.dao.PhotoDAO;
import pl.agnieszkaderen.sweetestdog.dao.ScoreDAO;
//import pl.agnieszkaderen.sweetestdog.dao.UserDAO;
import pl.agnieszkaderen.sweetestdog.model.Score;

public class ScoreService {
		
	public Score addScore(long photoId, long userId) {
		Score score = new Score();
		score.setUserId(userId);
		score.setPhotoId(photoId);
		score.setDate(new Timestamp(new Date().getTime()));
		DAOFactory factory = DAOFactory.getDAOFactory();
		ScoreDAO scoreDAO = factory.getScoreDAO();
		score = scoreDAO.create(score);
		return score;
	}
	
	
	  public Score getScore(long photoId, long userId) {
	        DAOFactory factory = DAOFactory.getDAOFactory();
	        ScoreDAO scoreDao = factory.getScoreDAO();
	        Score score = scoreDao.getScore(userId, photoId);
	        return score;
	    }
	
//	public Score updateScore(long photoId, long userId) {
//		DAOFactory factory = DAOFactory.getDAOFactory();
//		ScoreDAO scoreDAO = factory.getScoreDAO();
//		Score scoreUpdate = scoreDAO.getScore(userId, photoId);
//		if(scoreUpdate == null) {
//			scoreUpdate = addScore(photoId, userId);
//		}
//		return scoreUpdate;
//		}
}	

