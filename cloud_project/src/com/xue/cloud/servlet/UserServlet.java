package com.xue.cloud.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xue.cloud.model.User;
import com.xue.cloud.service.UserService;
import com.xue.cloud.serviceImpl.UserServiceImpl;
import com.xue.cloud.util.ValidateCode;

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
		// TODO 
		String flag = request.getParameter("flag");
		if ("logOut".equals(flag)) {
			dologOut(request,response);
		} 
	}


	private void dologOut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO ִ���˳�����
		//���Ȼ�ȡ�� name ��password ��cookie
		Cookie[] cookies = request.getCookies(); 
		if(cookies != null && cookies.length > 0){
			for(int i = 0; i < cookies.length; i++){
				if("nameCookie".equals(cookies[i].getName())){
					cookies[i].setMaxAge(0); //  �ڶ��������˺ŵ���Чʱ������Ϊ0
					cookies[i].setPath("/");//�������� ������Ч·��
					//���Ĳ����������ͻ�����
					response.addCookie(cookies[i]);
				}
				if("passwordCookie".equals(cookies[i].getName())){
					cookies[i].setMaxAge(0);// �ڶ��������������Чʱ������Ϊ0
					cookies[i].setPath("/");//��������������Ч·��
					//���Ĳ����������ͻ�����
					response.addCookie(cookies[i]);
				}
			}
		}
		//���岽�����ص�½ҳ��
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//�����������
		request.setCharacterEncoding("UTF-8");
		String flag = request.getParameter("flag"); // ����flag����
		if ("goindex".equals(flag)) {
			dogoindex(request,response);
		} else if("goregister".equals(flag)) {
			doregister(request,response);
		}
	}

	private void doregister(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO ���� ǰ�˴��������ݣ�ȥ���ݿ��������ݣ�����ֻ�ܼ�type=0����ͨ�û�
		String name = request.getParameter("name"); 
		String password = request.getParameter("password"); //��ֵ
		//������װ��user������
		User user = new User();
		user.setName(name);
		user.setPassword(password);
		user.setType(0);//Ĭ����ͨ�û�
		//������
		UserService us = new UserServiceImpl();
		boolean result = us.insertUser(user);
		if (result) { //ע��ɹ����ص�½ҳ��
			request.getRequestDispatcher("CloudProjectServlet?flag=goindex").forward(request, response);
		} else {  //ע��ʧ�ܷ���һ������ ���û���Ҳ��ռ��
			String alert = " ���û���Ҳ��ռ��";
			request.setAttribute("alert", alert);
			request.getRequestDispatcher("register.jsp").forward(request, response);
		}
	}

	private void dogoindex(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO ��ȡ���ݣ������˺�����У��
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String confirm = request.getParameter("confirm");
		//��ȡ��ѡ���ֵ
		String checkboxRemeberMe = request.getParameter("checkbox_remeberMe");
		//��ȡ��֤��
		HttpSession session = request.getSession();
		String randomCode = (String)session.getAttribute(com.xue.cloud.util.ValidateCode.RANDOMCODEKEY);
		//���зǿ���֤
		if ("".equals(name)) {
		//����ǿյģ���ǰ��һ����ʾ�����ص�½ҳ��
			String alert = "�û�������Ϊ��";
			request.setAttribute("alert", alert);
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
		if ("".equals(password)) {
		//����ǿյģ���ǰ��һ����ʾ�����ص�½ҳ��
			String alert = "���벻��Ϊ��";
			request.setAttribute("alert", alert);
			request.getRequestDispatcher("login.jsp").forward(request, response);	
			return;
		}
		if ("".equals(confirm)) {
			//����ǿյģ���ǰ��һ����ʾ�����ص�½ҳ��
			String alert = "��֤�벻��Ϊ��";
			request.setAttribute("alert", alert);
			request.getRequestDispatcher("login.jsp").forward(request, response);	
			return;
		}
		//2�����˺������ʽУ��,ʡ��
		//3������֤����ȷ��У��
		if (!randomCode.equalsIgnoreCase(confirm)) {
			//�����ʽ����ȷ����ǰ�˷�����ʾ
			String alert = "��֤���������";
			request.setAttribute("alert", alert);
			request.getRequestDispatcher("login.jsp").forward(request, response);	
			return;
		}
		//4�����˺����� У�飬���÷���
		UserService us = new UserServiceImpl();
		User user = us.checkUser(name, password);
		if (user != null ) { //�˺�������ȷ
			//����cookie��һ�����½�cookie����
			Cookie nameCookie = new Cookie("nameCookie", name);//һ��cookieֻ�ܴ��һ����ֵ�����ݣ������˺�������Ҫ����
			Cookie passwordCookie = new Cookie("passwordCookie", password);
			//�жϼ�ס���Ƿ���Ч
			if (checkboxRemeberMe != null) {  //����ס�ұ�ѡ�У�����cookie
				//����cookie�ڶ���������cookie��Чʱ�䳤��
				nameCookie.setMaxAge(60*60*24*7);//����cookie��Чʱ�䳤�ȣ�����*s
				passwordCookie.setMaxAge(60*60*24*7);
				//cookie������������cookie�ķ���·�� /��ʾ�����ļ����ɷ���
				nameCookie.setPath("/");
				passwordCookie.setPath("/");
			} else {  //û��ѡ�Ļ�����cookie��Чʱ�����0s
				nameCookie.setMaxAge(1);//����cookie��Чʱ�䳤�ȣ�����*s
				passwordCookie.setMaxAge(1);
				//cookie������������cookie�ķ���·�� /��ʾ�����ļ����ɷ���
				nameCookie.setPath("/");
				passwordCookie.setPath("/");
			}
			//cookie���Ĳ�����cookie���͵��ͻ��ˣ�ʹ����Ӧ�ķ�ʽ
			response.addCookie(nameCookie);
			response.addCookie(passwordCookie);
			session = request.getSession();
			session.setAttribute("user", user);
			request.getRequestDispatcher("CloudProjectServlet?flag=goindex").forward(request, response);
		} else {
			String alert = "�˺������������";
			request.setAttribute("alert", alert);
			request.getRequestDispatcher("login.jsp").forward(request, response);	
			return;
		}
	}

}
