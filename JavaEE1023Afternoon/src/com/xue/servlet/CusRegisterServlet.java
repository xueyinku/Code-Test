package com.xue.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CusRegisterServlet
 */
@WebServlet("/CusRegisterServlet")
public class CusRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CusRegisterServlet() {
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
		//����ǰ�˴������ֻ����롢���롢��֤����
		String tel = request.getParameter("tel");
		String new_pasword = request.getParameter("new_pasword");
		String con_pasword = request.getParameter("con_pasword");
		System.out.println(tel);
		System.out.println(new_pasword);
		System.out.println(con_pasword);
		//����Ϣ����У��ɹ�����ע��ɹ�ҳ�棬���򷵻�ǰ�˵�ǰҳ��
		String reg = "[0-9]{11}";
		if (tel.matches(reg) && new_pasword.equals(con_pasword)) {
			request.setAttribute("user_tel", tel);
			request.getRequestDispatcher("cus_register_ok.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("cus_register.jsp").forward(request, response);
		}
	}

}
