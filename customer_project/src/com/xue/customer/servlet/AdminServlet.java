package com.xue.customer.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xue.custom.model.Admin;
import com.xue.customer.service.AdminService;
import com.xue.customer.srrvice.Impl.AdminServiceImpl;

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
		// TODO 进行用户注册
		String flag = request.getParameter("flag");
		if ("gotoregister".equals(flag)) {
			doGoToRegister(request,response);
		} else if ("gotologin".equals(flag)) {
			request.getRequestDispatcher("cus_login.jsp").forward(request, response);
		}
	}

	private void doGoToRegister(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO 直接装到注册页面
		request.getRequestDispatcher("cus_register.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO 进行登陆校验
		request.setCharacterEncoding("UTF-8");
		String flag = request.getParameter("flag");
		if ("gotoindex".equals(flag)) {
			dogoindexcheck(request,response);
		} else if ("gotoregisterok".equals(flag)) {
			doGoToRegisterOk(request,response);
		}
	}

	private void doGoToRegisterOk(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO 首先确认是否为空，之后判断是否符合账号和密码格式，然后验证确认密码是否与密码相同
		//接取值
		String name = request.getParameter("admin_name");
		String password = request.getParameter("admin_password");
		String conPassword = request.getParameter("confirm_password");
		//空值判断
		if ("".equals(name)) {
			String alert = "用户名不能为空";
			request.setAttribute("alert", alert);
			request.getRequestDispatcher("cus_register.jsp").forward(request, response);
			return;
		}
		if ("".equals(password)) {
			String alert = "密码不能为空";
			request.setAttribute("alert", alert);
			request.getRequestDispatcher("cus_register.jsp").forward(request, response);
			return;
		}
		//3进行账号密码格式校验[正则校验]
		//yonghuming前两位为字母（大小写不限制），后面可以是字母或者数字总长度5-18
			String regName = "[a-zA-Z]{2}[a-zA-Z0-9]{3,16}";
			//密码英文数字不限，总长度6-12位
			String regPassword = "[0-9a-zA-Z]{6,12}";
			//进行用户名和密码校验
			if (!name.matches(regName)) {
				//账号格式不正确，给前端返回提示
				String alert = "账号格式不正确，由5-18为大小写字母或者数字组成，前两位必须为字母";
				request.setAttribute("alert", alert);
				request.getRequestDispatcher("cus_register.jsp").forward(request, response);	
				return;
			}
			if (!password.matches(regPassword)) {
				//密码格式不正确，给前端返回提示
				String alert = "密码格式不正确，由6-12为大小写字母或者数字组成";
				request.setAttribute("alert", alert);
				request.getRequestDispatcher("cus_register.jsp").forward(request, response);	
				return;
			}
			//进行确认密码和密码是否一致校验
			if (!password.equals(conPassword)) {
				String alert = "两次密码输入不一致";
				request.setAttribute("alert", alert);
				request.getRequestDispatcher("cus_register.jsp").forward(request, response);	
				return;
			}
			//新数据库中增加用户权限信息，并传到registerok页面
			//首先创建admin对象
			Admin adminAdd = new Admin();
			adminAdd.setName(name);
			adminAdd.setPassword(password);
			//创建service对象，调调用方法，给数据库增加数据
			AdminService a1 = new AdminServiceImpl();
			boolean result = a1.addAdmin(adminAdd);
			if (result) {
				//成功将值传给ok页面，并跳转
				request.setAttribute("admin_name", name);
				request.getRequestDispatcher("cus_register_ok.jsp").forward(request, response);
			} else {
				//失败，返回register页面，提示用户名已被占用
				String alert = "用户名已被占用";
				request.setAttribute("alert", alert);
				request.getRequestDispatcher("cus_register.jsp").forward(request, response);	
			}
	}

	private void dogoindexcheck(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO 进行登陆校验
		//接取admin_name和admin——password
		String adminName = request.getParameter("admin_name");
		String adminPassword = request.getParameter("admin_password");
		//2进行非空校验
		if ("".equals(adminName)) {
			//如果是空的，给前端一个提示，返回登陆页面
			String alert = "用户名不能为空";
			request.setAttribute("alert", alert);
			request.getRequestDispatcher("cus_login.jsp").forward(request, response);
			return;
		}
		if ("".equals(adminPassword)) {
			//如果是空的，给前端一个提示，返回登陆页面
			String alert = "密码不能为空";
			request.setAttribute("alert", alert);
			request.getRequestDispatcher("cus_login.jsp").forward(request, response);	
			return;
		}
		//3进行账号密码格式校验[正则校验]
	//yonghuming前两位为字母（大小写不限制），后面可以是字母或者数字总长度5-18
		String regName = "[a-zA-Z]{2}[a-zA-Z0-9]{3,16}";
		//密码英文数字不限，总长度6-12位
		String regPassword = "[0-9a-zA-Z]{6,12}";
		//进行用户名和密码校验
		if (!adminName.matches(regName)) {
			//账号格式不正确，给前端返回提示
			String alert = "账号格式不正确，由5-18为大小写字母或者数字组成，前两位必须为字母";
			request.setAttribute("alert", alert);
			request.getRequestDispatcher("cus_login.jsp").forward(request, response);	
			return;
		}
		if (!adminPassword.matches(regPassword)) {
			//密码格式不正确，给前端返回提示
			String alert = "密码格式不正确，由6-12为大小写字母或者数字组成";
			request.setAttribute("alert", alert);
			request.getRequestDispatcher("cus_login.jsp").forward(request, response);	
			return;
		}
		//进行数据库校验
		Admin admin = new Admin();
		admin.setName(adminName);
		admin.setPassword(adminPassword);
		AdminService a1 = new AdminServiceImpl();
		Admin select = a1.select(admin);
				
		if (select != null ) {
			HttpSession session = request.getSession();
			session.setAttribute("admin", admin);
			request.getRequestDispatcher("CustomerServlet?flag=gotoindex").forward(request, response);
		} else {
			String alert = "用户名或者密码输入错误";
			request.setAttribute("alert", alert);
			request.getRequestDispatcher("cus_login.jsp").forward(request, response);	
			return;
		}
	}
}
