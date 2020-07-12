package com.xue.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet3
 */
@WebServlet("/TestServlet3")
public class TestServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Object calculate_return;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet3() {
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
		//1、获取前端的键值对
		String num1 = request.getParameter("num1");
		String num2 = request.getParameter("num2");
		String symbol = request.getParameter("symbol");
		//2、计算结果
		double result = 0;
		if ("+".equals(symbol)) {
			result = Integer.parseInt(num1) + Integer.parseInt(num2);
		} else if ("-".equals(symbol)) {
			result = Integer.parseInt(num1) - Integer.parseInt(num2);
		} else if ("*".equals(symbol)) {
			result = Integer.parseInt(num1) * Integer.parseInt(num2);
		} else if ("/".equals(symbol)) {
			result = Integer.parseInt(num1) / Integer.parseInt(num2);
		}
		//3、给前端结果准备键值对
		request.setAttribute("calculate", result);
		request.getRequestDispatcher("calculate_return.jsp").forward(request, response);
		
		
	}

}
