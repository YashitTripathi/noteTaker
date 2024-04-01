import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Done extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        String filename = request.getParameter("filename");
        String path = "C:\\Servlets"; // Update this to the correct directory on your server

        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment; filename=\"" + filename + "\"");

        try (PrintWriter out = response.getWriter();
             FileInputStream fileInputStream = new FileInputStream(Paths.get(path, filename).toString())) {

            int i;
            while ((i = fileInputStream.read()) != -1) {
                out.write(i);
            }
        }
    }
}

