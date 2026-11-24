import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/DeletePDFServlet")
public class DeletePDFServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get the filename to be deleted
        String filenameToDelete = request.getParameter("filename");

        // Database connection parameters
        String jdbcUrl = "jdbc:mysql://localhost:3306/notetaker";
        String dbUser = "root";
        String dbPassword = "YOUR_DB_PASSWORD";

        // Delete the file from the database and server's file system
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword)) {
            String sql = "DELETE FROM filename WHERE filename = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                // Set parameters for the SQL statement
                preparedStatement.setString(1, filenameToDelete);

                // Execute the SQL statement
                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    // File deleted successfully from the database
                    // Now, delete the file from the server's file system
                    if (deleteFileFromServer(filenameToDelete)) {
                        System.out.println("File deleted successfully!");
                        response.sendRedirect("Your_PDF.jsp");
                    } else {
                        System.out.println("File not found on the server!");
                    }
                } else {
                    // File not found in the database
                	System.out.println("File not found on the database!");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error deleting file from the database." + e.getMessage());
        }
    }

    private boolean deleteFileFromServer(String filename) {
        // Specify the directory where files are stored
        String uploadDir = "C:\\Servlets";

        // Create the file path
        Path filePath = Paths.get(uploadDir, filename);

        // Delete the file from the server's file system
        try {
            File file = filePath.toFile();
            return file.delete();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}

