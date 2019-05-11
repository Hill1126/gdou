package cn.service;

import java.sql.SQLException;

import cn.dao.Updatedao;
import cn.domain.Student;

public class UpdateService {

	public boolean updateBySno(String ssno, Student stu) throws SQLException {
		
		Updatedao dao = new Updatedao();
		return dao.updateBySno(ssno,stu);
		
	}

	public boolean updatePassword(String sno, String oldpassword, String newpassword) throws SQLException {
		Updatedao dao = new Updatedao();
		return dao.updatePassword(sno,oldpassword,newpassword);
		 
	}

	public boolean deleteStudentById(String sno) throws SQLException {

		Updatedao dao = new Updatedao();
		return dao.deleteStudentById(sno);
	}

}
