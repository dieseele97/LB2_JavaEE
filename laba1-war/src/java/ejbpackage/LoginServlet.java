package ejbpackage;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    private String login_admin = "admin";
    private String password_admin = "123";
    private String login_lector = "lector";
    private String password_lector = "123";

 protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
         
    }
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
           
        String login = request.getParameter("login");
        String password = request.getParameter("pass");         
        if (this.login_admin.equals(login) && this.password_admin.equals(password)) {           
            HttpSession oldSession = request.getSession(false);
            if (oldSession != null) {
                oldSession.invalidate();
            }            
            HttpSession newSession = request.getSession(true);
            newSession.setMaxInactiveInterval(5*60);
            Cookie message = new Cookie("message", "Welcome, Administrator!");
            response.addCookie(message);
            response.sendRedirect("menupage.jsp");
        } 
       else if (this.login_lector.equals(login) && this.password_lector.equals(password)) {           
            HttpSession oldSession = request.getSession(false);
            if (oldSession != null) {
                oldSession.invalidate();
            }            
            HttpSession newSession = request.getSession(true);
            newSession.setMaxInactiveInterval(5*60);
            Cookie message = new Cookie("message", "Welcome, Lecturer!");
            response.addCookie(message);
            response.sendRedirect("menupage.jsp");
        }    
        
        else {          
            
            request.setCharacterEncoding("UTF-8");   
            request.getRequestDispatcher("/index.html").include(request, response);
            response.setContentType("text/html;charset=UTF-8");
            ServletOutputStream out = response.getOutputStream();
            out.write("<center><h2><font color=red>Неправильний логін або пароль!!</font></h2></center>".getBytes("UTF-8"));         
         
        }
    }
} 
