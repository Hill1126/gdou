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

public class getCategoryServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//接收请求，无需参数，传递到service层查询学院类别
		SearchService service = new SearchService();
		//创建一个集合储存所有学院的列表
		List<Department> deptCategory = null;
		//用于返回给用户信息
		Student stu = null;
		String manage_Sno = null;
		manage_Sno = request.getParameter("manage_Sno");
		try {
			//先判断是否为管理员查找
			if(manage_Sno!=null) {
				//管理员查找学生的时候
				stu = service.findStudentById(manage_Sno);
			}else {
				stu = service.findStudentById((String)request.getSession().getAttribute("username"));	
			}
			deptCategory = service.getDeptCategory();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(deptCategory!=null) {
			request.setAttribute("deptCategory",deptCategory);
			request.setAttribute("student", stu);
			request.getRequestDispatcher("/manage_domain.jsp").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}