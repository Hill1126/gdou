package cn.web;

import java.io.IOException;
import java.net.URLEncoder;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.domain.User;
import cn.service.LoginService;

public class CheckLoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//解决编码问题
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		//先判断验证码是否正确
		String checkCode = request.getParameter("checkCode");
		HttpSession session = request.getSession();
		Object heckcode_session = session.getAttribute("checkcode_session");
		
		if(!checkCode.equals(heckcode_session)) {
			request.setAttribute("loginInfo", "您的验证码不正确");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}else {
			//获取
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String logintype = request.getParameter("logintype");
			
			LoginService service = new LoginService();
			//学生登陆方式
			if(logintype.equals("student")) {
				try {
					User user = service.studentLogin(username,password);
					if(user!=null) {						
						//若验证成功，则保存用户的名字和id，用于后期显示和功能
						request.getSession().setAttribute("Sname", user.getSname());
						//学号
						request.getSession().setAttribute("username", user.getUsername());		
						//登陆成功则转到学生的管理界面
							response.sendRedirect(request.getContextPath()+"/home.jsp");
							return;
							
					}else {
						//失败则返回提示信息
						request.setAttribute("loginInfo", "账号或密码不正确");
						request.getRequestDispatcher("/login.jsp").forward(request, response);
						return;
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(logintype.equals("manage")) {
				try {
					boolean flag = service.manageLogin(username,password);
					if(flag) {						
						//若验证成功，则保存用户的名字，用于后期显示和功能
						request.getSession().setAttribute("Sname", "管理员");
						//登陆成功则转到学生的管理界面
							response.sendRedirect(request.getContextPath()+"/manage_home.jsp");
							return;
							
					}else {
						//失败则返回提示信息
						request.setAttribute("loginInfo", "账号或密码不正确");
						request.getRequestDispatcher("/login.jsp").forward(request, response);
						return;
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}