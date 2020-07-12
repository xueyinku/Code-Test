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
			//���Ա����Ȩ���뵽Ա���б�չʾ����Ա����Ϣ
			goUserIndex(request, response);
		}else if ("goPermissionIndex".equals(flag)) {
			//���Ա����Ӧ����Ȩ�����ӣ����뵽��Ӧ����Ȩҳ��
			goPermissionIndex(request, response);
		}
	}

	private void goPermissionIndex(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO ���Ա����Ӧ����Ȩ�����ӣ����뵽��Ӧ����Ȩҳ��
		//1. ��ֵ
		String userId = request.getParameter("userId");
		//2. ��ѯuserId��Ӧ���м������
		UserPermissionService up = new UserPermissionServiceImpl();
		List<UserPermission> userPermissionList = up.findByUserId(Integer.parseInt(userId));
		//3. ��ѯ���е�Ȩ��
		PermissionService p1 = new PermissionServiceImpl();
		List<Permission> permissionList = p1.findPermission();
		//4. ���������Ϸ��͵������У��������
		request.setAttribute("userPermissionList", userPermissionList);
		request.setAttribute("permissionList", permissionList);
		//5. ��ת��Ա����Ȩҳ��
		request.getRequestDispatcher("Ա����Ȩ.jsp").forward(request, response);
	}

	private void goUserIndex(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO ���Ա����Ȩ���뵽Ա���б�չʾ����Ա����Ϣ
		//1. ��ѯ����Ա��(�û�)
		UserService u1 = new UserServiceImpl();
		List<User> userList = u1.findUser();
		//2. ������ת
		request.setAttribute("userList", userList);
		//3. ��ת
		request.getRequestDispatcher("Ա���б�.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String flag = request.getParameter("flag");
		if ("goIndex".equals(flag)) {
			//ִ���û���Ȩ����ת��Ȩ����ҳ
			goIndex(request, response);
		}
	}

	private void goIndex(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO ִ���û���Ȩ����ת��Ȩ����ҳ
		//1. ��ȡuserId����session��ȡ����½���û���id
		User user = (User)request.getSession().getAttribute("user");
		
		//2. ����userId��ѯ�м�������
		UserPermissionService up = new UserPermissionServiceImpl();
		List<UserPermission> userPermissionList = up.findByUserId(user.getId());
		//��ѯ�����м����½�û���Ӧ������
		
		//3. ��ѯ���е�Ȩ����Ϣ
		PermissionService p1 = new PermissionServiceImpl();
		List<Permission> permissionList = p1.findPermission();
		
		//4. ���������Ϸ��͵������У��������
		request.setAttribute("userPermissionList", userPermissionList);
		request.setAttribute("permissionList", permissionList);
		
		//5. ��ת��Ȩ����ҳ��
		request.getRequestDispatcher("Ȩ���б�.jsp").forward(request, response);
	}
}




