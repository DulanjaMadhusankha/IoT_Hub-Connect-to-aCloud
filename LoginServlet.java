    import java.io.IOException;
    import javax.servlet.RequestDispatcher;
    import javax.servlet.ServletException;
    import javax.servlet.http.HttpServlet;
    import javax.servlet.http.HttpServletRequest;
    import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
    
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();  

		try {
			// Check the provided login details

			// If the login is valid
			// New location to be redirected
			String site = new String("user_management/home.html");

			response.setStatus(response.SC_MOVED_TEMPORARILY);
			response.setHeader("Location", site);    

		} catch (Exception ex) {
			// If the login is invalid

		}
	}

	@Override
	public void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);  // Re-direct POST request to doGet()
	}
} 
