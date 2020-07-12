package com.asjy.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.asjy.model.User;
import com.asjy.service.UserService;
import com.asjy.service.impl.UserServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String flag = request.getParameter("flag");
		if ("doLogin".equals(flag)) {
			//登陆验证
			doLogin(request, response);
		}
	}

	private void doLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO 登陆验证！
		//1. 接取参数
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		//2. 非空校验
		//3. 格式校验
		//4. 有效性校验
		UserService u1 = new UserServiceImpl();
		User user = new User();
		user.setName(name);
		user.setPassword(password);
		User result = u1.login(user);
		if (result == null) {
			//跳转回登录页
			System.out.println("登陆失败");
		}
		//5. 登陆成功的用户装进session中
		request.getSession().setAttribute("user", result);
		//6. 跳转到PermissionServlet中，进行用户鉴权
		request.getRequestDispatcher("PermissionServlet?flag=goIndex").forward(request, response);
	}
}





