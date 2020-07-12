package com.xue.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CusDoupdateServlet
 */
@WebServlet("/CusDoupdateServlet")
public class CusDoupdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CusDoupdateServlet() {
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
		String updaNo = request.getParameter("update_no");
		String updaName = request.getParameter("update_name");
		String updaScore = request.getParameter("update_score");
		String updaTel = request.getParameter("update_tel");
		String updaSex = request.getParameter("sex1");
		request.setAttribute("upda_no", updaNo);
		request.setAttribute("upda_name", updaName);
		request.setAttribute("upda_score", updaScore);
		request.setAttribute("upda_tel", updaTel);
		request.setAttribute("upda_sex", updaSex);
		System.out.println(updaSex);
		request.getRequestDispatcher("cus_update_ok.jsp").forward(request, response);
	}

}
