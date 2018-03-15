package pl.agnieszkaderen.sweetestdog.service;

import pl.agnieszkaderen.sweetestdog.dao.DAOFactory;
import pl.agnieszkaderen.sweetestdog.dao.UserDAO;
import pl.agnieszkaderen.sweetestdog.model.User;

public class UserService {
	
	public void addUser(String username, String email, String password) {
		User user = new User();
		user.setUsername(username);
		user.setEmail(email);
		user.setPassword(password);
		user.setActive(true);
		DAOFactory factory = DAOFactory.getDAOFactory();
		UserDAO userDAO = factory.getUserDAO();
		userDAO.create(user);
	}
	
	public User getUserUsingId(long userId) {
		DAOFactory factory = DAOFactory.getDAOFactory();
		UserDAO userDAO = factory.getUserDAO();
		User user = userDAO.read(userId);
		return user;
	}

	public User getUserUsingUsername(String username) {
		DAOFactory factory = DAOFactory.getDAOFactory();
		UserDAO userDAO = factory.getUserDAO();
		User user = userDAO.getUser(username);
		return user;
	}
}
