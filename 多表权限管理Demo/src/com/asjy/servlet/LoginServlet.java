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
			//��½��֤
			doLogin(request, response);
		}
	}

	private void doLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO ��½��֤��
		//1. ��ȡ����
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		//2. �ǿ�У��
		//3. ��ʽУ��
		//4. ��Ч��У��
		UserService u1 = new UserServiceImpl();
		User user = new User();
		user.setName(name);
		user.setPassword(password);
		User result = u1.login(user);
		if (result == null) {
			//��ת�ص�¼ҳ
			System.out.println("��½ʧ��");
		}
		//5. ��½�ɹ����û�װ��session��
		request.getSession().setAttribute("user", result);
		//6. ��ת��PermissionServlet�У������û���Ȩ
		request.getRequestDispatcher("PermissionServlet?flag=goIndex").forward(request, response);
	}
}





