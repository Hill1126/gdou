package Student.method.ShowMethod;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Student.JDBCTools.Tools;


public class Show {
	
	public static void main(String[] args){
		ResultSet rs = showQuery("4");
		
		try{
			while(rs.next()){
				System.out.println(rs.getString("Name"));
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static ResultSet showAll(){
		Tools t = Tools.GetTools();
		Connection con = t.GetConnetion();
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try{
			ps = con.prepareStatement("select * from stu_msg where Num!=?");
			ps.setString(1, "null");
			rs =ps.executeQuery();
			
				
		}catch (Exception e) {
			
		}
		
		return rs;
	}

	public static ResultSet showQuery(String data ){
		Tools t = Tools.GetTools();
		Connection con = t.GetConnetion();
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		//������յ�����
		String sql = "%"+data+"%" ;
		/*1.����%����ʵ��ģ����ѯ
		 *2.��ѯ������浽ResultSet��
		 *3.��rs���ء�
		 */
		try{
			//ģ����ѯ�������ݣ����ٶȽ���
			ps = con.prepareStatement("select * from stu_msg where Num like ? or Sex like ? or Name like ? or Tel like ? or banji like ?");
			ps.setString(1, sql);
			ps.setString(2, sql);
			ps.setString(3, sql);
			ps.setString(4, sql);
			ps.setString(5, sql);
			
			rs =ps.executeQuery();	
				
		}catch (Exception e) {
			
		}
		
		return rs;
	}
}

