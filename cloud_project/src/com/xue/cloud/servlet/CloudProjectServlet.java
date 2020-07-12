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
		// TODO 执行7天免登陆
		//1把cookie中的数据装到session中
		//建议相对cookie中的数据进行登陆校验，以免黑客进行修改
		//1取出来cookie中的数据
		Cookie[] cookies = request.getCookies(); 
		String userCookieName = "";
		String userCookiePassword = "";
		if(cookies != null && cookies.length > 0){
			for(int i = 0; i < cookies.length; i++){
				if("nameCookie".equals(cookies[i].getName())){
					userCookieName =  cookies[i].getValue(); //取出账号
				}
				if("passwordCookie".equals(cookies[i].getName())){
					userCookiePassword =  cookies[i].getValue();//取出密码
				}
			}
		}
		//2重新校验
		UserService us = new UserServiceImpl();
		User user = us.checkUser(userCookieName, userCookiePassword);
		if (user != null ) { //账号密码正确
			//将结果装到到session中，返回index页
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			request.getRequestDispatcher("cloud_index.jsp").forward(request, response);
		} else {
			//证明cookie数据呗篡改,返回登陆页面
			response.sendRedirect("login.jsp"); //重定向，返回登陆页面
		}
		
	}
	private void dogoupdateproject(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO 根据项目id查询项目信息，查询所有user，返回updateandinsert画面
		String proId = request.getParameter("proid");
		ProjectService ps = new ProjectServiceImpl();
		Project projectMes = ps.selecrByProId(Integer.parseInt(proId));
		// TODO 查询所有的项目负责人，返回updateandinsert画面
		UserService us = new UserServiceImpl();
		List<User> userList = us.seleteAll();
		//将所有的项目打包发到前端
		request.setAttribute("userList", userList);
		request.setAttribute("projectMes", projectMes);
		request.getRequestDispatcher("cloud_update_insert.jsp").forward(request, response);
	}

	private void dogoaddproject(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO 查询所有的项目负责人，返回updateandinsert画面
		UserService us = new UserServiceImpl();
		List<User> userList = us.seleteAll();
		//将所有的项目打包发到前端
		request.setAttribute("userList", userList);
		request.getRequestDispatcher("cloud_update_insert.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//解决中文乱码
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
		// TODO 根据传来的值，去sql更新数据
		String projectName = request.getParameter("project_name");
		String projectStartTime= request.getParameter("project_starttime");
		String projectEndTime = request.getParameter("project_endtime");
		String hearer = request.getParameter("hearer");
		String proid = request.getParameter("proid");
		//将这些信息装到project对象中
		Project pro = new Project();
		pro.setId(Integer.parseInt(proid));
		pro.setName(projectName);
		pro.setStarttime(projectStartTime);
		pro.setEndtime(projectEndTime);
		pro.setHearer(Integer.parseInt(hearer));
		//掉方法，更新数据库数据
		ProjectService ps = new ProjectServiceImpl();
		boolean result = ps.updateProById(pro);
//		if (result) {
//			System.out.println("成功");
//		request.getRequestDispatcher("cloud_update_insert.jsp").forward(request, response);
//		} else {
//			System.out.println("失败");
//		request.getRequestDispatcher("cloud_update_insert.jsp").forward(request, response);
//		}
		request.setAttribute("result", result);
		request.getRequestDispatcher("cloud_update_insert.jsp").forward(request, response);
	}

	private void dogoinsertpro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO 将数据装到数据库中，首先接取数据
		String projectName = request.getParameter("project_name");
		String projectStartTime= request.getParameter("project_starttime");
		String projectEndTime = request.getParameter("project_endtime");
		String hearer = request.getParameter("hearer");
		//将这些信息装到project对象中
		Project pro = new Project();
		pro.setName(projectName);
		pro.setStarttime(projectStartTime);
		pro.setEndtime(projectEndTime);
		pro.setHearer(Integer.parseInt(hearer));
		//掉方法，更新数据库数据
		ProjectService ps = new ProjectServiceImpl();
		boolean result = ps.insert(pro);
//		if (result) {
//			System.out.println("成功");
//		} else {
//			System.out.println("失败");
//		}
		request.setAttribute("result", result);
		request.getRequestDispatcher("cloud_update_insert.jsp").forward(request, response);
	}

	private void dogoAjaxdelteByNo(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO 根据传来的id在数据库中删除项目信息
		String projectNo = request.getParameter("no");
		//调方法，删除信息
		ProjectService ps = new ProjectServiceImpl();
		boolean result = ps.delete(Integer.parseInt(projectNo));
		if (result) { //删除成功，传一个删除成功信息，返回index画面
			//响应中文乱码
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().print(result);
		} else {
			response.getWriter().print(result);
		}
		
	}

	private void doajaxseletebynameandpage(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO根据ajax传来的数据进行查询
		String name = request.getParameter("name");
		String page = request.getParameter("page");
		//调用方法查询每页信息
		//1差存到单页projectmessage
		ProjectService ps = new ProjectServiceImpl();
		List<Project> listPage = ps.selectByNameAndpage(name, Integer.parseInt(page)); //每页项目信息
		//计算总页数
		List<Project> allProMes = ps.selectByNameAndpage(name, 0);
		int pageNum = 0;
		if (allProMes.size() % ProjectByPage.PAGEBOOKNUM == 0) {
			pageNum = allProMes.size() / ProjectByPage.PAGEBOOKNUM; 
		} else {
			pageNum = allProMes.size() / ProjectByPage.PAGEBOOKNUM + 1;
		}
		//查询所有userxinxi 
		UserService us = new UserServiceImpl();
		List<User> userAll = us.seleteAll();
		//将这些内容打包到ProjectByPage
		ProjectByPage pbg = new ProjectByPage();
		pbg.setCurrentPage(Integer.parseInt(page));
		pbg.setAllUser(userAll);
		pbg.setPagenum(pageNum);
		pbg.setProject(listPage);
		//将pbg转换成json数据
		JSONObject json = JSONObject.fromObject(pbg);
		//响应中文乱码
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().print(json);
	}

	private void dogoindex(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO 跳转到index页面
		request.getRequestDispatcher("cloud_index.jsp").forward(request, response);
	}

}
