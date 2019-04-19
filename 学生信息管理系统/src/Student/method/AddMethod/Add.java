package Student.method.AddMethod;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Add {
	
	public static Boolean AddAll(String Num,String Name,String Sex,String banji,String Tel) {
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/ims?useUnicode=true&characterEncoding=gbk&useSSL=false";
		String psw = "wbxgsnmm...";
		String psn = "root";
				
		Connection con = null;
		PreparedStatement ps = null;
		
		try{
			Class.forName(driver);
			con = DriverManager.getConnection(url,psn,psw);
			con.setAutoCommit(false);
			
			ps = con.prepareStatement("insert into stu_msg (Num,Name,Sex,banji,Tel) values(?,?,?,?,?)");
			ps.setString(1, Num);
			ps.setString(2, Name);
			ps.setString(3, Sex);
			ps.setString(4, banji);
			ps.setString(5, Tel);

			ps.execute();
			con.commit();
			
	}catch(SQLException e){
		try {
			con.rollback();
			return false;
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		} 
	catch (ClassNotFoundException e) {
		e.printStackTrace();
	}finally{
		try{
			if(ps!=null)
				ps.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		try {
			if(con!=null)
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}
		return true;
 }

		
}


