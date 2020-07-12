package com.xue.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CusLoginServlet
 */
@WebServlet("/CusLoginServlet")
public class CusLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CusLoginServlet() {
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
		//huoqu前端键值对
		String account =  request.getParameter("account");
		String password =  request.getParameter("password");
		//进行账号密码的校验，看是否返回下一页面
		if ("123".equals(account) && "456".equals(password)) {
			request.getRequestDispatcher("account.jsp").forward(request, response); // 登陆页面，需要修改
		} else {
			request.getRequestDispatcher("cus_login.jsp").forward(request, response);
		}
	}

}
