package imau.edu;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import imau.edu.authorDao;
@WebServlet("/del")
public class authorDelServlet extends HttpServlet{
	private static authorDao dao = new authorDao();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1处理参数
		String id_str = request.getParameter("id");
		//2调用model
		if(id_str !=null) {
			dao.delete(Integer.parseInt(id_str));
		}
		//3数据交给view
		response.sendRedirect("list");
	}
}
