import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/InsertDataServlet")
public class Insert_Content extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String title = request.getParameter("title");
        String content = request.getParameter("content");


        try {
            // Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Open a connection
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/notetaker", "root", "Rimee@2001");
                // SQL query with a prepared statement
                String query = "INSERT INTO notes (title, content, date) VALUES (?, ?, ?)";
                PreparedStatement st = con.prepareStatement(query);
                    // Set values for the prepared statement
                    st.setString(1, title);
                    st.setString(2, content);

                    // Get the current date and time
                    SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String currentDate = d.format(new Date());

                    // Set the current date to the third parameter (creation_date)
                    st.setString(3, currentDate);

                    // Execute the update
                    int rowsAffected = st.executeUpdate();

                    if (rowsAffected > 0) {
                        System.out.println("Data inserted successfully!");
                    } else {
                        System.out.println("Failed to insert data.");
                    }
                    response.sendRedirect("Add_Note.jsp");
                
            
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            response.getWriter().println("Error: " + e.getMessage());
        }
    }
}

