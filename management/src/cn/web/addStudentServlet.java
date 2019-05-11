package cn.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.domain.Student;
import cn.service.AddService;

public class addStudentServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//解决中文乱码问题
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		Student stu = new Student();
		stu.setSsno(request.getParameter("Ssno"));
		stu.setSsex(request.getParameter("Ssex"));
		stu.setSname(request.getParameter("Sname"));
		stu.setSdept(request.getParameter("Sdept"));
		stu.setSimg(request.getParameter("Simg"));
		stu.setStel(request.getParameter("Stel"));
		stu.setSmali(request.getParameter("Smali"));
		stu.setSaddress(request.getParameter("Saddress"));
		stu.setSbirthday(request.getParameter("Sbirthday"));
		stu.setSdescribe(request.getParameter("Sdescribe"));
		stu.setSentrance(request.getParameter("Sentrance"));
		stu.setSgraduate(request.getParameter("Sgraduate"));
		stu.setSimg(request.getContextPath()+"/images/woman.png");
		
		AddService service = new AddService();
		boolean isSuccess = false;
		try {
			isSuccess = service.addStudent(stu);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(true==isSuccess) {
			response.getWriter().write("添加成功");
			response.setHeader("refresh","2;url="+request.getContextPath()+"/studentCheck");
		}else {
			response.getWriter().write("添加失败，请重新填写");
			response.setHeader("refresh","2;url="+request.getContextPath()+"/manage_add.jsp");
		}
		
	
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}