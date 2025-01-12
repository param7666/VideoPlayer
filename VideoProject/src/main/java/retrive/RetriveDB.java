package retrive;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import DBHandler.DBConnection;
import JavaBean.Video;

public class RetriveDB {
	Video v=null;
	public ArrayList<Video> retrive(){
		ArrayList<Video> vl=new ArrayList();
		try {
			Connection con=DBConnection.connect();
			PreparedStatement ps=con.prepareStatement("select * from videotable");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				v=new Video();
				v.setId(rs.getString(1));
				v.setName(rs.getString(2));
				v.setVideo(rs.getBytes(3));
				vl.add(v);
			}
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return vl;
	}
}
