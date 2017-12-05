package midterm;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Midterm/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Registration() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("	<!-- Latest compiled and minified CSS -->");
		out.println("	<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\" integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\" crossorigin=\"anonymous\">");			
		out.println("	<meta charset=\"UTF-8\">");
		out.println("	<title>Tutor Registration</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Tutor Registration</h1>");
		out.println("<form action=\"Registration\" method=\"post\">");
		
		String firstNameError = (String) request.getAttribute("firstNameError");
		String firstName = request.getParameter("firstName");
		
		if (firstNameError != null){
			out.println("<p class=\"text-danger\">" + firstNameError + "</p>");
		}
		
		if (firstName == null){
			firstName ="";
		}
		
		out.println("  First name: <input type=\"text\" name=\"firstName\" value=\"" + firstName + "\"><br>");
		
		String lastNameError = (String) request.getAttribute("lastNameError");
		
		if (lastNameError != null){
			out.println("<p class=\"text-danger\">" + lastNameError + "</p>");
	}
		
		String lastName = request.getParameter("lastName");
		if (lastName == null) lastName ="";
		
		out.println("  Last name: <input type=\"text\" name=\"lastName\" value=\"" + lastName + "\"/> <br />");
		
		String emailError = (String) request.getAttribute("emailError");
		
		if (emailError != null){
			out.println("<p class=\"text-danger\">" + emailError + "</p>");
		}
		
		String email = request.getParameter("email");
		if (email == null) email ="";
		
		out.println("  E-mail: <input type=\"text\" name=\"email\" value=\"" + email + "\"/> <br />");
		
		String courseError = (String) request.getAttribute("courseError");
		
		if (courseError != null){
			out.println("<p class=\"text-danger\">" + courseError + "</p>");
		}
		
		String course = request.getParameter("course");
		if (course == null) course ="";
		
		out.println("  Course: <input type=\"text\" name=\"course\" value=\"" + course + "\"/> <br />");
		out.println("  <input type=\"submit\" />");
		out.println("</form>");
		
		out.println("</body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String course = request.getParameter("course");
		
		boolean isFirstNameError = firstName != null && firstName.trim().length() > 0;
		boolean isLastNameError = lastName != null && lastName.trim().length() > 0;
		boolean isEmailError = email != null && email.trim().length() > 0;
		boolean isCourseError = course != null && course.trim().length() > 0;
		
		if (isFirstNameError && isLastNameError && isEmailError && isCourseError){
			Tutor tutor = new Tutor (firstName, lastName, email, course);
			ArrayList<Tutor> tutors = (ArrayList<Tutor>) getServletContext().getAttribute("tutors");
			tutors.add(tutor);
			
			response.sendRedirect("Search");
		} else {
		
		if (!isFirstNameError)
			request.setAttribute("firstNameError", "You must enter your first name");
		
		if (!isLastNameError)
			request.setAttribute("lastNameError", "You must enter your last name");
		
		if (!isEmailError)
			request.setAttribute("emailError", "You must enter an email");
		
		if (!isCourseError)
			request.setAttribute("courseError", "You must enter a course");
		}
		
		doGet(request, response);
	}

}
