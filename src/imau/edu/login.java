package imau.edu;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/login")
public class login extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username= req.getParameter("username");
		String password= req.getParameter("password");
		
		if(username.equals("admin")&&password.equals("123456")) {
			HttpSession session = req.getSession();
			session.setAttribute("login_status", "OK");
			session.setAttribute("username", username);
			resp.sendRedirect("index.html");
		}
		else {
			String msg = "用户名或密码错误";
			req.setAttribute("password",password);
			req.setAttribute("username",username);
			req.setAttribute("msg",msg );
			req.getRequestDispatcher("login.jsp").forward(req, resp);
			System.out.print(msg);
			resp.sendRedirect("login.jsp");
		}
		
	}

}
