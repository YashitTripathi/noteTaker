import java.io.*; 
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
 
 
@MultipartConfig(
  fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
  maxFileSize = 1024 * 1024 * 10,      // 10 MB
  maxRequestSize = 1024 * 1024 * 100   // 100 MB
)
public class Go extends HttpServlet {
	 private static final long serialVersionUID = 1L;
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    Part filePart = request.getPart("file");
    String fileName = filePart.getSubmittedFileName();
    for (Part part : request.getParts()) {
      part.write("C:\\Users\\rivia\\OneDrive\\Desktop\\eclipse work\\" + fileName);
    }
    
    response.setContentType("text/html");  
    PrintWriter out = response.getWriter();  
    Part filenamefn = filePart;   
    String filepath = "C:\\Users\\Desktop\\eclipse work";   
    response.setContentType("APPLICATION/OCTET-STREAM");   
    response.setHeader("Content-Disposition","attachment; filename=\"" + filenamefn + "\"");   
      
    FileInputStream fileInputStream = new FileInputStream(filepath + filenamefn);  
                
    int i;   
    while ((i=fileInputStream.read()) != -1) {  
    out.write(i);   
    }   
    fileInputStream.close();   
    out.close();   
    System.out.println("File uploaded successfully!");
    
    
  }
}
