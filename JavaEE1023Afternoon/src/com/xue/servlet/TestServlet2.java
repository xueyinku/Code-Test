package com.xue.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet2
 */
@WebServlet("/userMessage")
public class TestServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet2() {
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
		//建立联系,huoqu键值对数据
		request.setCharacterEncoding("UTF-8");
		String userName =  request.getParameter("user_name");
		String firit = request.getParameter("firit");
		String evaluate = request.getParameter("evaluate");
		//解决传输到dopost中文乱码问题
//		request.setCharacterEncoding("UTF-8");
		//将结果返回画面
		String result = "用户姓名：" + userName + "最喜欢的水果为：" + firit + "，理由" +  evaluate;
		request.setAttribute("usermes", result);
		request.getRequestDispatcher("usermessage_firit.jsp").forward(request, response);
		//将返回值创建键值对
		
		System.out.println(result);
//		request.setAttribute("firitchoose", firit);
//		System.out.println(firit);
//		request.setAttribute("yuanyin", evaluate);
//		System.out.println(evaluate);
	}

}
