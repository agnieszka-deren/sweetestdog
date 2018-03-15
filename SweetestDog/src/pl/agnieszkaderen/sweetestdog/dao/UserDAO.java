package pl.agnieszkaderen.sweetestdog.dao;


import java.util.List;

import pl.agnieszkaderen.sweetestdog.model.User;

public interface UserDAO extends GenericDAO<User, Long> {

		List<User> getAll();
		User getUser(String username);
}
