package pl.agnieszkaderen.sweetestdog.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.agnieszkaderen.sweetestdog.model.User;
import pl.agnieszkaderen.sweetestdog.service.PhotoService;

@WebServlet("/add")
public class AddPhotoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 if(request.getUserPrincipal() != null) {
	            request.getRequestDispatcher("newphoto.jsp").forward(request, response);
	        } else {
	            response.sendError(403);
	        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("inputName");
        String description = request.getParameter("inputDescription");
        String url = request.getParameter("inputUrl");
        User authenticatedUser = (User) request.getSession().getAttribute("user");
        if(request.getUserPrincipal() != null) {
            PhotoService photoService = new PhotoService();
            photoService.addPhoto(name, description, url, authenticatedUser);
            response.sendRedirect(request.getContextPath() + "/");
        } else {
            response.sendError(403);
        }
	}

}
