package Student.JDBCTools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Tools {

	private Connection con;
	private ResultSet rs;
	private PreparedStatement ps;
	
	private String driver = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/ims?useUnicode=true&characterEncoding=gbk&useSSL=false";
	private String psw = "wbxgsnmm...";
	private String psn = "root";
	
	private static Tools t;
	
	private Tools(){
		
	}
	
	public static Tools GetTools(){
		if(t == null){
			t = new Tools();
		}
		return t;
	}
	
	public Connection GetConnetion(){
		try {
			if(con == null || con.isClosed())
			Class.forName(driver);
			con = DriverManager.getConnection(url,psn,psw);
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		return con;
	}
	
	public void close(){
		try{
			if(rs!=null)
				rs.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		//�ڶ���
		try{
			if(ps!=null)
				ps.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		//������
		try {
			if(con!=null)
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

}
