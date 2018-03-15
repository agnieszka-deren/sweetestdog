package pl.agnieszkaderen.sweetestdog.dao;

public class MysqlDAOFactory extends DAOFactory {

	@Override
	public PhotoDAO getPhotoDAO() {
		// TODO Auto-generated method stub
		return new PhotoDAOcrud();
	}

	@Override
	public UserDAO getUserDAO() {
		// TODO Auto-generated method stub
		return new UserDAOcrud();
	}

	@Override
	public ScoreDAO getScoreDAO() {
		// TODO Auto-generated method stub
		return new ScoreDAOcrud();
	}

}
