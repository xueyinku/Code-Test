package com.xue.ajax.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AjaxTestServlet
 */
@WebServlet("/AjaxTestServlet")
public class AjaxTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxTestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		//����ǰ�˴�����json����
		String numOne = request.getParameter("numone");
		System.out.println(numOne);
		String numTwo = request.getParameter("numtwo");
		System.out.println(numTwo);
		String sym = request.getParameter("sym");
		System.out.println(sym);
		//�������ݴ���
		double result = 0;
		if ("+".equals(sym)) {  //��
			result = Integer.parseInt(numOne) + Integer.parseInt(numTwo);
		} else if ("-".equals(sym)) {
			result = Integer.parseInt(numOne) - Integer.parseInt(numTwo);
		} else if ("*".equals(sym)) {
			result = Integer.parseInt(numOne) * Integer.parseInt(numTwo);
		} else if ("/".equals(sym)) {
			result = Integer.parseInt(numOne) / Integer.parseInt(numTwo);
		}
		System.out.println(result);
		//���������ajax����
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().print(result);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
