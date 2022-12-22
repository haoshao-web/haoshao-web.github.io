package imau.edu;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import imau.edu.authorDao;
import imau.edu.author;
@WebServlet("/list")
public class authorServlet extends HttpServlet{
	private authorDao dao = new authorDao();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1、处理参数
		//2、调用model
		ArrayList<author> list = dao.getAll();
		//3、数据交给View
		request.setAttribute("data",list);
		request.getRequestDispatcher("author.jsp").forward(request, response);
	}
}
