package com.xue.cloud.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xue.cloud.model.Project;
import com.xue.cloud.model.ProjectByPage;
import com.xue.cloud.model.User;
import com.xue.cloud.service.ProjectService;
import com.xue.cloud.service.UserService;
import com.xue.cloud.serviceImpl.ProjectServiceImpl;
import com.xue.cloud.serviceImpl.UserServiceImpl;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class CloudProjectServlet
 */
@WebServlet("/CloudProjectServlet")
public class CloudProjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CloudProjectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO 
		request.setCharacterEncoding("UTF-8");
		String flag = request.getParameter("flag");
		if ("goaddproject".equals(flag)) {
			dogoaddproject(request,response);
		} else if ("goupdateproject".equals(flag)) {
			dogoupdateproject(request,response);
		} else if ("goindexNoCheck7".equals(flag)) {
			dogoindexNoCheck7(request,response);
		}
	}


	private void dogoindexNoCheck7(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO ִ��7�����½
		//1��cookie�е�����װ��session��
		//�������cookie�е����ݽ��е�½У�飬����ڿͽ����޸�
		//1ȡ����cookie�е�����
		Cookie[] cookies = request.getCookies(); 
		String userCookieName = "";
		String userCookiePassword = "";
		if(cookies != null && cookies.length > 0){
			for(int i = 0; i < cookies.length; i++){
				if("nameCookie".equals(cookies[i].getName())){
					userCookieName =  cookies[i].getValue(); //ȡ���˺�
				}
				if("passwordCookie".equals(cookies[i].getName())){
					userCookiePassword =  cookies[i].getValue();//ȡ������
				}
			}
		}
		//2����У��
		UserService us = new UserServiceImpl();
		User user = us.checkUser(userCookieName, userCookiePassword);
		if (user != null ) { //�˺�������ȷ
			//�����װ����session�У�����indexҳ
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			request.getRequestDispatcher("cloud_index.jsp").forward(request, response);
		} else {
			//֤��cookie�����´۸�,���ص�½ҳ��
			response.sendRedirect("login.jsp"); //�ض��򣬷��ص�½ҳ��
		}
		
	}
	private void dogoupdateproject(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO ������Ŀid��ѯ��Ŀ��Ϣ����ѯ����user������updateandinsert����
		String proId = request.getParameter("proid");
		ProjectService ps = new ProjectServiceImpl();
		Project projectMes = ps.selecrByProId(Integer.parseInt(proId));
		// TODO ��ѯ���е���Ŀ�����ˣ�����updateandinsert����
		UserService us = new UserServiceImpl();
		List<User> userList = us.seleteAll();
		//�����е���Ŀ�������ǰ��
		request.setAttribute("userList", userList);
		request.setAttribute("projectMes", projectMes);
		request.getRequestDispatcher("cloud_update_insert.jsp").forward(request, response);
	}

	private void dogoaddproject(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO ��ѯ���е���Ŀ�����ˣ�����updateandinsert����
		UserService us = new UserServiceImpl();
		List<User> userList = us.seleteAll();
		//�����е���Ŀ�������ǰ��
		request.setAttribute("userList", userList);
		request.getRequestDispatcher("cloud_update_insert.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//�����������
		request.setCharacterEncoding("UTF-8");
		String flag = request.getParameter("flag");
		if ("goindex".equals(flag)) {
			dogoindex(request,response);
		} else if ("ajaxseletebynameandpage".equals(flag)) {
			doajaxseletebynameandpage(request,response);
		} else if ("goAjaxdelteByNo".equals(flag)) {
			dogoAjaxdelteByNo(request,response);
		} else if ("goinsertpro".equals(flag)) {
			dogoinsertpro(request,response);
		} else if ("goupdatepro".equals(flag)) {
			dogoupdatepro(request, response);
		}
	}

	private void dogoupdatepro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO ���ݴ�����ֵ��ȥsql��������
		String projectName = request.getParameter("project_name");
		String projectStartTime= request.getParameter("project_starttime");
		String projectEndTime = request.getParameter("project_endtime");
		String hearer = request.getParameter("hearer");
		String proid = request.getParameter("proid");
		//����Щ��Ϣװ��project������
		Project pro = new Project();
		pro.setId(Integer.parseInt(proid));
		pro.setName(projectName);
		pro.setStarttime(projectStartTime);
		pro.setEndtime(projectEndTime);
		pro.setHearer(Integer.parseInt(hearer));
		//���������������ݿ�����
		ProjectService ps = new ProjectServiceImpl();
		boolean result = ps.updateProById(pro);
//		if (result) {
//			System.out.println("�ɹ�");
//		request.getRequestDispatcher("cloud_update_insert.jsp").forward(request, response);
//		} else {
//			System.out.println("ʧ��");
//		request.getRequestDispatcher("cloud_update_insert.jsp").forward(request, response);
//		}
		request.setAttribute("result", result);
		request.getRequestDispatcher("cloud_update_insert.jsp").forward(request, response);
	}

	private void dogoinsertpro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO ������װ�����ݿ��У����Ƚ�ȡ����
		String projectName = request.getParameter("project_name");
		String projectStartTime= request.getParameter("project_starttime");
		String projectEndTime = request.getParameter("project_endtime");
		String hearer = request.getParameter("hearer");
		//����Щ��Ϣװ��project������
		Project pro = new Project();
		pro.setName(projectName);
		pro.setStarttime(projectStartTime);
		pro.setEndtime(projectEndTime);
		pro.setHearer(Integer.parseInt(hearer));
		//���������������ݿ�����
		ProjectService ps = new ProjectServiceImpl();
		boolean result = ps.insert(pro);
//		if (result) {
//			System.out.println("�ɹ�");
//		} else {
//			System.out.println("ʧ��");
//		}
		request.setAttribute("result", result);
		request.getRequestDispatcher("cloud_update_insert.jsp").forward(request, response);
	}

	private void dogoAjaxdelteByNo(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO ���ݴ�����id�����ݿ���ɾ����Ŀ��Ϣ
		String projectNo = request.getParameter("no");
		//��������ɾ����Ϣ
		ProjectService ps = new ProjectServiceImpl();
		boolean result = ps.delete(Integer.parseInt(projectNo));
		if (result) { //ɾ���ɹ�����һ��ɾ���ɹ���Ϣ������index����
			//��Ӧ��������
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().print(result);
		} else {
			response.getWriter().print(result);
		}
		
	}

	private void doajaxseletebynameandpage(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO����ajax���������ݽ��в�ѯ
		String name = request.getParameter("name");
		String page = request.getParameter("page");
		//���÷�����ѯÿҳ��Ϣ
		//1��浽��ҳprojectmessage
		ProjectService ps = new ProjectServiceImpl();
		List<Project> listPage = ps.selectByNameAndpage(name, Integer.parseInt(page)); //ÿҳ��Ŀ��Ϣ
		//������ҳ��
		List<Project> allProMes = ps.selectByNameAndpage(name, 0);
		int pageNum = 0;
		if (allProMes.size() % ProjectByPage.PAGEBOOKNUM == 0) {
			pageNum = allProMes.size() / ProjectByPage.PAGEBOOKNUM; 
		} else {
			pageNum = allProMes.size() / ProjectByPage.PAGEBOOKNUM + 1;
		}
		//��ѯ����userxinxi 
		UserService us = new UserServiceImpl();
		List<User> userAll = us.seleteAll();
		//����Щ���ݴ����ProjectByPage
		ProjectByPage pbg = new ProjectByPage();
		pbg.setCurrentPage(Integer.parseInt(page));
		pbg.setAllUser(userAll);
		pbg.setPagenum(pageNum);
		pbg.setProject(listPage);
		//��pbgת����json����
		JSONObject json = JSONObject.fromObject(pbg);
		//��Ӧ��������
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().print(json);
	}

	private void dogoindex(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO ��ת��indexҳ��
		request.getRequestDispatcher("cloud_index.jsp").forward(request, response);
	}

}
