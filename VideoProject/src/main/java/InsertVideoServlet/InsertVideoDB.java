package InsertVideoServlet;

import java.sql.Connection;
import java.sql.PreparedStatement;

import DBHandler.DBConnection;
import JavaBean.Video;

public class InsertVideoDB {
	int k;
	
	public int insertVideo(Video v) {
		try {
			Connection con=DBConnection.connect();
			PreparedStatement ps=con.prepareStatement("insert into videotable values(?,?,?)");
			ps.setString(1,v.getId());
			ps.setString(2, v.getName());
			ps.setBytes(3, v.getVideo());
			
			k=ps.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return k;
	}
}
