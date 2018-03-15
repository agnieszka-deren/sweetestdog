package pl.agnieszkaderen.sweetestdog.service;

import java.sql.Timestamp;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import pl.agnieszkaderen.sweetestdog.dao.DAOFactory;
import pl.agnieszkaderen.sweetestdog.dao.PhotoDAO;
import pl.agnieszkaderen.sweetestdog.model.Photo;
import pl.agnieszkaderen.sweetestdog.model.User;

public class PhotoService {
	
	public void addPhoto(String name, String description, String url, User user) {
		Photo photo = createPhotoObject(name, description, url, user);
		DAOFactory factory = DAOFactory.getDAOFactory();
		PhotoDAO photoDAO = factory.getPhotoDAO();
		photoDAO.create(photo);
	}
	
	private Photo createPhotoObject(String name, String description, String url, User user) {
		Photo photo = new Photo();
		photo.setName(name);
		photo.setDesc(description);
		photo.setUrl(url);
		User userCopy = new User(user);
		photo.setUser(userCopy);
		photo.setTimestamp(new Timestamp(new Date().getTime()));
		return photo;
	}
	
    public Photo getPhotoById(long photoId) {
        DAOFactory factory = DAOFactory.getDAOFactory();
        PhotoDAO photoDao = factory.getPhotoDAO();
        Photo photo = photoDao.read(photoId);
        return photo;
    }
     
    public boolean updatePhotoServ(Photo photo) {
        DAOFactory factory = DAOFactory.getDAOFactory();
        PhotoDAO photoDao = factory.getPhotoDAO();
        boolean result = photoDao.update(photo);
        return result;
    }
	
	public List<Photo> getAllPhotos(){
		return getAllPhotos(null);
	}
	
	public List<Photo> getAllPhotos(Comparator<Photo> comparator){
		DAOFactory factory = DAOFactory.getDAOFactory();
		PhotoDAO photoDAO = factory.getPhotoDAO();
		List<Photo> photos = photoDAO.getAll();
		if(comparator != null && photos != null) {
			photos.sort(comparator);
		}
		return photos;
	}
	
	

}
