package cn.service;

import java.sql.SQLException;

import cn.dao.AddDao;
import cn.domain.Student;

public class AddService {

	public boolean addStudent(Student stu) throws SQLException {
		

		
		//无特殊业务操作，传入dao层
		AddDao dao = new AddDao();
		boolean isSuccess = dao.AddStudent(stu);
		return isSuccess;
	}

	public boolean addPhoto(String photoname, String sno) throws SQLException {
		AddDao dao = new AddDao();
		boolean flag = false;
		flag = dao.addPhoto(photoname,sno);
		return flag;
	}

}
