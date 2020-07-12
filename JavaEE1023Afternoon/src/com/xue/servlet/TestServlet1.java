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
@WebServlet("/TestServlet1") //注解，里面存放的是画面与java连接的名称
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
		String name = request.getParameter("name"); //接取画面传回来的键值对，用键连接画面和java，返回值为值string类型
		String age = request.getParameter("age");
		System.out.println(name); 
		System.out.println(age);
		//将java的结果返回到画面让用户看到；将java链接到前端；传递的也是键值对，但是注意这次传输过去的数据类型；
		
		request.setAttribute("javaToJspName",name);
		System.out.println(name + 1);
		request.setAttribute("javaToJspAge",age);
		System.out.println(age + 1);
//		String result = "用户姓名为" + name + "，年龄为" + age;
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
