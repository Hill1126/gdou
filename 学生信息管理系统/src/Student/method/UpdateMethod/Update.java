package Student.method.UpdateMethod;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Student.JDBCTools.Tools;


public class Update {


	public static int UpdateAll(String Num,String Name,String Sex,String banji,String Tel,String Ex_Num) {
		Tools t = Tools.GetTools();
		ResultSet rs = null;
		PreparedStatement ps = null;
		Connection con = t.GetConnetion();
		
		try{
			
			con.setAutoCommit(false);
			ps = con.prepareStatement("update stu_msg set Num=?,Name=?,Sex=?,banji=?,Tel=? where Num=?");
			ps.setString(1, Num);
			ps.setString(2, Name);
			ps.setString(3, Sex);
			ps.setString(4, banji);
			ps.setString(5, Tel);
			ps.setString(6, Ex_Num);
			ps.execute();
			
			con.commit();
		}catch(SQLException e){
			try {
				con.rollback();
				return 0;
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return 1;
	}

}
