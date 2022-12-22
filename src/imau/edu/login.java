package imau.edu;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import imau.edu.ConnectionManager;
@WebServlet("/login")
public class login extends HttpServlet{

		private static Connection conn = ConnectionManager.getConnection();
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
				throws ServletException, IOException {
			//1、处理参数
			String username= req.getParameter("username");
			String password= req.getParameter("password");
			boolean f=false;
			try {
				//准备查询														
				Statement st = conn.createStatement();//创建SQL语句，
				String str = "select * from userdata";
				//执行sql
				ResultSet rs = st.executeQuery(str);
				while(rs.next()) {
					String name = rs.getString("username");
					String pas = rs.getString("password");
					System.out.println(name +"-"+username);
					System.out.print(pas +"-"+password);
					if(username.equals(name)&&password.equals(pas)){
						System.out.print("登录成功");
						//把登录成功的状态保存到session
						//String login_status = "OK";
						HttpSession session = req.getSession();
						session.setAttribute("login_status", "OK");
						session.setAttribute("username", username);
						Date date = new Date();
						SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
						String datestring=simpleDateFormat.format(date);
						session.setAttribute("date", datestring);
						resp.sendRedirect("index.jsp");
						
						f = true;
						break;
					}
				}
					
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(!f) {
				System.out.print("登录失败");
				
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
