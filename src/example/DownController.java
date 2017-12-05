package example;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Homework4/DownController")
public class DownController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DownController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get the entry to be edited
        Integer id = Integer.valueOf( request.getParameter( "id" ) );

        Connection c = null;
        try
        {
            String url = "jdbc:mysql://cs3.calstatela.edu:3306/cs3220ystu20";
            String username = "cs3220ystu20";
            String password = "!5kWTI2*";
            
            c = DriverManager.getConnection( url, username, password );
            
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "select vote from links where id =\"" + id + "\"" );
            
            int vote = rs.getInt("vote") - 1;

            String sql = "update links set votes = ? where id = ?";

            PreparedStatement pstmt = c.prepareStatement( sql );
            pstmt.setInt(1, vote);
            pstmt.setInt(2, id );
            pstmt.executeUpdate();
        }
        catch( SQLException e )
        {
            throw new ServletException( e );
        }
        finally
        {
            try
            {
                if( c != null ) c.close();
            }
            catch( SQLException e )
            {
                throw new ServletException( e );
            }
        }

        // send the user back to the guest book page
        response.sendRedirect( "List" );
	}

}
