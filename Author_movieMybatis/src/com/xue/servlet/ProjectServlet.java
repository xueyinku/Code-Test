package com.xue.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xue.model.ProjectByPage;
import com.xue.service.Impl.ProjectServiceImpl;
import com.xue.service1.ProjectService;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class ProjectServlet
 */
@WebServlet("/ProjectServlet")
public class ProjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProjectServlet() {
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
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String flag = request.getParameter("flag");
		if ("ajaxseletebynameandpage".equals(flag)) {
			doajaxseletebynameandpage(request,response);
		} else {

		}
	}

	private void doajaxseletebynameandpage(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO 执行分页查询功能
		String name = request.getParameter("name");
		String currentPage = request.getParameter("page");
		//tiao方法，查询到该页的信息
		ProjectService ps = new ProjectServiceImpl();
		ProjectByPage projectByPage = ps.selectByNameAndPage(Integer.parseInt(currentPage),name);
		//将结果装到json数据中
		JSONObject json = JSONObject.fromObject(projectByPage);
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().print(json);
	}

}
