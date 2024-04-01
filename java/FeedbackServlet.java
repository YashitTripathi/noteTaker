import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/FeedbackServlet")
public class FeedbackServlet extends HttpServlet {
	 private static final long serialVersionUID = 1L;
   
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String text = request.getParameter("text");

        try {
        	  // Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
             // Open a connection
             Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/notetaker", "root", "Rimee@2001");
            String query = "INSERT INTO feedback (name, email, text) VALUES (?, ?, ?)";
            PreparedStatement st = con.prepareStatement(query);
                st.setString(1, name);
                st.setString(2, email);
                st.setString(3, text);
                // Execute the update
                int rowsAffected = st.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("feedback successfully!");
                } else {
                    System.out.println("Failed.");
                }
                response.getWriter().println("THANK YOU FOR YOUR FEEDBACK !!!");
            
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }
}
