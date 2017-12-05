package midterm;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Search
 */
@WebServlet(urlPatterns = "/Midterm/Search", loadOnStartup = 1)
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Search() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void init(ServletConfig config) throws ServletException {
		super.init(config);

		ArrayList<Tutor> tutors = new ArrayList<Tutor>();
		tutors.add(new Tutor("John", "Doe", "john@doe.com", "Math"));
		tutors.add(new Tutor("Mary", "Jane", "mary@jane.com", "Science"));
		tutors.add(new Tutor("Joe", "Hart", "joe@hart.com", "English"));

		ServletContext context = this.getServletContext();
		context.setAttribute("tutors", tutors);
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


		out.println("<form class=\"form-inline\" action=\"Search\" method=\"get\">");
		out.println("<div class=\"form-group\">");
		out.println("	<input class=\"form-control\" type=\"text\" name=\"query\" placeholder=\"Enter your search term(s)\">");
		out.println("	<input class=\"form-control btn btn-primary\" type=\"submit\" value=\"Search\">");
		out.println("</div>");
		out.println("</form>");
		
		out.println("<a href=\"Admin\"> Admin </a>");

		out.println("<hr>");
		
		out.println("<table class=\"table table-striped table-bordered table-hover\">");
		out.println("  <tr>");
		out.println("    <th>Name</th>");
		out.println("    <th>Email</th>");
		out.println("    <th>Course</th>");		
		out.println("  </tr>");
		
		String query = null;
		
		if(request.getParameterNames() != null){
			query = request.getParameter("query");
		}
		ArrayList<Tutor> tutors = (ArrayList<Tutor>) getServletContext().getAttribute("tutors");
		
		if(query == null){
			for (Tutor tutor : tutors) {
				String tutorName = tutor.getFirstName() + " " + tutor.getLastName();
				out.println("<tr>");
				out.println("  <td>" + tutorName + "</td>");
				out.println("  <td>" + tutor.getEmail() + "</td>");
				out.println("  <td>" + tutor.getCourseTeaching() + "</td>");
				out.println("</tr>");
	
			}
		} else {
			for ( Tutor tutor : tutors){
				String tutorName = tutor.getFirstName() + " " + tutor.getLastName();
				if(tutorName.toLowerCase().contains(query.toLowerCase()) || tutor.getEmail().toLowerCase().contains(query) || tutor.getCourseTeaching().toLowerCase().contains(query)){
					out.println("<tr>");
					out.println("  <td>" + tutorName + "</td>");
					out.println("  <td>" + tutor.getEmail() + "</td>");
					out.println("  <td>" + tutor.getCourseTeaching() + "</td>");
					out.println(" </td>");
					out.println("</tr>");
				}
			}
		}

		out.println("</table>");

		out.println("</div>");
		out.println("</body>");

		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String queryString = request.getParameter("query");
		doGet( request, response );
	}

}
