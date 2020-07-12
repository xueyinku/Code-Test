package com.xue.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CusDaAddServlet
 */
@WebServlet("/CusDaAddServlet")
public class CusDaAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CusDaAddServlet() {
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
		//接受数据
		request.setCharacterEncoding("UTF-8");
		String vipNo = request.getParameter("vip_no");
		String vipName = request.getParameter("user_name");
		String vipScore = request.getParameter("vip_score");
		String vipTel = request.getParameter("vip_tel");
		String vipSex = request.getParameter("sex");
		//准备下面界面的键值对并传给添加成功页面
		request.setAttribute("add_no", vipNo);
		request.setAttribute("add_name", vipName);
		request.setAttribute("add_score", vipScore);
		request.setAttribute("add_tel", vipTel);
		request.setAttribute("add_sex", vipSex);
		request.getRequestDispatcher("cus_insert_ok.jsp").forward(request, response);
	}

}
