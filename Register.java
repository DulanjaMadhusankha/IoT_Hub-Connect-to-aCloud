import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class Register extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    String FirstName = request.getParameter("txtFName");
    String LastName = request.getParameter("txtLName");
    String email = request.getParameter("txtemail");
    String Mobile = request.getParameter("txtMobile");
    String Home = request.getParameter("txtHome");
    String Address = request.getParameter("txtAddress");
    // String username = request.getParameter("txtUsername");
    // String password = request.getParameter("txtPassword");

    try{
      // Registration process
      Class.forName("com.mysql.jdbc.Driver");

      //creating connection with the database 
      Connection  con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/backend_server","root","sa123");

      PreparedStatement ps1 = con.prepareStatement ("insert into user_info values(?,?,?,?,?,?)");
      // PreparedStatement ps2 = con.prepareStatement ("insert into tomcat_users values(?,?)");
      // PreparedStatement ps3 = con.prepareStatement ("insert into tomcat_users_roles values(?,?)");

      ps1.setString(1, FirstName);
      ps1.setString(2, LastName);
      ps1.setString(3, email);
      ps1.setString(4, Mobile);
      ps1.setString(5, Home);
      ps1.setString(6, Address);
      // ps1.setString(7, username);
      
      // ps2.setString(1, username);
      // ps2.setString(2, password);
      
      // ps3.setString(1, username);
      // ps3.setString(2, "user");
      
      ps1.executeUpdate();
      // ps2.executeUpdate();
      // ps3.executeUpdate();

	  String site = new String("login.html");

	  response.setStatus(response.SC_MOVED_TEMPORARILY);
	  response.setHeader("Location", site);    
	} catch(Exception se) {
      // Registration error
	  out.write("<html><head><title></title></head><body>" + se + "</body></html>");
    }
  }
}