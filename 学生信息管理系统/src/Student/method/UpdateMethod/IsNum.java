package Student.method.UpdateMethod;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Student.JDBCTools.Tools;



public class IsNum {
	
	public static Boolean IsNumMethod(String Ex_Num){
		Tools t = Tools.GetTools();
		Connection con = t.GetConnetion();
		ResultSet rs = null;
		PreparedStatement ps = null;
		
		try {
			//��ȡ���ݿ��ڵ�ѧ����Ϣ
			ps = con.prepareStatement("select Num from stu_msg where Num=?");
			ps.setString(1, Ex_Num);
			rs = ps.executeQuery();
			
			//�Ƚ���Ϣ���������򷵻�true
			while(rs.next()){
				if(Ex_Num==rs.getString("Num"));
				return true;
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
		
	}
}
