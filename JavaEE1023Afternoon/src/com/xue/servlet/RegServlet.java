package com.xue.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegServlet
 */
@WebServlet("/RegServlet")
public class RegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegServlet() {
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
		//1、获取账号密码验证密码等键值对
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		String confirm_pas = request.getParameter("confirm_pas");
		//进行密码校验  不一致返回原页面
		//一致返回注册成功页面，并输出结果
		if (password.equals(confirm_pas) && account != "" && password != "") {
			request.setAttribute("ok_account", account);
			request.setAttribute("ok_password", password);
			request.getRequestDispatcher("register_ok.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("homework02.jsp").forward(request, response);
		}
	}

}
