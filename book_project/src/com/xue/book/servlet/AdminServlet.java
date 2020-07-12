package com.xue.book.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xue.book.model.BookUser;
import com.xue.book.service.BookUserService;
import com.xue.book.serviceImpl.BookUserServiceImpl;
import com.xue.book.util.ValidateCode;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
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
		// TODO 接取flag
		request.setCharacterEncoding("UTF-8");
		String flag = request.getParameter("flag");
//		String randomCode = (String)request.getSession().getAttribute(ValidateCode.RANDOMCODEKEY);
		if ("goindex".equals(flag)) {
			dogoindex(request,response);
		} 
//		else if (condition) {
//			
//		}
	}

	private void dogoindex(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO 接取前端传来的账号密码，进行校验
		String id = request.getParameter("user_id");
		String password = request.getParameter("user_password");
		String autoCode = request.getParameter("auth_code");
		//接取验证码
		HttpSession session = request.getSession();
		String randomCode = (String)session.getAttribute(ValidateCode.RANDOMCODEKEY);
		
		//进行非空验证
		if ("".equals(id)) {
			//如果是空的，给前端一个提示，返回登陆页面
			String alert = "用户名不能为空";
			request.setAttribute("alert", alert);
			request.getRequestDispatcher("book_login.jsp").forward(request, response);
			return;
		}
		if ("".equals(password)) {
			//如果是空的，给前端一个提示，返回登陆页面
			String alert = "密码不能为空";
			request.setAttribute("alert", alert);
			request.getRequestDispatcher("book_login.jsp").forward(request, response);	
			return;
		}
		if ("".equals(autoCode)) {
			//如果是空的，给前端一个提示，返回登陆页面
			String alert = "验证码不能为空";
			request.setAttribute("alert", alert);
			request.getRequestDispatcher("book_login.jsp").forward(request, response);	
			return;
		}
		//3进行账号密码格式校验[正则校验]
	//yonghuming前两位为字母（大小写不限制），后面可以是字母或者数字总长度5-18
		String regName = "[a-zA-Z]{2}[a-zA-Z0-9]{3,16}";
		//密码英文数字不限，总长度6-12位
		String regPassword = "[0-9a-zA-Z]{6,12}";
		//进行用户名和密码校验
		if (!id.matches(regName)) {
			//账号格式不正确，给前端返回提示
			String alert = "账号格式不正确，由5-18为大小写字母或者数字组成，前两位必须为字母";
			request.setAttribute("alert", alert);
			request.getRequestDispatcher("book_login.jsp").forward(request, response);	
			return;
		}
		if (!password.matches(regPassword)) {
			//密码格式不正确，给前端返回提示
			String alert = "密码格式不正确，由6-12为大小写字母或者数字组成";
			request.setAttribute("alert", alert);
			request.getRequestDispatcher("book_login.jsp").forward(request, response);	
			return;
		}
//		if (!"7364".equals(autoCode)) {
//			//密码格式不正确，给前端返回提示
//			String alert = "验证码输入错误";
//			request.setAttribute("alert", alert);
//			request.getRequestDispatcher("book_login.jsp").forward(request, response);	
//			return;
//		}
		//创建对象，调方法，在数据库中查询是否可以登陆
		//校验验证码是否正确
		if (!randomCode.equalsIgnoreCase(autoCode)) {
			//密码格式不正确，给前端返回提示
			String alert = "验证码输入错误";
			request.setAttribute("alert", alert);
			request.getRequestDispatcher("book_login.jsp").forward(request, response);	
			return;
		}
		BookUser b1 = new BookUser();
		b1.setId(id);
		b1.setPassword(password);
		BookUserService bookSer = new BookUserServiceImpl();
		BookUser select = bookSer.select(b1);
		if (select != null && select.getLevel() == 0) { //书城用户
			session = request.getSession();
			session.setAttribute("user", select);
			request.getRequestDispatcher("BookServlet?flag=goindex_user").forward(request, response);//不正确，应该调到书籍后台
		} else if(select != null && select.getLevel() == 1) { //管理员
			session = request.getSession();
			session.setAttribute("user", select);
			request.getRequestDispatcher("BookServlet?flag=goindex_manager").forward(request, response);
		} else {
			String alert = "用户名或者密码不正确";
			request.setAttribute("alert", alert);
			request.getRequestDispatcher("book_login.jsp").forward(request, response);	
			return;
		}
		
		
	}

}
