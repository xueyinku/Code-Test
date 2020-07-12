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
		// TOD ��ȡflag���ݲ�ͬ��Ϣʹ�ò�ͬ����
		String flag = request.getParameter("flag");
		if ("comfirmname".equals(flag)) {
			gocomfirmname(request,response);
		} else {

		}
		
	}

	private void gocomfirmname(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO ��ȡnameֵ
		String name = request.getParameter("name");
		//����service�㣬ȥ���ݿ�鿴�Ƿ����
		UserService us = new UserServiceImpl();
		boolean result = us.selectExistName(name);
		response.getWriter().print(result);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO ��ȡflag���ݲ�ͬ��Ϣʹ�ò�ͬ����
		String flag = request.getParameter("flag");
		if ("goindex".equals(flag)) {
		 dogoindex(request,response);	
		} else {

		}
	}

	private void dogoindex(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO ��ȡǰ���û��������ȷ�˺�����
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		//װ��user������
		User user = new User();
		user.setName(name);
		user.setPassword(password);
		//����service�����ݿ���������
		UserService us = new UserServiceImpl();
		boolean result = us.insertuser(user);
		if (result) {  //����ɹ���ת��index
			request.getRequestDispatcher("userindex.jsp").forward(request, response);
		} else {
			System.out.println("���ݿ����ʧ��");
		}
	}

}
