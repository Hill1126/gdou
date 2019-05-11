package cn.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import cn.domain.Student;
import cn.utils.DataSourceUtils;

public class AddDao {

	public boolean AddStudent(Student stu) throws SQLException {

		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "insert into student values(?,?,?,?,?,?,?,?,?,?,?,?)";
		int flag = qr.update(sql,stu.getSname(),stu.getSsno(),stu.getSsex(),stu.getSdept(),stu.getSimg(),
						stu.getStel(),stu.getSmali(),stu.getSaddress(),stu.getSbirthday(),stu.getSdescribe(),
						stu.getSentrance(),stu.getSgraduate());
		
		return flag>0?true:false;
	}

	public boolean addPhoto(String photoname, String sno) throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "update student set Simg = ? where Ssno=?";
		String path = "http://localhost:8080/img/"+photoname;
		int flag = qr.update(sql, path,sno);
		
		return flag>0?true:false;
		
	}

}
