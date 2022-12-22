package imau.edu;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//注册

import imau.edu.ConnectionManager;
@WebServlet("/add_user")
public class register extends HttpServlet{
	 private static Connection conn = ConnectionManager.getConnection();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html");
	    //设置编码
	    response.setCharacterEncoding("utf-8");
		PrintWriter pr = response.getWriter();
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		System.out.print(username);
		System.out.print(password);
//		Connection connection = null;
//		Statement statement = null;
		String error_msg = null;
		try {
			//你可以想象成C语言中打开文件
		Statement statement = conn.createStatement();//创建SQL语句，
		String sql = "insert into userdata(username,password) values ('"+username+"','"+password+"') ";
		int affect = statement.executeUpdate(sql);//执行SQL语句，并返回影响的行数，
			//显示出执行的效果
			if(affect>0) {//因为上一语句若执行成功，则影响的行数肯定>0
				System.out.println("执行成功");
				//注册成功后转到登录页面
				HttpSession session = req.getSession();
				session.setAttribute("login_status", "OK");
				session.setAttribute("username", username);
				String datestring = "首次登录";
				session.setAttribute("date", datestring);
				response.sendRedirect("index.jsp");
			}else {		  //否则肯定为0
				System.out.println("添加失败");
				pr.write("提交失败");
			}
			
	} catch (Exception e) {
		e.printStackTrace();
		//账号已被注册 提示到index1.jsp页面
			error_msg = "该用户名已被注册";
		//把数据保存到request对象中，并转发request到目标jsp
		req.setAttribute("msg",error_msg);
		req.setAttribute("username",username);
		req.setAttribute("password",password);
		req.getRequestDispatcher("register.jsp").forward(req, response);
		System.out.print("e");
		//response.sendRedirect("register.jsp");
	}
}
}
