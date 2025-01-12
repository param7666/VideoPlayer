package retrive;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import DBHandler.DBConnection;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/WatchVideoServlet")
public class WatchVideoServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String vid=req.getParameter("id");
		try {
			Connection con=DBConnection.connect();
			PreparedStatement ps=con.prepareStatement("select video from videoTable where id=?");
			ps.setString(1, vid);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				byte[] v=rs.getBytes(1);
				resp.setContentType("video/mp4");
				OutputStream out=resp.getOutputStream();
				out.write(v);
				out.flush();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
