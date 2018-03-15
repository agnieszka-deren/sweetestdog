package pl.agnieszkaderen.sweetestdog.dao;

import java.util.List;

import pl.agnieszkaderen.sweetestdog.model.Photo;

public interface PhotoDAO extends GenericDAO<Photo, Long> {

	 List<Photo> getAll();
}
