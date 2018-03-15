package pl.agnieszkaderen.sweetestdog.dao;

//import pl.agnieszkaderen.sweetestdog.exc.WrongFactoryTypeException;

public abstract class DAOFactory {
	
	public static final int MYSQL_DAO_FACTORY = 1;
	 
	public abstract PhotoDAO getPhotoDAO();
	
	public abstract UserDAO getUserDAO();
	
	public abstract ScoreDAO getScoreDAO();
	
	public static DAOFactory getDAOFactory() {
		return new MysqlDAOFactory();
	}
	
//    public static DAOFactory getDAOFactory() {
//        DAOFactory factory = null;
//        try {
//            factory = getDAOFactory(MYSQL_DAO_FACTORY);
//        } catch (WrongFactoryTypeException e) {
//            e.printStackTrace();
//        }
//        return factory;
//    }
//     
//    private static DAOFactory getDAOFactory(int type) throws WrongFactoryTypeException {
//        switch (type) {
//        case MYSQL_DAO_FACTORY:
//            return new MysqlDAOFactory();
//        default:
//            throw new WrongFactoryTypeException();
//        }
//    }
	
}
