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
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String flag = request.getParameter("flag");
		if ("goIndex".equals(flag)) {
			//登陆成功后，执行用户的鉴权操作！(二级权限)
			goIndex(request, response);
		}
	}

	private void goIndex(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO 登陆成功后，执行用户的鉴权操作！(二级权限)真多表鉴权！！！！
		//1. 调用用户鉴权的方法！
		PermissionService p1 = new PermissionServiceImpl();
		
		//1.2 从session中获取登陆用户的用户id
		User user = (User)request.getSession().getAttribute("user");
		List<Permission> permissionList = p1.findPermissionByUserId(user.getId());
		
		//2. 将数据打包发送到权限列表中即可！
		request.setAttribute("permissionList", permissionList);
		
		//3. 跳转到权限列表中
		request.getRequestDispatcher("权限列表.jsp").forward(request, response);
	}

}




