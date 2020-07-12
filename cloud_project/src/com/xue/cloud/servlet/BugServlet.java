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
		// TODO 转到bugidenxjsp，首先接取bugid，之后查到bug所有信息，将bug数据传到bugindex画面
		String bugId = request.getParameter("bugid");
		//根据bugid查询gaibug信息
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
		// TODO 跳转到增加bug画面
		//查询到所有的user和现象
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
		//根据proid和查询所有该项目的bug按页
		//接取proid
		String proId = request.getParameter("proId");
		String name = request.getParameter("name");
		String currentpage = request.getParameter("currentpage");
//		//创建第一页
//		int currentPage = 1;
		int currentPage = Integer.parseInt(currentpage);
		//调用bugservice里面的方法，查询第一页所有bug信息
		BugService bs = new BugServiceImpl();
		List<BugMes> bugPageList = bs.selectByProIdName(Integer.parseInt(proId), currentPage, name);
		//查询bug总页数
		//查询中的bug信息
		List<BugMes> bugAllList = bs.selectByProIdName(Integer.parseInt(proId), 0, name);
		int pageNum = 0;
		if (bugAllList.size() % BugByPage.PAGEBUGNUM == 0) {
		pageNum = bugAllList.size() / BugByPage.PAGEBUGNUM;
		} else {
			pageNum = bugAllList.size() / BugByPage.PAGEBUGNUM + 1;
		}
		//调用userdao里面的方法，调查所有user信息
		UserService us = new UserServiceImpl();
		List<User> userAllList = us.seleteAll();
		//将这些信息装到bugBybug对象中，传到bugindex画面
		BugByPage bbp = new BugByPage();
		bbp.setCurrentPage(currentPage);
		bbp.setAllUser(userAllList);
		bbp.setBugList(bugPageList);
		bbp.setPagenum(pageNum);
//		//bbp对象发送到bugindex画面
//		request.setAttribute("bugByPage", bbp);
//		request.getRequestDispatcher("Bug_index.jsp").forward(request, response);
		//将bpm打包成json数据，发送回ajax引擎中
		JSONObject json = JSONObject.fromObject(bbp);
		//响应中文乱码
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().print(json);
	}

	private void dogobugindex(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO 当点击项目，跳转到bugidnex页面
		//接取proid
		String proId = request.getParameter("proId");
		//将proid装到session中
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
		// TODO 将statetiaowei4
		//接值
		String bugno = request.getParameter("no");
		//根据bug标号进行stage改编
		BugService bs = new BugServiceImpl();
		boolean result = bs.uodateBugByNoState(Integer.parseInt(bugno));
		response.getWriter().print(result);
	}

	private void dogoInserBugSql(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO 去sql中增加bug信息，需要将stage是设置成1
		//接值
		String bugName = request.getParameter("name");
		String bugContent = request.getParameter("content");
		String bugPheId = request.getParameter("phe_id");
		String bugStage = request.getParameter("stage");
		String bugRecord = request.getParameter("record");
		String bugHappTime= request.getParameter("happ_time");
		String proId = request.getParameter("proid");
		//设置state为1
		int state = 1;
		//将上述信息装到bugmes对象中
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
		//使用bugservice调方法
		BugService bs = new BugServiceImpl();
		boolean result = bs.insertBug(bm);
		if (result) {
			//跳转到
			request.getRequestDispatcher("Bug_index.jsp").forward(request, response);
		}
//		else {
//			request.getRequestDispatcher("Bug_index.jsp").forward(request, response);
//		}
	}

	private void dogoAjaxdelteBugById(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO 去数据库中删除对应id 的bug数据
		String id = request.getParameter("no");
		//根据id调用方法，删除数据
		BugService bS = new BugServiceImpl();
		boolean result = bS.deleteByBugId(Integer.parseInt(id));
		response.getWriter().print(result);
	}

}
