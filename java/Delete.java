import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * Servlet implementation class DeleteServlet
 */
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String deleteParam = request.getParameter("delete");

	    // Check if "delete" parameter is not null and not empty
	    if (deleteParam != null && !deleteParam.isEmpty()) {
	        try {
	            // Parse the "delete" parameter to an integer
	            int id = Integer.parseInt(deleteParam);

	            // Rest of your code for database connection and deletion
	            String query = "delete from notes where id=" + id;
	            String url = "jdbc:mysql://localhost:3306/notetaker";
	            String Uname = "root";
	            String Upass = "Rimee@2001";

	            try {
	                Class.forName("com.mysql.cj.jdbc.Driver");
	                Connection con = DriverManager.getConnection(url, Uname, Upass);
	                Statement stmt = con.createStatement();
	                stmt.executeUpdate(query);

	                con.close();
	            } catch (Exception e) {
	                e.printStackTrace(); // Log or handle the exception accordingly
	            }

	        } catch (NumberFormatException e) {
	            // Handle the case where "delete" parameter cannot be parsed to an integer
	            System.out.println("Invalid 'delete' parameter format: " + deleteParam);
	            e.printStackTrace(); // Log or handle the exception accordingly
	        }
	    } else {
	        // Handle the case where "delete" parameter is missing or empty
	        System.out.println("Missing or empty 'delete' parameter.");
	    }

	    // Redirect to the JSP page after deletion
	    response.sendRedirect(request.getContextPath() + "/Your_Notes.jsp");
	}


}

