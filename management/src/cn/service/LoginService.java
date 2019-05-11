package cn.service;

import java.sql.SQLException;

import cn.dao.LoginDao;
import cn.domain.User;

public class LoginService {

	public User studentLogin(String username, String password) throws SQLException {
		
		//没有业务，直接传递给dao层
		LoginDao dao = new LoginDao();
		return dao.studentLogin(username,password);
		
	}

	public boolean manageLogin(String username, String password) throws SQLException {
		//没有业务，直接传递给dao层
		LoginDao dao = new LoginDao();
		return dao.manageLogin(username,password);
	}

}
