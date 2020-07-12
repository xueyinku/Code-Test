package com.asjy.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.asjy.model.BookPage;
import com.asjy.service.BookService;
import com.asjy.service.impl.BookServiceImpl;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class BookServlet
 */
@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String flag = request.getParameter("flag");
		if ("findBookByPage".equals(flag)) {
			//执行Ajax条件+分页查询
			findBookByPage(request, response);
		}
	}

	private void findBookByPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO 执行Ajax条件+分页查询
		//1. 接取参数
		String bookId = request.getParameter("bookId");
		String bookName = request.getParameter("bookName");
		String currentPage = request.getParameter("currentPage");
		//2. 控制层只负责接取参数，调用方法，返回画面，其余一概放到业务层处理
		//只需调用一个方法，就能直接返回画面 --> 返回Json(分页对象)
		BookService b1 = new BookServiceImpl();
		BookPage bp = b1.findBookByPage(bookId, bookName, Integer.parseInt(currentPage));
		//3. 将分页对象转换成Json
		JSONObject json = JSONObject.fromObject(bp);
		//4. 响应
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().print(json);
	}

}
