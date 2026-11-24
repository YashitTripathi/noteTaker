import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * Servlet implementation class update_servlet
 */


public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");

		String query = "update notes set title='"+title+"',content='"+content+ "'where id ="+ id;
		String url = "jdbc:mysql://localhost:3306/notetaker";
		String Uname = "root";
		String Upass = "YOUR_DB_PASSWORD";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, Uname, Upass);
			Statement stmt = con.createStatement();
			stmt.executeUpdate(query); 
			con.close();
		} catch (NumberFormatException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		response.sendRedirect(request.getContextPath() + "/Your_Notes.jsp");

	}
	        
	}



