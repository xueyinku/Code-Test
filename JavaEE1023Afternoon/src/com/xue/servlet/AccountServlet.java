package com.xue.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AccountServlet
 */
@WebServlet("/AccountServlet")
public class AccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountServlet() {
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
		//获取前端信息
		String from = request.getParameter("from");
		String to = request.getParameter("to");
		String money = request.getParameter("money");
		//判断转账金额是否大于1000，计算手续费
		double commission = 0;
		if (Double.parseDouble(money) > 1000) {
			commission = Double.parseDouble(money) * 0.02;
		} 
		request.setAttribute("from_people", from);
		request.setAttribute("to_people", to);
		request.setAttribute("money", money);
		request.setAttribute("commission", commission);
		request.getRequestDispatcher("account_ok.jsp").forward(request, response);
	}

}
