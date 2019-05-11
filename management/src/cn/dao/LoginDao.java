package cn.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.domain.Manage;
import cn.domain.User;
import cn.utils.DataSourceUtils;

public class LoginDao {


	public  User studentLogin(String username, String password) throws SQLException {
		//获取数据库执行对象
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select u.username,u.password,student.Sname from student,student_User u "
						+ "where username=? and password=? and student.Ssno=u.username";
		//执行查询操作
		User user = qr.query(sql, new BeanHandler<User>(User.class),username,password);
		if(user!=null) {		
			return user;
		}else {
			return null;
		}
	}

	public boolean manageLogin(String username, String password) throws SQLException {
		//获取数据库执行对象
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select username from manage_user where username=? and password=? ";
		//执行查询操作
		Manage user = qr.query(sql,new BeanHandler<Manage>(Manage.class),username,password);
		//若查询到的用户名字等于用户输入的名字
		if(user!=null&&user.getUsername().equals(username)&&user.getUsername()!=null) {		
			return true;
		}else {
			return false;
		}
	}

}
