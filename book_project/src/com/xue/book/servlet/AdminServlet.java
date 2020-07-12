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
		// TODO ��ȡflag
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
		// TODO ��ȡǰ�˴������˺����룬����У��
		String id = request.getParameter("user_id");
		String password = request.getParameter("user_password");
		String autoCode = request.getParameter("auth_code");
		//��ȡ��֤��
		HttpSession session = request.getSession();
		String randomCode = (String)session.getAttribute(ValidateCode.RANDOMCODEKEY);
		
		//���зǿ���֤
		if ("".equals(id)) {
			//����ǿյģ���ǰ��һ����ʾ�����ص�½ҳ��
			String alert = "�û�������Ϊ��";
			request.setAttribute("alert", alert);
			request.getRequestDispatcher("book_login.jsp").forward(request, response);
			return;
		}
		if ("".equals(password)) {
			//����ǿյģ���ǰ��һ����ʾ�����ص�½ҳ��
			String alert = "���벻��Ϊ��";
			request.setAttribute("alert", alert);
			request.getRequestDispatcher("book_login.jsp").forward(request, response);	
			return;
		}
		if ("".equals(autoCode)) {
			//����ǿյģ���ǰ��һ����ʾ�����ص�½ҳ��
			String alert = "��֤�벻��Ϊ��";
			request.setAttribute("alert", alert);
			request.getRequestDispatcher("book_login.jsp").forward(request, response);	
			return;
		}
		//3�����˺������ʽУ��[����У��]
	//yonghumingǰ��λΪ��ĸ����Сд�����ƣ��������������ĸ���������ܳ���5-18
		String regName = "[a-zA-Z]{2}[a-zA-Z0-9]{3,16}";
		//����Ӣ�����ֲ��ޣ��ܳ���6-12λ
		String regPassword = "[0-9a-zA-Z]{6,12}";
		//�����û���������У��
		if (!id.matches(regName)) {
			//�˺Ÿ�ʽ����ȷ����ǰ�˷�����ʾ
			String alert = "�˺Ÿ�ʽ����ȷ����5-18Ϊ��Сд��ĸ����������ɣ�ǰ��λ����Ϊ��ĸ";
			request.setAttribute("alert", alert);
			request.getRequestDispatcher("book_login.jsp").forward(request, response);	
			return;
		}
		if (!password.matches(regPassword)) {
			//�����ʽ����ȷ����ǰ�˷�����ʾ
			String alert = "�����ʽ����ȷ����6-12Ϊ��Сд��ĸ�����������";
			request.setAttribute("alert", alert);
			request.getRequestDispatcher("book_login.jsp").forward(request, response);	
			return;
		}
//		if (!"7364".equals(autoCode)) {
//			//�����ʽ����ȷ����ǰ�˷�����ʾ
//			String alert = "��֤���������";
//			request.setAttribute("alert", alert);
//			request.getRequestDispatcher("book_login.jsp").forward(request, response);	
//			return;
//		}
		//�������󣬵������������ݿ��в�ѯ�Ƿ���Ե�½
		//У����֤���Ƿ���ȷ
		if (!randomCode.equalsIgnoreCase(autoCode)) {
			//�����ʽ����ȷ����ǰ�˷�����ʾ
			String alert = "��֤���������";
			request.setAttribute("alert", alert);
			request.getRequestDispatcher("book_login.jsp").forward(request, response);	
			return;
		}
		BookUser b1 = new BookUser();
		b1.setId(id);
		b1.setPassword(password);
		BookUserService bookSer = new BookUserServiceImpl();
		BookUser select = bookSer.select(b1);
		if (select != null && select.getLevel() == 0) { //����û�
			session = request.getSession();
			session.setAttribute("user", select);
			request.getRequestDispatcher("BookServlet?flag=goindex_user").forward(request, response);//����ȷ��Ӧ�õ����鼮��̨
		} else if(select != null && select.getLevel() == 1) { //����Ա
			session = request.getSession();
			session.setAttribute("user", select);
			request.getRequestDispatcher("BookServlet?flag=goindex_manager").forward(request, response);
		} else {
			String alert = "�û����������벻��ȷ";
			request.setAttribute("alert", alert);
			request.getRequestDispatcher("book_login.jsp").forward(request, response);	
			return;
		}
		
		
	}

}
