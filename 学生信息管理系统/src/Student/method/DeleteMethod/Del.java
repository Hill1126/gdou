package Student.method.DeleteMethod;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Student.JDBCTools.Tools;


public class Del {

	public static boolean DeleteByNum(String Num){
		/*
		 * �������ݿ�
		 * ���������ѧ��ɾ����Ϣ
		 * ��ɾ���ɹ����򷵻�һ��������
		 * ��������>0���򷵻�true
		 * �������쳣����ع����ݣ�����false��
		 * 
		 */
		
		Tools t = Tools.GetTools();
		Connection con = t.GetConnetion();
		PreparedStatement ps = null;
		try{
			int flag;
			con.setAutoCommit(false);
			ps = con.prepareStatement("delete from stu_msg where Num = ?");
			ps.setString(1, Num);
			flag = ps.executeUpdate();
			con.commit();
			if(flag>0){
				return true;
			}
		}catch (Exception e) {
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally {
			if(ps!=null){
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
				if(con!=null){
					try {
						con.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
			}
		}
		return false;
	}
	
	public static Boolean DeleteAll(){

		Tools t = Tools.GetTools();
		Connection con = t.GetConnetion();
		PreparedStatement ps = null;
		try{
			con.setAutoCommit(false);
			ps = con.prepareStatement("delete from stu_msg where Num!=?");
			ps.setString(1, "");
			ps.execute();
			
			con.commit();
			
		}catch (Exception e) {
			try {
				con.rollback();
				return false;
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally {
			if(ps!=null){
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
				if(con!=null){
					try {
						con.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
			}
		}
		 return true;
	}
	

}
