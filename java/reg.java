import jakarta.servlet.ServletException; 
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class reg extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  
	    String Name = request.getParameter("Name");
		String Email = request.getParameter("Email");
		String Password = request.getParameter("Password");
	    String url = "jdbc:mysql://localhost:3306/notetaker";
	    String Uname = "root";
	    String Upass = "YOUR_DB_PASSWORD";

	    try {
	    	 // Register JDBC driver
	    	Class.forName("com.mysql.jdbc.Driver");
	    	 // Open a connection
	        Connection con = DriverManager.getConnection(url, Uname, Upass);
	        String query = "INSERT INTO user (Name, Email, Password) VALUES (?, ?, ?)";
	        PreparedStatement st = con.prepareStatement(query);
	            st.setString(1, Name);
	            st.setString(2, Email);
	            st.setString(3, Password);
	            st.executeUpdate();
	            con.close();
	         
	} catch (ClassNotFoundException | SQLException e) {
		System.out.println("error in code");
		e.printStackTrace(); // Consider logging the exception instead
	}

	response.sendRedirect(request.getContextPath() + "/Login.jsp");
}
}
