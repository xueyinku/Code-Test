package com.asjy.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.asjy.model.Permission;
import com.asjy.model.User;
import com.asjy.model.UserPermission;
import com.asjy.service.PermissionService;
import com.asjy.service.UserPermissionService;
import com.asjy.service.UserService;
import com.asjy.service.impl.PermissionServiceImpl;
import com.asjy.service.impl.UserPermissionServiceImpl;
import com.asjy.service.impl.UserServiceImpl;

/**
 * Servlet implementation class PermissionServlet
 */
@WebServlet("/PermissionServlet")
public class PermissionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PermissionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flag = request.getParameter("flag");
		if ("goUserIndex".equals(flag)) {
			//点击员工授权进入到员工列表！展示所有员工信息
			goUserIndex(request, response);
		}else if ("goPermissionIndex".equals(flag)) {
			//点击员工对应的授权超链接，进入到对应的授权页面
			goPermissionIndex(request, response);
		}
	}

	private void goPermissionIndex(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO 点击员工对应的授权超链接，进入到对应的授权页面
		//1. 接值
		String userId = request.getParameter("userId");
		//2. 查询userId对应的中间表数据
		UserPermissionService up = new UserPermissionServiceImpl();
		List<UserPermission> userPermissionList = up.findByUserId(Integer.parseInt(userId));
		//3. 查询所有的权限
		PermissionService p1 = new PermissionServiceImpl();
		List<Permission> permissionList = p1.findPermission();
		//4. 将两个集合发送到画面中，画面关联
		request.setAttribute("userPermissionList", userPermissionList);
		request.setAttribute("permissionList", permissionList);
		//5. 跳转到员工授权页面
		request.getRequestDispatcher("员工授权.jsp").forward(request, response);
	}

	private void goUserIndex(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO 点击员工授权进入到员工列表！展示所有员工信息
		//1. 查询所有员工(用户)
		UserService u1 = new UserServiceImpl();
		List<User> userList = u1.findUser();
		//2. 发送跳转
		request.setAttribute("userList", userList);
		//3. 跳转
		request.getRequestDispatcher("员工列表.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String flag = request.getParameter("flag");
		if ("goIndex".equals(flag)) {
			//执行用户鉴权并跳转到权限首页
			goIndex(request, response);
		}
	}

	private void goIndex(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO 执行用户鉴权并跳转到权限首页
		//1. 获取userId：从session中取出登陆的用户的id
		User user = (User)request.getSession().getAttribute("user");
		
		//2. 根据userId查询中间表的数据
		UserPermissionService up = new UserPermissionServiceImpl();
		List<UserPermission> userPermissionList = up.findByUserId(user.getId());
		//查询的是中间表，登陆用户对应的数据
		
		//3. 查询所有的权限信息
		PermissionService p1 = new PermissionServiceImpl();
		List<Permission> permissionList = p1.findPermission();
		
		//4. 将两个集合发送到画面中，画面关联
		request.setAttribute("userPermissionList", userPermissionList);
		request.setAttribute("permissionList", permissionList);
		
		//5. 跳转到权限首页！
		request.getRequestDispatcher("权限列表.jsp").forward(request, response);
	}
}




