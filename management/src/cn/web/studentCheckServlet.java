package cn.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.domain.Student;
import cn.service.SearchService;

public class studentCheckServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//获得需要查询的学号
		String Ssno = (String) request.getSession().getAttribute("username");
		//传递到service层显示
		SearchService service = new SearchService();
		Student stu = null;
		try {
			stu = service.findStudentById(Ssno);
			if(stu!=null) {
				request.setAttribute("student", stu);
				request.getRequestDispatcher("/show.jsp").forward(request, response);
				return ;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}