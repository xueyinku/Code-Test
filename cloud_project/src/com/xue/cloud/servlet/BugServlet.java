package com.xue.cloud.servlet;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xue.cloud.model.BugMes;
import com.xue.cloud.model.Phenomenon;
import com.xue.cloud.model.Str;
import com.xue.cloud.model.BugByPage;
import com.xue.cloud.model.User;
import com.xue.cloud.service.BugService;
import com.xue.cloud.service.PheService;
import com.xue.cloud.service.StrService;
import com.xue.cloud.service.UserService;
import com.xue.cloud.serviceImpl.BugServiceImpl;
import com.xue.cloud.serviceImpl.PheServiceImpl;
import com.xue.cloud.serviceImpl.StrServiceImpl;
import com.xue.cloud.serviceImpl.UserServiceImpl;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class BugServlet
 */
@WebServlet("/BugServlet")
public class BugServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BugServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO 
		String flag = request.getParameter("flag");
		if ("gobugindex".equals(flag)) {
			dogobugindex(request,response);
		} else if ("goselectBugBynamecurrentpageanduser".equals(flag)) {
			dogoselectBugBynamecurrentpageanduser(request,response);
		} else if ("goinsertbug".equals(flag)) {
			dogoinsertbug(request,response);
		} else if ("goBugUpdate".equals(flag)) {
			dogoBugUpdate(request,response);
		} 
	}

	private void dogoBugUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO ת��bugidenxjsp�����Ƚ�ȡbugid��֮��鵽bug������Ϣ����bug���ݴ���bugindex����
		String bugId = request.getParameter("bugid");
		//����bugid��ѯgaibug��Ϣ
		BugService bS = new BugServiceImpl();
		BugMes bugMes = bS.selectBugByBugId(Integer.parseInt(bugId));
		UserService us = new UserServiceImpl();
		List<User> userAll = us.seleteAll();
		StrService ss = new StrServiceImpl();
		List<Str> strAll = ss.selectAll();
		PheService ps = new PheServiceImpl();
		List<Phenomenon> pheAlList = ps.selectAll();
		request.setAttribute("userAll", userAll);
		request.setAttribute("strAll", strAll);
		request.setAttribute("bugMes", bugMes);
		request.setAttribute("pheAlList", pheAlList);
		request.getRequestDispatcher("bug_insert.jsp").forward(request, response);
	}

	private void dogoinsertbug(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO ��ת������bug����
		//��ѯ�����е�user������
		UserService us = new UserServiceImpl();
		List<User> userAll = us.seleteAll();
		PheService ps = new PheServiceImpl();
		List<Phenomenon> pheAlList = ps.selectAll();
		request.setAttribute("userAll", userAll);
		request.setAttribute("pheAlList", pheAlList);
		request.getRequestDispatcher("bug_insert.jsp").forward(request, response);
	}

	private void dogoselectBugBynamecurrentpageanduser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//����proid�Ͳ�ѯ���и���Ŀ��bug��ҳ
		//��ȡproid
		String proId = request.getParameter("proId");
		String name = request.getParameter("name");
		String currentpage = request.getParameter("currentpage");
//		//������һҳ
//		int currentPage = 1;
		int currentPage = Integer.parseInt(currentpage);
		//����bugservice����ķ�������ѯ��һҳ����bug��Ϣ
		BugService bs = new BugServiceImpl();
		List<BugMes> bugPageList = bs.selectByProIdName(Integer.parseInt(proId), currentPage, name);
		//��ѯbug��ҳ��
		//��ѯ�е�bug��Ϣ
		List<BugMes> bugAllList = bs.selectByProIdName(Integer.parseInt(proId), 0, name);
		int pageNum = 0;
		if (bugAllList.size() % BugByPage.PAGEBUGNUM == 0) {
		pageNum = bugAllList.size() / BugByPage.PAGEBUGNUM;
		} else {
			pageNum = bugAllList.size() / BugByPage.PAGEBUGNUM + 1;
		}
		//����userdao����ķ�������������user��Ϣ
		UserService us = new UserServiceImpl();
		List<User> userAllList = us.seleteAll();
		//����Щ��Ϣװ��bugBybug�����У�����bugindex����
		BugByPage bbp = new BugByPage();
		bbp.setCurrentPage(currentPage);
		bbp.setAllUser(userAllList);
		bbp.setBugList(bugPageList);
		bbp.setPagenum(pageNum);
//		//bbp�����͵�bugindex����
//		request.setAttribute("bugByPage", bbp);
//		request.getRequestDispatcher("Bug_index.jsp").forward(request, response);
		//��bpm�����json���ݣ����ͻ�ajax������
		JSONObject json = JSONObject.fromObject(bbp);
		//��Ӧ��������
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().print(json);
	}

	private void dogobugindex(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO �������Ŀ����ת��bugidnexҳ��
		//��ȡproid
		String proId = request.getParameter("proId");
		//��proidװ��session��
		HttpSession session = request.getSession();
		session.setAttribute("proId", proId);
//		request.setAttribute("proId", proId);
		request.getRequestDispatcher("Bug_index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flag = request.getParameter("flag");
		if ("goAjaxdelteBugById".equals(flag)) {
			dogoAjaxdelteBugById(request,response);
		} else if ("goInserBugSql".equals(flag)) {
			dogoInserBugSql(request,response);
		} else if ("goAjaxCloseBug".equals(flag)) {
			dogoAjaxCloseBug(request,response);
		}
	}

	private void dogoAjaxCloseBug(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO ��statetiaowei4
		//��ֵ
		String bugno = request.getParameter("no");
		//����bug��Ž���stage�ı�
		BugService bs = new BugServiceImpl();
		boolean result = bs.uodateBugByNoState(Integer.parseInt(bugno));
		response.getWriter().print(result);
	}

	private void dogoInserBugSql(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO ȥsql������bug��Ϣ����Ҫ��stage�����ó�1
		//��ֵ
		String bugName = request.getParameter("name");
		String bugContent = request.getParameter("content");
		String bugPheId = request.getParameter("phe_id");
		String bugStage = request.getParameter("stage");
		String bugRecord = request.getParameter("record");
		String bugHappTime= request.getParameter("happ_time");
		String proId = request.getParameter("proid");
		//����stateΪ1
		int state = 1;
		//��������Ϣװ��bugmes������
		BugMes bm = new BugMes();
		bm.setName(bugName);
		bm.setPheContent(bugContent);
		bm.setPheId(Integer.parseInt(bugPheId));
		bm.setStage(bugStage);
		bm.setRecoro(Integer.parseInt(bugRecord));
		bm.setHappTime(bugHappTime);
		bm.setState(state);
		System.out.println(proId);
		bm.setProId(Integer.parseInt(proId));
		request.getSession().getServletContext().setAttribute("proId", proId);
		//ʹ��bugservice������
		BugService bs = new BugServiceImpl();
		boolean result = bs.insertBug(bm);
		if (result) {
			//��ת��
			request.getRequestDispatcher("Bug_index.jsp").forward(request, response);
		}
//		else {
//			request.getRequestDispatcher("Bug_index.jsp").forward(request, response);
//		}
	}

	private void dogoAjaxdelteBugById(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO ȥ���ݿ���ɾ����Ӧid ��bug����
		String id = request.getParameter("no");
		//����id���÷�����ɾ������
		BugService bS = new BugServiceImpl();
		boolean result = bS.deleteByBugId(Integer.parseInt(id));
		response.getWriter().print(result);
	}

}
