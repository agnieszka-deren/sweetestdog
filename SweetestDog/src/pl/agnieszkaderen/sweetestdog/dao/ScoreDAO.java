package pl.agnieszkaderen.sweetestdog.dao;

import pl.agnieszkaderen.sweetestdog.model.Score;

public interface ScoreDAO extends GenericDAO<Score, Long> {
	
	public Score getScore(long userId, long photoId);

}
