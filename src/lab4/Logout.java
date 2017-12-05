package lab4;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Labs4/Logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().invalidate();
		Cookie[] cookies = request.getCookies();
		Cookie studentCookie = null;
		for(Cookie cookie : cookies) {
			if(cookie.getName().equals("student")) {
				studentCookie = cookie;
			}
		}
		if(studentCookie != null) {
			studentCookie.setMaxAge(0);
			response.addCookie(studentCookie);
		}
		response.sendRedirect("Login");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

