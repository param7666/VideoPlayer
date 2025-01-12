package InsertVideoServlet;

import java.awt.im.InputContext;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import JavaBean.Video;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
@WebServlet("/UploadServlet")
@MultipartConfig
public class InsertServlet extends HttpServlet {
	Video video=null;
	
	@Override
	public void init() throws ServletException {
		video=new Video();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		video.setId(req.getParameter("videoId"));
		video.setName(req.getParameter("videoName"));
		Part vp=req.getPart("videoFile");
		byte[] videoData = null;
		if(vp!=null) {
			InputStream inp=vp.getInputStream();
			ByteArrayOutputStream out= new ByteArrayOutputStream();
			byte[] buffer=new byte[1024];
			int bytesRead;
			 while ((bytesRead = inp.read(buffer)) != -1) {
                 out.write(buffer, 0, bytesRead);
             }
			 videoData = out.toByteArray();
			 video.setVideo(videoData); 
		} else {
			System.out.println("Video File Null");
		}
		int k=new InsertVideoDB().insertVideo(video);
		if(k>0) {
			System.out.println("Video Inserted");
		} else {
			System.out.println("Video not Inserted");
		}
	}
}
