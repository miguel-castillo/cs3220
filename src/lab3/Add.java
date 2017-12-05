package lab3;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Add
 */
@WebServlet("/Lab3/Add")
public class Add extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("	<!-- Latest compiled and minified CSS -->");
		out.println("	<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\" integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\" crossorigin=\"anonymous\">");			
		out.println("	<meta charset=\"UTF-8\">");
		out.println("	<title>Insert title here</title>");
		out.println("</head>");
		out.println("<body>");
		
		out.println("<h1>Add Entry</h1>");
		
		out.println("<form action=\"Add\" method=\"post\">");
		out.println("  Name: <input type=\"text\" name=\"name\" /> <br />");
		out.println("  Message: <input type=\"text\" name=\"message\" /> <br />");
		out.println("  <input type=\"submit\" />");
		out.println("</form>");
		
		out.println("</body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String message = request.getParameter("message");
		
		if (name != null && name.trim().length() > 0 &&
			message != null && message.trim().length() > 0){
		
			// Get a reference to the guest book
			@SuppressWarnings("unchecked")
			List<GuestBookEntry> entries = (List<GuestBookEntry>) getServletContext().getAttribute("entries");
			
			// Add a new entry
			entries.add(new GuestBookEntry(name, message));
		}
		
		// Send the User back to the Guest Book page
		response.sendRedirect("Guestbook");
	}

}
