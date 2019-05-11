package cn.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.domain.Condition;
import cn.domain.Department;
import cn.domain.Student;
import cn.service.SearchService;

public class findStudentByConditionServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		request.setCharacterEncoding("UTF-8");
		//获取所有查询条件
		//新建一个条件对象
		Condition condition = new Condition();
			
		condition.setName(request.getParameter("name"));
		condition.setDept(request.getParameter("dept"));
		condition.setSex(request.getParameter("sex"));

		SearchService service = new SearchService();
		List<Department> deptList = null;
		List<Student> stuList = null;
		try {
			stuList = service.findStudentByConditon(condition);
			deptList = service.getDeptCategory();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(stuList!=null) {
			request.setAttribute("stuList", stuList);
			request.setAttribute("deptList",deptList);
			request.getRequestDispatcher("/showAll.jsp").forward(request, response);
			return;
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}