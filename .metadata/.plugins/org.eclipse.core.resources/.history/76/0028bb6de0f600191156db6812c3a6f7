package com.asjy.customer.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.asjy.customer.model.Customer;
import com.asjy.customer.service.CustomerService;
import com.asjy.customer.service.impl.CustomerServiceImpl;

/**
 * Servlet implementation class CustomerServlet
 */
@WebServlet("/CustomerServlet")
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flag = request.getParameter("flag");
		if ("goInsert".equals(flag)) {
			//点击添加超链接，跳转到添加画面！
			request.getRequestDispatcher("customer_insert.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		
		//1. 接取flag判断画面如何跳转
		String flag = request.getParameter("flag");
		if ("goIndex".equals(flag)) {
			//点击登陆按钮，跳转到首页中！
			//由于首页中需要展示数据库数据，所以先全查询数据库数据，发送到首页
			//1. 调用查询方法(调用service中的全查询方法)
			CustomerService c1 = new CustomerServiceImpl();
			List<Customer> cusList = c1.findCustomer();
			//2. 发送到画面中
			request.setAttribute("cusList", cusList);
			//3. 跳转到页面
			request.getRequestDispatcher("customer_index.jsp").forward(request, response);
		}else if ("doInsert".equals(flag)) {
			//执行添加功能！将数据存储到数据库中！
			//1. 接取画面数据
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			String score = request.getParameter("score");
			String tel = request.getParameter("tel");
			String sex = request.getParameter("sex");
			//1.2 将数据打包到实体类对象中！
			Customer customer = new Customer();
			customer.setId(Integer.parseInt(id));
			customer.setName(name);
			customer.setScore(Double.parseDouble(score));
			customer.setTel(tel);
			customer.setSex(sex);
			
			//2. 调用对应方法即可！(调用方法)
			CustomerService c1 = new CustomerServiceImpl();
			boolean result = c1.insertCustomer(customer);
			//ctrl + 2 选择第2个可以快速接取方法返回值
			
			//3. 判断是否添加成功！
			if (result) {
				//添加成功，跳转到添加成功画面！
				//添加成功页面需要展示添加信息，所以需要发送添加信息到成功画面
				request.setAttribute("customer", customer);
				request.getRequestDispatcher("customer_insertok.jsp").forward(request, response);
			}else {
				//添加失败，重新跳转回添加画面！
				request.getRequestDispatcher("customer_insert.jsp").forward(request, response);
			}
			
			/*
			 * 常用快捷键：
			 * 		alt + ↑ / ↓		快速移动当前行代码
			 * 		ctrl + z		撤销
			 * 		ctrl + y		恢复
			 * 		ctrl + d		删除当前行
			 * 		ctrl + w		关闭当前窗口
			 * 		ctrl + alt + =	快速复制当前行
			 * 
			 * 		win + l			快速锁屏
			 * 		win + d			快速回到桌面
			 * 		win + e			快速打开我的电脑
			 */
		}
	}

}
