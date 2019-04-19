package Student.LoginBySql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Student.JDBCTools.Tools;




public class Login {

	private static void DelUser(String User, String PassWord) {
		
		Tools t = Tools.GetTools();
		
		Connection con = t.GetConnetion();
		PreparedStatement ps = null;
		
		try{
			
			ps = con.prepareStatement("delete from User where User=? and PassWord=? ");
			ps.setString(1, User);
			ps.setString(2, PassWord);
			
			ps.execute();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			t.close();
		}
	 }

	private static void AddUser(String User, String PassWord) {
		Tools t = Tools.GetTools();
		
		Connection con = null;
		PreparedStatement ps = null;
		
		try{
			
			con = t.GetConnetion();	
			ps = con.prepareStatement("insert into User (User,PassWord) values (?,?) ");
			ps.setString(1, User);
			ps.setString(2, PassWord);
			
			ps.execute();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			t.close();
	}
	 
			
			
	}

	private static void ChangePSW(String User, String PassWord) {
		Tools t = Tools.GetTools();
		
		Connection con = null;
		PreparedStatement ps = null;
			
			try{	
				con = t.GetConnetion();
				ps = con.prepareStatement("update User set PassWord=? where User=?");
				ps.setString(1, PassWord);
				ps.setString(2, User);
				ps.execute();		
				
			}catch (Exception e) {
				e.printStackTrace();
			}finally{
				t.close();
			}
		 
		
	}
	
	public static boolean IsUser(String User, String PassWord) {
		Tools t = Tools.GetTools();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try{	
			con = t.GetConnetion();
			String sql = "select * from User where User=?";
			ps = con.prepareStatement(sql);
			ps.setObject(1,User);
			rs = ps.executeQuery();
		
				while(rs.next()){
					if(rs.getString(1).equals(User)&&rs.getString(2).equals(PassWord)){
						return true;
					}
				}
			}	
				catch(SQLException e){
					e.printStackTrace();
				}finally{
					t.close();
				}
			return false;
	}
	
}	
