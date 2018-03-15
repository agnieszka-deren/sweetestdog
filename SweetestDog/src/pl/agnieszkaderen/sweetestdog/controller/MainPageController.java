package pl.agnieszkaderen.sweetestdog.controller;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.agnieszkaderen.sweetestdog.service.PhotoService;
import pl.agnieszkaderen.sweetestdog.model.Photo;


@WebServlet("")
public class MainPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		savePhotosInRequest(request);
        request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);
	}
		
    private void savePhotosInRequest(HttpServletRequest request) {
        PhotoService photoService = new PhotoService();
        List<Photo> allPhotos = photoService.getAllPhotos(new Comparator<Photo>() {
            @Override
            public int compare(Photo photo1, Photo photo2) {
                if(photo1.getActualScore() < photo2.getActualScore()) {
                    return 1;
                } else if(photo1.getActualScore() > photo2.getActualScore()) {
                    return -1;
                }
                return 0;
            }
        });
        request.setAttribute("photos", allPhotos);
    }

}
