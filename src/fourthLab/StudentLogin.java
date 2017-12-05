package fourthLab;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Student;

@WebServlet("/lab4/StudentLogin")
public class StudentLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public void init(ServletConfig config) throws ServletException {
		super.init(config);

		// Create a few students 
		ArrayList<Student> students = new ArrayList<Student>();
		students.add(new Student("John", "Doe", "john@doe.com", "abcd"));
		students.add(new Student("Mary", "Jane", "mary@jane.com", "efgh"));
		students.add(new Student("Joe", "Boxer", "joe@boxer.com", "ijkl"));

		// Add the students to the application scope (Servlet Context)
		getServletContext().setAttribute("students", students);
	}
	
	private String getHashedID( HttpServletRequest request )
	{
		Cookie[] cookies = request.getCookies();
		if( cookies != null )
			for( Cookie cookie : cookies )
				if( cookie.getName().equals( "student" ) )
					return cookie.getValue();

		return null;
	}
	
	private Student getStudent(String hashedID, ArrayList<Student> students){
		Student matchedStudent = null;
		
		for(Student student : students){
			if(student.getHashedID().equals(hashedID)){
				matchedStudent = student;
				break;
			}
		}
		
		return matchedStudent;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String hashedID = getHashedID( request );
		ArrayList<Student> students = (ArrayList<Student>) getServletContext().getAttribute("students");
		Student student = getStudent(hashedID, students);
		
		// Set the content type
		response.setContentType("text/html");

		// Get a reference to the PrintWriter that lets us talk to the client
		PrintWriter out = response.getWriter();
		
		// Checks to see if hashedID is in cookie to redirect to MyProfile
		if(hashedID != null){
			response.sendRedirect("StudentProfile");
		} else {

		// Generate the HTML
		out.println("<!DOCTYPE html>");
		out.println("<html lang=\"en\">");
		out.println("<head>");
		out.println("    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\" integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\" crossorigin=\"anonymous\">");
		out.println("    <meta charset=\"UTF-8\">");

		/* Page Title goes here */
		out.println("    <title>Login</title>");
		out.println("</head>");

		/* Page Body goes here */
		out.println("<body>");
		out.println("<div class=\"container\">");

		out.println("<div class=\"page-header\">");
		out.println("    <h1>Login</h1>");
		out.println("</div>");
		
		// Create the login form
		out.println("<form action=\"StudentLogin\" method=\"post\">");
		out.println("	<div class=\"form-group\">");

		out.println("		<label>Username (E-mail Address)</label>");
		out.println("		<input class=\"form-control\"type=\"text\" name=\"username\" placeholder=\"Email\">");
		out.println("	</div>");
		out.println("	<div class=\"form-group\">");
		out.println("		<label>Password</label>");
		out.println("		<input class=\"form-control\"type=\"password\" name=\"password\" placeholder=\"Password\">");
		out.println("	</div>");
		out.println("	<div class=\"checkbox\">");
		out.println("		<label>");
		out.println("			<input type=\"checkbox\" name=\"rememberMe\"> Remember Me");
		out.println("		</label>");
		out.println("	</div>");
		out.println("	<button type=\"submit\" class=\"btn btn-primary\">Login</button>");
		out.println("</form>");

		out.println("</div>");
		out.println("</body>");

		out.println("</html>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String hashedID = null;
		String username = null;
		String password = null;
		boolean rememberMe = false;
		if (hashedID == null){
			username = request.getParameter("username");
			password = request.getParameter("password");
			if(request.getParameter("rememberMe") != null){
				rememberMe = true;
			}
		}
		
		ArrayList<Student> students = (ArrayList<Student>) getServletContext().getAttribute("students");
		for (Student tempStudent : students) {
			if (tempStudent.getEmail().equals(username.trim().toLowerCase()) && tempStudent.getPassword().equals(password)) {
				response.sendRedirect("MyProfile");
				return;
			}
		}
		
		doGet(request, response);
	}

}
