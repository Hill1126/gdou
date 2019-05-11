package cn.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import cn.domain.Student;
import cn.utils.DataSourceUtils;

public class Updatedao {

	public boolean updateBySno(String ssno, Student stu) throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "update student set Ssno=?, Sname=?,Ssex=?,Sdept=?,Stel=?,Smali=?,Saddress=?,Sbirthday=?,Sdescribe=?,"
				+ "Sentrance=?,Sgraduate=? where Ssno=?";
		int flag = qr.update(sql,stu.getSsno(), stu.getSname(),stu.getSsex(),stu.getSdept(),stu.getStel(),stu.getSmali(),stu.getSaddress(),stu.getSbirthday(),
					stu.getSdescribe(),stu.getSentrance(),stu.getSgraduate(),ssno);
		
		return flag>0?true:false;
	}

	public boolean updatePassword(String sno, String oldpassword, String newpassword) throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "update student_user set password=? where username=? and password=?";
		int flag = qr.update(sql, newpassword,sno,oldpassword);
		return flag>0?true:false;
	}

	public boolean deleteStudentById(String sno) throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "delete from student where ssno=?";
		int flag = qr.update(sql, sno);
		return flag>0?true:false;
	}

}
