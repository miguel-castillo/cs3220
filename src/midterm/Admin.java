package midterm;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Midterm/Admin")
public class Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Admin() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();

				out.println("<!DOCTYPE html>");
				out.println("<html lang=\"en\">");
				out.println("<head>");
				out.println("    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\" integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\" crossorigin=\"anonymous\">");
				out.println("    <meta charset=\"UTF-8\">");
				out.println("    <title>CSULA Computer Science Tutor Directory</title>");
				out.println("</head>");
				out.println("<body>");
				out.println("<div class=\"container\">");
				out.println("<div class=\"page-header\">");
				out.println("    <h1>CSULA Computer Science Tutor Directory<small>Midterm</small></h1>");
				out.println("</div>");
				out.println("<hr>");
				
				out.println("<table class=\"table table-striped table-bordered table-hover\">");
				out.println("  <tr>");
				out.println("    <th>Name</th>");
				out.println("    <th>Email</th>");
				out.println("    <th>Course</th>");
				out.println("    <th>Actions</th>");
				out.println("  </tr>");
				
				ArrayList<Tutor> tutors = (ArrayList<Tutor>) getServletContext().getAttribute("tutors");
				for (Tutor tutor : tutors) {
					String tutorName = tutor.getFirstName() + " " + tutor.getLastName();
					out.println("<tr>");
					out.println("  <td>" + tutorName + "</td>");
					out.println("  <td>" + tutor.getEmail() + "</td>");
					out.println("  <td>" + tutor.getCourseTeaching() + "</td>");

					out.println("  <td>");
					out.println("		<a href=\"Delete?id=" + tutor.getId() + "\">Delete</a>");
					out.println("  </td>");
					out.println("</tr>");

				}
				out.println("</table>");
				out.println("<a class=\"btn btn-primary\" href=\"Registration\">Register Tutor</a>");
				out.println("</div>");
				out.println("</body>");

				out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
