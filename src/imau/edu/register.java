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
//ע��

import imau.edu.ConnectionManager;
@WebServlet("/add_user")
public class register extends HttpServlet{
	 private static Connection conn = ConnectionManager.getConnection();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html");
	    //���ñ���
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
			//����������C�����д��ļ�
		Statement statement = conn.createStatement();//����SQL��䣬
		String sql = "insert into userdata(username,password) values ('"+username+"','"+password+"') ";
		int affect = statement.executeUpdate(sql);//ִ��SQL��䣬������Ӱ���������
			//��ʾ��ִ�е�Ч��
			if(affect>0) {//��Ϊ��һ�����ִ�гɹ�����Ӱ��������϶�>0
				System.out.println("ִ�гɹ�");
				//ע��ɹ���ת����¼ҳ��
				HttpSession session = req.getSession();
				session.setAttribute("login_status", "OK");
				session.setAttribute("username", username);
				String datestring = "�״ε�¼";
				session.setAttribute("date", datestring);
				response.sendRedirect("index.jsp");
			}else {		  //����϶�Ϊ0
				System.out.println("���ʧ��");
				pr.write("�ύʧ��");
			}
			
	} catch (Exception e) {
		e.printStackTrace();
		//�˺��ѱ�ע�� ��ʾ��index1.jspҳ��
			error_msg = "���û����ѱ�ע��";
		//�����ݱ��浽request�����У���ת��request��Ŀ��jsp
		req.setAttribute("msg",error_msg);
		req.setAttribute("username",username);
		req.setAttribute("password",password);
		req.getRequestDispatcher("register.jsp").forward(req, response);
		System.out.print("e");
		//response.sendRedirect("register.jsp");
	}
}
}
