package com.xue.cloud.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xue.cloud.model.User;
import com.xue.cloud.service.UserService;
import com.xue.cloud.serviceImpl.UserServiceImpl;
import com.xue.cloud.util.ValidateCode;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO 
		String flag = request.getParameter("flag");
		if ("logOut".equals(flag)) {
			dologOut(request,response);
		} 
	}


	private void dologOut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO 执行退出操作
		//首先获取到 name 和password 的cookie
		Cookie[] cookies = request.getCookies(); 
		if(cookies != null && cookies.length > 0){
			for(int i = 0; i < cookies.length; i++){
				if("nameCookie".equals(cookies[i].getName())){
					cookies[i].setMaxAge(0); //  第二步、将账号的有效时长设置为0
					cookies[i].setPath("/");//第三步、 设置有效路径
					//第四部，发布到客户端中
					response.addCookie(cookies[i]);
				}
				if("passwordCookie".equals(cookies[i].getName())){
					cookies[i].setMaxAge(0);// 第二步、将密码的有效时长设置为0
					cookies[i].setPath("/");//第三步、设置有效路径
					//第四部，发布到客户端中
					response.addCookie(cookies[i]);
				}
			}
		}
		//第五步，返回登陆页面
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//解决中文乱码
		request.setCharacterEncoding("UTF-8");
		String flag = request.getParameter("flag"); // 接收flag数据
		if ("goindex".equals(flag)) {
			dogoindex(request,response);
		} else if("goregister".equals(flag)) {
			doregister(request,response);
		}
	}

	private void doregister(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO 根据 前端传来的数据，去数据库增加数据，但是只能加type=0即普通用户
		String name = request.getParameter("name"); 
		String password = request.getParameter("password"); //接值
		//将数据装到user对象中
		User user = new User();
		user.setName(name);
		user.setPassword(password);
		user.setType(0);//默认普通用户
		//调方法
		UserService us = new UserServiceImpl();
		boolean result = us.insertUser(user);
		if (result) { //注册成功返回登陆页面
			request.getRequestDispatcher("CloudProjectServlet?flag=goindex").forward(request, response);
		} else {  //注册失败返回一个梯形 该用户名也被占用
			String alert = " 该用户名也被占用";
			request.setAttribute("alert", alert);
			request.getRequestDispatcher("register.jsp").forward(request, response);
		}
	}

	private void dogoindex(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO 接取数据，进行账号密码校验
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String confirm = request.getParameter("confirm");
		//接取复选框的值
		String checkboxRemeberMe = request.getParameter("checkbox_remeberMe");
		//接取验证码
		HttpSession session = request.getSession();
		String randomCode = (String)session.getAttribute(com.xue.cloud.util.ValidateCode.RANDOMCODEKEY);
		//进行非空验证
		if ("".equals(name)) {
		//如果是空的，给前端一个提示，返回登陆页面
			String alert = "用户名不能为空";
			request.setAttribute("alert", alert);
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
		if ("".equals(password)) {
		//如果是空的，给前端一个提示，返回登陆页面
			String alert = "密码不能为空";
			request.setAttribute("alert", alert);
			request.getRequestDispatcher("login.jsp").forward(request, response);	
			return;
		}
		if ("".equals(confirm)) {
			//如果是空的，给前端一个提示，返回登陆页面
			String alert = "验证码不能为空";
			request.setAttribute("alert", alert);
			request.getRequestDispatcher("login.jsp").forward(request, response);	
			return;
		}
		//2进行账号密码格式校验,省略
		//3进行验证码正确性校验
		if (!randomCode.equalsIgnoreCase(confirm)) {
			//密码格式不正确，给前端返回提示
			String alert = "验证码输入错误";
			request.setAttribute("alert", alert);
			request.getRequestDispatcher("login.jsp").forward(request, response);	
			return;
		}
		//4进行账号密码 校验，调用方法
		UserService us = new UserServiceImpl();
		User user = us.checkUser(name, password);
		if (user != null ) { //账号密码正确
			//创建cookie第一步，新建cookie对象
			Cookie nameCookie = new Cookie("nameCookie", name);//一个cookie只能存放一个键值对数据，所以账号密码需要两个
			Cookie passwordCookie = new Cookie("passwordCookie", password);
			//判断记住我是否有效
			if (checkboxRemeberMe != null) {  //当记住我被选中，创建cookie
				//创建cookie第二步，设置cookie有效时间长度
				nameCookie.setMaxAge(60*60*24*7);//设置cookie有效时间长度，（）*s
				passwordCookie.setMaxAge(60*60*24*7);
				//cookie第三步，设置cookie的访问路径 /表示所有文件都可访问
				nameCookie.setPath("/");
				passwordCookie.setPath("/");
			} else {  //没勾选的话，将cookie有效时间调成0s
				nameCookie.setMaxAge(1);//设置cookie有效时间长度，（）*s
				passwordCookie.setMaxAge(1);
				//cookie第三步，设置cookie的访问路径 /表示所有文件都可访问
				nameCookie.setPath("/");
				passwordCookie.setPath("/");
			}
			//cookie第四步，将cookie发送到客户端，使用响应的方式
			response.addCookie(nameCookie);
			response.addCookie(passwordCookie);
			session = request.getSession();
			session.setAttribute("user", user);
			request.getRequestDispatcher("CloudProjectServlet?flag=goindex").forward(request, response);
		} else {
			String alert = "账号密码输入错误";
			request.setAttribute("alert", alert);
			request.getRequestDispatcher("login.jsp").forward(request, response);	
			return;
		}
	}

}
