import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@WebServlet("/Upload")
@MultipartConfig
public class Upload extends HttpServlet {
	 private static final long serialVersionUID = 1L;
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Retrieve the file part
        Part filePart = request.getPart("file");

        // Get the filename
        String fileName = filePart.getSubmittedFileName();

        // Specify the directory where you want to save the uploaded file
        String uploadDir = "C:\\Servlets";

        // Create the directory if it doesn't exist
        Path uploadPath = Path.of(uploadDir);
        Files.createDirectories(uploadPath);

        // Create the file path
        Path filePath = uploadPath.resolve(fileName);

        // Copy the InputStream of the uploaded file to the destination file
        try (InputStream input = filePart.getInputStream()) {
            Files.copy(input, filePath, StandardCopyOption.REPLACE_EXISTING);
        }

        // Insert data into the database
        String jdbcUrl = "jdbc:mysql://localhost:3306/notetaker";
        String dbUser = "root";
        String dbPassword = "Rimee@2001";

        try{
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword);
            String sql = "INSERT INTO filename (filename, date) VALUES (?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                // Set parameters for the SQL statement
                preparedStatement.setString(1, fileName);
                preparedStatement.setString(2, getCurrentDate());

                // Execute the SQL statement
                preparedStatement.executeUpdate();

            }
        } catch (ClassNotFoundException | SQLException e ) {
            e.printStackTrace();
            System.out.println("Error storing data in the database." + e.getMessage());
            return;
        }

        System.out.println("File uploaded successfully!");
        response.sendRedirect("Add_Note.jsp");

    }

    private String getCurrentDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date());
    }
}
