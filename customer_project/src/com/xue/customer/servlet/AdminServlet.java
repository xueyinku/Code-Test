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
		// TODO �����û�ע��
		String flag = request.getParameter("flag");
		if ("gotoregister".equals(flag)) {
			doGoToRegister(request,response);
		} else if ("gotologin".equals(flag)) {
			request.getRequestDispatcher("cus_login.jsp").forward(request, response);
		}
	}

	private void doGoToRegister(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO ֱ��װ��ע��ҳ��
		request.getRequestDispatcher("cus_register.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO ���е�½У��
		request.setCharacterEncoding("UTF-8");
		String flag = request.getParameter("flag");
		if ("gotoindex".equals(flag)) {
			dogoindexcheck(request,response);
		} else if ("gotoregisterok".equals(flag)) {
			doGoToRegisterOk(request,response);
		}
	}

	private void doGoToRegisterOk(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO ����ȷ���Ƿ�Ϊ�գ�֮���ж��Ƿ�����˺ź������ʽ��Ȼ����֤ȷ�������Ƿ���������ͬ
		//��ȡֵ
		String name = request.getParameter("admin_name");
		String password = request.getParameter("admin_password");
		String conPassword = request.getParameter("confirm_password");
		//��ֵ�ж�
		if ("".equals(name)) {
			String alert = "�û�������Ϊ��";
			request.setAttribute("alert", alert);
			request.getRequestDispatcher("cus_register.jsp").forward(request, response);
			return;
		}
		if ("".equals(password)) {
			String alert = "���벻��Ϊ��";
			request.setAttribute("alert", alert);
			request.getRequestDispatcher("cus_register.jsp").forward(request, response);
			return;
		}
		//3�����˺������ʽУ��[����У��]
		//yonghumingǰ��λΪ��ĸ����Сд�����ƣ��������������ĸ���������ܳ���5-18
			String regName = "[a-zA-Z]{2}[a-zA-Z0-9]{3,16}";
			//����Ӣ�����ֲ��ޣ��ܳ���6-12λ
			String regPassword = "[0-9a-zA-Z]{6,12}";
			//�����û���������У��
			if (!name.matches(regName)) {
				//�˺Ÿ�ʽ����ȷ����ǰ�˷�����ʾ
				String alert = "�˺Ÿ�ʽ����ȷ����5-18Ϊ��Сд��ĸ����������ɣ�ǰ��λ����Ϊ��ĸ";
				request.setAttribute("alert", alert);
				request.getRequestDispatcher("cus_register.jsp").forward(request, response);	
				return;
			}
			if (!password.matches(regPassword)) {
				//�����ʽ����ȷ����ǰ�˷�����ʾ
				String alert = "�����ʽ����ȷ����6-12Ϊ��Сд��ĸ�����������";
				request.setAttribute("alert", alert);
				request.getRequestDispatcher("cus_register.jsp").forward(request, response);	
				return;
			}
			//����ȷ������������Ƿ�һ��У��
			if (!password.equals(conPassword)) {
				String alert = "�����������벻һ��";
				request.setAttribute("alert", alert);
				request.getRequestDispatcher("cus_register.jsp").forward(request, response);	
				return;
			}
			//�����ݿ��������û�Ȩ����Ϣ��������registerokҳ��
			//���ȴ���admin����
			Admin adminAdd = new Admin();
			adminAdd.setName(name);
			adminAdd.setPassword(password);
			//����service���󣬵����÷����������ݿ���������
			AdminService a1 = new AdminServiceImpl();
			boolean result = a1.addAdmin(adminAdd);
			if (result) {
				//�ɹ���ֵ����okҳ�棬����ת
				request.setAttribute("admin_name", name);
				request.getRequestDispatcher("cus_register_ok.jsp").forward(request, response);
			} else {
				//ʧ�ܣ�����registerҳ�棬��ʾ�û����ѱ�ռ��
				String alert = "�û����ѱ�ռ��";
				request.setAttribute("alert", alert);
				request.getRequestDispatcher("cus_register.jsp").forward(request, response);	
			}
	}

	private void dogoindexcheck(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO ���е�½У��
		//��ȡadmin_name��admin����password
		String adminName = request.getParameter("admin_name");
		String adminPassword = request.getParameter("admin_password");
		//2���зǿ�У��
		if ("".equals(adminName)) {
			//����ǿյģ���ǰ��һ����ʾ�����ص�½ҳ��
			String alert = "�û�������Ϊ��";
			request.setAttribute("alert", alert);
			request.getRequestDispatcher("cus_login.jsp").forward(request, response);
			return;
		}
		if ("".equals(adminPassword)) {
			//����ǿյģ���ǰ��һ����ʾ�����ص�½ҳ��
			String alert = "���벻��Ϊ��";
			request.setAttribute("alert", alert);
			request.getRequestDispatcher("cus_login.jsp").forward(request, response);	
			return;
		}
		//3�����˺������ʽУ��[����У��]
	//yonghumingǰ��λΪ��ĸ����Сд�����ƣ��������������ĸ���������ܳ���5-18
		String regName = "[a-zA-Z]{2}[a-zA-Z0-9]{3,16}";
		//����Ӣ�����ֲ��ޣ��ܳ���6-12λ
		String regPassword = "[0-9a-zA-Z]{6,12}";
		//�����û���������У��
		if (!adminName.matches(regName)) {
			//�˺Ÿ�ʽ����ȷ����ǰ�˷�����ʾ
			String alert = "�˺Ÿ�ʽ����ȷ����5-18Ϊ��Сд��ĸ����������ɣ�ǰ��λ����Ϊ��ĸ";
			request.setAttribute("alert", alert);
			request.getRequestDispatcher("cus_login.jsp").forward(request, response);	
			return;
		}
		if (!adminPassword.matches(regPassword)) {
			//�����ʽ����ȷ����ǰ�˷�����ʾ
			String alert = "�����ʽ����ȷ����6-12Ϊ��Сд��ĸ�����������";
			request.setAttribute("alert", alert);
			request.getRequestDispatcher("cus_login.jsp").forward(request, response);	
			return;
		}
		//�������ݿ�У��
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
			String alert = "�û������������������";
			request.setAttribute("alert", alert);
			request.getRequestDispatcher("cus_login.jsp").forward(request, response);	
			return;
		}
	}
}
