package com.xue.ajax.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xue.test.user.service.UserService;
import com.xue.test.user.serviceimpl.UserServiceImpl;

import xom.xue.test.user.model.User;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TOD 接取flag根据不同信息使用不同方法
		String flag = request.getParameter("flag");
		if ("comfirmname".equals(flag)) {
			gocomfirmname(request,response);
		} else {

		}
		
	}

	private void gocomfirmname(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO 接取name值
		String name = request.getParameter("name");
		//调用service层，去数据库查看是否存在
		UserService us = new UserServiceImpl();
		boolean result = us.selectExistName(name);
		response.getWriter().print(result);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO 接取flag根据不同信息使用不同方法
		String flag = request.getParameter("flag");
		if ("goindex".equals(flag)) {
		 dogoindex(request,response);	
		} else {

		}
	}

	private void dogoindex(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO 接取前端用户输入的正确账号密码
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		//装到user对象中
		User user = new User();
		user.setName(name);
		user.setPassword(password);
		//调用service给数据库增加数据
		UserService us = new UserServiceImpl();
		boolean result = us.insertuser(user);
		if (result) {  //如果成功跳转到index
			request.getRequestDispatcher("userindex.jsp").forward(request, response);
		} else {
			System.out.println("数据库操作失败");
		}
	}

}
