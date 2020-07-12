package com.xue.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet1
 */
@WebServlet("/TestServlet1") //ע�⣬�����ŵ��ǻ�����java���ӵ�����
public class TestServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name"); //��ȡ���洫�����ļ�ֵ�ԣ��ü����ӻ����java������ֵΪֵstring����
		String age = request.getParameter("age");
		System.out.println(name); 
		System.out.println(age);
		//��java�Ľ�����ص��������û���������java���ӵ�ǰ�ˣ����ݵ�Ҳ�Ǽ�ֵ�ԣ�����ע����δ����ȥ���������ͣ�
		
		request.setAttribute("javaToJspName",name);
		System.out.println(name + 1);
		request.setAttribute("javaToJspAge",age);
		System.out.println(age + 1);
//		String result = "�û�����Ϊ" + name + "������Ϊ" + age;
//		request.setAttribute("result", result);
		request.getRequestDispatcher("return_message.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
