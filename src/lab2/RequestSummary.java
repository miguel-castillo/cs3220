package lab2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestSummary
 */
@WebServlet("/Labs/RequestSummary")
public class RequestSummary extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestSummary() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("    <meta charset=\"utf-8\">");
		out.println("    <title>Request Summary</title>");
		out.println("	<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\" integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\" crossorigin=\"anonymous\">");
		out.println("</head>");
		out.println("<body>");
		out.println("    <div class=\"container\">");
		out.println("        <div class=\"jumbotron\">");
		out.println("            <h1>Request Parameters <small>Lab 1</small></h1>");
		out.println("            <p>The following <code>"+ request.getMethod() +"</code> request was submitted on <code>"+ new Date() +"</code>.</p>");
		out.println("        </div>");
		out.println("        <h3>Request Parameters</h3>");
		out.println("        <table class=\"table table-bordered table-striped table-hover\">");
		out.println("            <thead>");
		out.println("                <tr>");
		out.println("                    <th>Parameter Name</th>");
		out.println("                    <th>Parameter Value</th>");
		out.println("                </tr>");
		out.println("            </thead>");
		out.println("            <tbody>");
		Enumeration<String> parameters = request.getParameterNames();
		
		while(parameters.hasMoreElements()){
			String parameter = parameters.nextElement();
			out.println("                <tr>");
			out.println("                    <td>"+ parameter +"</td>");
			String[] values = request.getParameterValues(parameter);
			out.println("                    <td>");
			for(int i = 0; i < values.length; i++){
				out.println("                    <span class=\"label label-info\">"+ values[i] +"</span>");
			}
			out.println("                    </td>");
			out.println("                </tr>");
		}

		out.println("            </tbody>");
		out.println("        </table>");
		out.println("        <h3>Header Information</h3>");
		out.println("        <table class=\"table table-bordered table-striped table-hover\">");
		out.println("            <thead>");
		out.println("                <tr>");
		out.println("                    <th>Header Field</th>");
		out.println("                    <th>Header Value</th>");
		out.println("                </tr>");
		out.println("            </thead>");
		out.println("            <tbody>");
		Enumeration<String> headers = request.getHeaderNames();
		
		while(headers.hasMoreElements()){
			String headerName = headers.nextElement();
			out.println("                <tr>");
			out.println("                    <td>"+ headerName +"</td>");
			out.println("                    <td><span class=\"label label-info\">"+ request.getHeader(headerName)+"</span></td>");
			out.println("                </tr>");
		}
		out.println("            </tbody>");
		out.println("        </table>");
		out.println("    </div>");
		out.println("</body>");
		out.println("</html>");	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
