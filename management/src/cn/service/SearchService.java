package cn.service;

import java.sql.SQLException;
import java.util.List;

import cn.dao.SearchDao;
import cn.domain.Condition;
import cn.domain.Department;
import cn.domain.Student;

public class SearchService {

	public Student findStudentById(String ssno) throws SQLException {
		//传递到dao层查询信息
		SearchDao dao = new SearchDao();
		Student stu = dao.findStudentById(ssno);
		return stu;
	}
	
	public List<Department> getDeptCategory() throws SQLException {
		
		//传递到dao层查询学院类别
		SearchDao dao = new SearchDao();
		List<Department> category = null;
		category = dao.getDeptCategory();
		return category;
		
	}

	public String getPho(String sno) throws SQLException {
		SearchDao dao = new SearchDao();
		String path = dao.getPho(sno);
		return path;
		// TODO Auto-generated method stub
		
	}

	public List<Student> getAllStudent() throws SQLException {
		SearchDao dao = new SearchDao();
		return dao.getAllStudent();
	}

	public List<Student> findStudentByConditon(Condition condition) throws SQLException {
		SearchDao dao = new SearchDao();
		return dao.findStudentByConditon(condition);
	}

}
