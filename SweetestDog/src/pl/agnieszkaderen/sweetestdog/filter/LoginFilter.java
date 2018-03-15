package pl.agnieszkaderen.sweetestdog.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import pl.agnieszkaderen.sweetestdog.model.User;
import pl.agnieszkaderen.sweetestdog.service.UserService;

@WebFilter("/*")
public class LoginFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		if(httpRequest.getUserPrincipal() != null  && httpRequest.getSession().getAttribute("user") == null) {
			saveUserInSession(httpRequest);
		}
		filterChain.doFilter(request, response);
	}
	
	private void saveUserInSession(HttpServletRequest req) {
		UserService userService = new UserService();
		String username  = req.getUserPrincipal().getName();
		User userUsingUsername = userService.getUserUsingUsername(username);
		req.getSession(true).setAttribute("user", userUsingUsername);
	}
	
	
	
	
	

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}



}
