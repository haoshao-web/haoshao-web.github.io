package imau.edu;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import imau.edu.author;
import imau.edu.authorDao;
@WebServlet("/add")
public class authorAddServlet extends HttpServlet{
	private static authorDao dao = new authorDao();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		String id_str = request.getParameter("id");
		String Username = request.getParameter("Username");
		String Gender = request.getParameter("Gender");
		String Phone = request.getParameter("Phone");
		String Bookname = request.getParameter("Bookname");
		String Sales_volume = request.getParameter("Sales_volume");
		String Booknum = request.getParameter("Booknum");
		//2调用model
		if(id_str == "") {
				author student = new author(-1,Username,Gender,Phone,Bookname,Sales_volume,Booknum);
				dao.add(student);
		}
		else {
			author student = new author(Integer.parseInt(id_str),Username,Gender,Phone,Bookname,Sales_volume,Booknum);
			dao.add(student);
		}
		//3数据交给view
		resp.sendRedirect("list");
	}
	
}
