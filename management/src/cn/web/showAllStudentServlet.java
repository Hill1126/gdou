package cn.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.domain.Department;
import cn.domain.Student;
import cn.service.SearchService;

public class showAllStudentServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//收到请求，直接把所有学生信息发送给jsp页面
		SearchService service = new SearchService();
		List<Department> deptList = null;
		List<Student> stuList = null;
		try {
			deptList =  service.getDeptCategory();
			stuList = service.getAllStudent();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(deptList!=null) {
			request.setAttribute("deptList", deptList);
		}
		if(stuList!=null) {
			request.setAttribute("stuList", stuList);
		}
		request.getRequestDispatcher("/showAll.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}