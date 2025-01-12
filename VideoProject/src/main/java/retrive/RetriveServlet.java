package retrive;

import java.io.IOException;
import java.util.ArrayList;

import JavaBean.Video;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/show")
public class RetriveServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ArrayList<Video> vl=new RetriveDB().retrive();
		req.setAttribute("vl", vl);
		req.getRequestDispatcher("list.jsp").forward(req, resp);
	}
}
