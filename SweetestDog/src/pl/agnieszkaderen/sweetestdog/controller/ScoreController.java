package pl.agnieszkaderen.sweetestdog.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.agnieszkaderen.sweetestdog.model.Photo;
import pl.agnieszkaderen.sweetestdog.model.Score;
import pl.agnieszkaderen.sweetestdog.model.User;
import pl.agnieszkaderen.sweetestdog.service.PhotoService;
import pl.agnieszkaderen.sweetestdog.service.ScoreService;

/**
 * Servlet implementation class ScoreController
 */
@WebServlet("/score")
public class ScoreController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		 User loggedUser = (User) request.getSession().getAttribute("user");
	        if(loggedUser != null) {
	            long userId  = loggedUser.getId();
	            long photoId = Long.parseLong(request.getParameter("photo_id"));
	            addScoreOrDoNothing(userId, photoId);
	        }
	        response.sendRedirect(request.getContextPath() + "/");
		
	}

	
	public void addScoreOrDoNothing(long userId, long photoId) {
		  ScoreService scoreService = new ScoreService();
	        Score existingScore = scoreService.getScore(photoId, userId);
	        if(existingScore == null) {
	        	scoreService.addScore(photoId, userId);
	            updatePhoto(photoId);
	        }
	}
	
    private void updatePhoto(long photoId) {
        PhotoService photoService = new PhotoService();
        Photo photoById = photoService.getPhotoById(photoId);
        photoById.setActualScore(photoById.getActualScore()+1);
        photoService.updatePhotoServ(photoById);
    }
 
     


}
