package cn.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.domain.Condition;
import cn.domain.Department;
import cn.domain.Student;
import cn.utils.DataSourceUtils;

public class SearchDao {

	public Student findStudentById(String ssno) throws SQLException {
		
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from student where Ssno=?";
		Student stu = qr.query(sql, new BeanHandler<Student>(Student.class),ssno);
		return stu;
	}

	public List<Department> getDeptCategory() throws SQLException {
		
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from department ";
		//创建一个集合储存学院类别信息
		List<Department> category = null;
		category = qr.query(sql, new BeanListHandler<Department>(Department.class));
		return category;
	}

	public String getPho(String sno) throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select Simg from student where Ssno=?";
		String path = qr.query(sql, new BeanHandler<String>(String.class),sno);
		return path;
	}

	public List<Student> getAllStudent() throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from student";
		return qr.query(sql, new BeanListHandler<Student>(Student.class));
	}

	public List<Student> findStudentByConditon(Condition condition) throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		//用于储存condition里面的参数
		ArrayList<String> conditionList = new ArrayList<String>();
		//书写sql的前半段
		StringBuilder sql = new StringBuilder("select * from student where 1=1 ");
		//判断名字有无值
		if(condition.getName()!=null&&!"".equals(condition.getName().trim() )){
			sql.append("and Sname like ? ");
			conditionList.add("%"+condition.getName()+"%");
		}
		//判断性别有无值
		if(condition.getSex()!=null&&!"".equals(condition.getSex().trim() )){
			sql.append("and Ssex=? ");
			conditionList.add(condition.getSex());
		}
		//判断学院有无值
		if(condition.getDept()!=null&&!"".equals(condition.getDept().trim() )){
			sql.append("and Sdept=? ");
			conditionList.add(condition.getDept());
		}
		
		List<Student> stuList = qr.query(sql.toString(), new BeanListHandler<Student>(Student.class),conditionList.toArray());
		
		return stuList;
	}

}
