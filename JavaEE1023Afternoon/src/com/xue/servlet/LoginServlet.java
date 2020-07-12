package com.xue.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		//获取账号密码键值对
		String account =  request.getParameter("account");
		String password =  request.getParameter("apassword");
		//验证账号密码是否符合格式
		String regexAccount = "[a-zA-Z]{2}[a-zA-Z0-9] {4,}";
		String regexPassword = "[a-zA-Z0-9_]{6,10}";
		boolean accountResult = false;
		boolean passwordResult = false;
		if (account.matches(regexAccount) && password.matches(regexPassword)) {
			accountResult = true;
			passwordResult = true;
			
			
		} else if (account.matches(regexAccount) && password.matches(regexPassword) == false ) {
			accountResult = true;
		} else if (account.matches(regexAccount) == false && password.matches(regexPassword) ) {
			passwordResult = true;
		}
		request.setAttribute("account_res", accountResult);
		request.setAttribute("password_res", passwordResult);
		request.getRequestDispatcher("shop_login.jsp").forward(request, response);;
	}

}
