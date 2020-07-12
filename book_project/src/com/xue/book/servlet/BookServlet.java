package com.xue.book.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xue.book.model.Book;
import com.xue.book.model.BookPageMes;
import com.xue.book.service.BookService;
import com.xue.book.serviceImpl.BookServiceImpl;

import net.sf.json.JSONArray;
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
		// TODO 接flag，判断之后在调到相应页面
		String flag = request.getParameter("flag");
		if ("goinsert".equals(flag)) {
			doGoinsert(request,response);
		} else if ("goindex_manager".equals(flag)) {
			doIndexManager(request,response);
		} else if ("goindex_user".equals(flag)) {
			doIndexUser(request, response);
		} else if ("gotoupdate".equals(flag)) {
			doUpdate(request, response);//跳转到修改页面，
		} else if ("gotodelete".equals(flag)) {
			doDeleteBook(request, response);
		} else if ("gobuy".equals(flag)) {
			dobuy(request, response);
		} 
	}

	private void dobuy(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO 跳转到购买画面 1.接到书名
		String no = request.getParameter("book_no");
		
		//根据no查出book对象
		BookService bs = new BookServiceImpl();
		Book book = bs.seleteByno(Integer.parseInt(no));
		request.setAttribute("book", book);
		request.getRequestDispatcher("book_buy.jsp").forward(request, response);
	}

	private void doDeleteBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO 1接取jsp的值，
		String bookno = request.getParameter("bookno");
		//将值传到delete画面面
		request.setAttribute("no", bookno);
		request.getRequestDispatcher("book_delete.jsp").forward(request, response);
	}

	private void doUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//跳转到修改页面
		// TODO 1接取jsp的值，
		String bookno = request.getParameter("bookno");
		System.out.println(bookno);
		//根据bookno在数据库中查询到book对象，给updatejsp文件传递值
		BookService bs = new BookServiceImpl();
		Book book = bs.seleteByno(Integer.parseInt(bookno));
		System.out.println(book);
		request.setAttribute("book", book);
		//将值传递到book_update.jsp页面
		request.getRequestDispatcher("book_update.jsp").forward(request, response);
	}

	private void doGoinsert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO 转到insert页面
		request.getRequestDispatcher("book_insert.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO 接收登陆之后是进入哪个系统，并展示信息
		request.setCharacterEncoding("UTF-8");
		String flag = request.getParameter("flag");
		if ("goindex_manager".equals(flag)) {
			doIndexManager(request,response);
		} else if ("goindex_user".equals(flag)) {
			doIndexUser(request,response);
		} else if ("goinsertok".equals(flag)) {
			doInsertBook(request,response);
		} else if ("goupdateok".equals(flag)) {
			//根据jsp数据，去ssql修改book信息，并返回首页
			doupdateok(request,response);
		} else if ("godeleteok".equals(flag)) {
			//根据jsp数据，去ssql删除book信息，并返回首页
			doupdeleteok(request,response);
		} else if ("gobuyok".equals(flag)) {
			//根据jsp数据，查询数量是否小于该数量，小于修改store，返回首页，大于的话返回buy给提示
			dobuyok(request,response);
		} else if ("goselect_by_no_and_name".equals(flag)) {
			//根据jsp数据，查询数量是否小于该数量，小于修改store，返回首页，大于的话返回buy给提示
			doselectbynoandname(request,response);
		} else if ("ajaxdeleteno".equals(flag)) {
			doAjaxDeleteByNo(request,response);
		} else if ("goajaxdeletemany".equals(flag)) {
			doAjaxDeleteMany(request,response);
		}
	}

	private void doAjaxDeleteMany(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO 根据传来的no，删除数据
		String manyno = request.getParameter("manyno");
		String[] nolist = manyno.split(",");//得到需要删除编号的数组
		//调用service方法，进行数据删除
		BookService bs = new BookServiceImpl();
		//需要对删除结果进行验证，所以新建一个计数变量
		int count = 0;
		for (String string : nolist) {    //进行数据库删除工作
			boolean result = bs.delete(Integer.parseInt(string));	
			count++;
		}
		if (count == nolist.length) {  //说明全部删除成功
 			//不需要解决中文乱码，直接ajax引擎中返回true
			response.getWriter().print(true);
		} else {
			response.getWriter().print(false);
		}
		
	}

	private void doAjaxDeleteByNo(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO 执行删除单个数据功能（根据no）
		//接取no
		String no = request.getParameter("no");
		//调用service方法，进行数据删除
		BookService bs = new BookServiceImpl();
		boolean result = bs.delete(Integer.parseInt(no));
		//不需要解决中文乱码，直接响应回去ajax
		response.getWriter().print(result);
	}

	private void doselectbynoandname(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO 首先接收数据，然后根据数据进行模糊查询，将查询到的数据返回
		//接收数据
		String no = request.getParameter("no");
		String name = request.getParameter("name");
		String currentPage = request.getParameter("currentPage");
		//调方法，在数据库中查到响应信息
//		BookService bs = new BookServiceImpl();
//		
//		List<Book>	list = bs.selectByNoAndName(Integer.parseInt(no), name);

//		//接到返回对象，将对象转换层json数组，
//		JSONArray array = JSONArray.fromObject(list);
//		//处理后的数据传回ajax引擎
//		//首先处理响应中文乱码
//		response.setContentType("text/html;charset=UTF-8");
//		response.getWriter().print(array);
		
		
		//根据name no page搜索，先获取当前页面图示信息
		BookService bs = new BookServiceImpl();
		List<Book> listPage = bs.selectByNoAndName(no, name, Integer.parseInt(currentPage));
		
		
		if (listPage == null) {
			BookPageMes bpm = new BookPageMes();
			bpm.setCurrentPage(1);
			JSONObject json = JSONObject.fromObject(bpm);
			response.getWriter().print(json);
		} else {
			//h获取name 和no的所有图书信息，，用于得到总页数
			List<Book> allBooks = bs.selectByNoAndName(no, name, 0);
			int pageNum;
			if (allBooks.size() % BookPageMes.PAGEBOOKNUM == 0) {
				pageNum  = allBooks.size() / BookPageMes.PAGEBOOKNUM;
			} else {
				pageNum  = allBooks.size() / BookPageMes.PAGEBOOKNUM + 1;
			}
			//创建当前页对象
			BookPageMes bpm = new BookPageMes();
			bpm.setBookMes(listPage); //当前页所有book信息
			bpm.setCurrentPage(Integer.parseInt(currentPage)); //当前页num
			bpm.setPageNum(pageNum); //总页数
			bpm.setBookNum(allBooks.size()); //符合条件的book总数
			//返回ajax引擎
			//转成json数据
			JSONObject json = JSONObject.fromObject(bpm);
			//首先解决中文乱码
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().print(json);
		}
		
	}

	private void dobuyok(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO 根据jsp数据，查询数量是否小于该数量，小于修改store，返回首页，大于的话返回buy给提示
		//接取name和store
		String name = request.getParameter("name");
		String count = request.getParameter("store");
		//根据那么查询数量
		BookService bs = new BookServiceImpl();
		Book book = bs.seleteByName(name);
		if (book.getStore() >= Integer.parseInt(count)) {  //大于，就去sql中store减去count
			boolean result = bs.buyBook(book.getNo(), book.getStore() - Integer.parseInt(count));
			if (result) {  //修改完sql数据，返回首页
				doIndexUser(request,response);
			} else {
				System.out.println("数据库删除失败");
				request.getRequestDispatcher("book_buy.jsp").forward(request, response);
			}
		} else {
			request.setAttribute("book", book);
			String alert = "sorry，书内量不足";
			request.setAttribute("alert", alert);
			request.getRequestDispatcher("book_buy.jsp").forward(request, response);
		}
		
	}

	private void doupdeleteok(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO //根据jsp数据，去ssql删除book信息，并返回首页
		String no = request.getParameter("no");
		//创建service，调用方法删除信息
		BookService bs = new BookServiceImpl();
		boolean result = bs.delete(Integer.parseInt(no));
		if (result) {
			doIndexManager(request,response);
		} else {
			String alert = "信息删除失败";
			request.setAttribute("alert", alert);
			request.getRequestDispatcher("book_update.jsp").forward(request, response);
		}
	}

	private void doupdateok(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO 接取jsp数据
		String no = request.getParameter("no");
		String name = request.getParameter("name");
		String author = request.getParameter("author");
		String publish = request.getParameter("publish");
		String price = request.getParameter("price");
		String store = request.getParameter("store");
		//创建对象，装这些信息
		Book book = new Book();
		book.setNo(Integer.parseInt(no));
		book.setName(name);
		book.setAuthor(author);
		book.setPublish(publish);
		book.setPrice(Double.parseDouble(price));
		book.setStore(Integer.parseInt(store));
		//条用服务成方法
		BookService bs = new BookServiceImpl();
		boolean result = bs.update(book); //成功跳到管理首页
		if (result) {
			doIndexManager(request,response);
		} else { //否则返回update画面
			String alert = "信息修改失败";
			request.setAttribute("alert", alert);
			request.getRequestDispatcher("book_update.jsp").forward(request, response);
		}
	}

	private void doInsertBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO gei数据库增加数据，并返回首页，入过增加失败返回本页
		String no = request.getParameter("no");
		String name = request.getParameter("name");
		String author = request.getParameter("author");
		String publish = request.getParameter("publish");
		String price = request.getParameter("price");
		String store = request.getParameter("store");
		//新建book对象，
		Book book = new Book();
		book.setNo(Integer.parseInt(no));
		book.setName(name);
		book.setAuthor(author);
		book.setPublish(publish);
		book.setPrice(Double.parseDouble(price));
		book.setStore(Integer.parseInt(store));
		//调用方法
		BookService bookService = new BookServiceImpl();
		boolean result = bookService.insert(book);
		if (result) {
//			// TODO 查询所有图书数据信息 返回管理端
//			BookService bs = new BookServiceImpl();
//			List<Book> list = bs.selectAll();
//			if (list != null && list.size() > 0) {
//				request.setAttribute("book_mes", list);
//				request.getRequestDispatcher("book_manager_index.jsp").forward(request, response);
//			} else {
//				System.out.println("书籍为空");
//			}
//			String Page = request.getParameter("page");
//			int currentPage;
//			//图书信息分页查询，不能显示全部图书信息，需要显示每页信息；
//			//第一步每页需要显示，1总页数，当前页数，本页包含的图书信息，每页的展示条数
//			//创建每页显示的对象
			BookPageMes bp = new BookPageMes();
//			if (Page != null) {
//				currentPage = Integer.parseInt(Page);
//			} else {
//				currentPage = 1;
//			}
			int currentPage = 1;
			//按照当前页码查询图书信息
			BookService bs = new BookServiceImpl();
			List<Book> listPage = bs.selectByPage(currentPage);
			//获取总页数
			List<Book> all = bs.selectByPage(0);//查询中数据
			int pageNum;
			if (all.size() % BookPageMes.PAGEBOOKNUM == 0) {
				pageNum = all.size() / BookPageMes.PAGEBOOKNUM;
			} else {
				pageNum = all.size() / BookPageMes.PAGEBOOKNUM + 1;
			}
			//装到bookpagemes对象，打包到前端
			bp.setBookMes(listPage);
			bp.setCurrentPage(currentPage);
			bp.setPageNum(pageNum);
			bp.setBookNum(all.size());
			request.setAttribute("bookMes",bp);
			request.getRequestDispatcher("book_manager_index.jsp").forward(request, response);
			
		} else {
			String alert = "添加失败，日期格式为1999-12-12";
			request.setAttribute("alert", alert);
			request.getRequestDispatcher("book_insert.jsp").forward(request, response);
		}
	}

	private void doIndexUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO  查询所有图书数据信息 返回用户
//		BookService bs = new BookServiceImpl();
//		List<Book> list = bs.selectAll();
//		if (list != null && list.size() > 0) {
//			request.setAttribute("book_mes", list);
//			request.getRequestDispatcher("book_user_index.jsp").forward(request, response);
//		} else {
//			System.out.println("书籍为空");
//		}
		
				//接收jsp传来的page数据
				String Page = request.getParameter("page");
				int currentPage;
				//图书信息分页查询，不能显示全部图书信息，需要显示每页信息；
				//第一步每页需要显示，1总页数，当前页数，本页包含的图书信息，每页的展示条数
				//创建每页显示的对象
				BookPageMes bp = new BookPageMes();
				if (Page != null) {
					currentPage = Integer.parseInt(Page);
				} else {
					currentPage = 1;
				}
				
				//按照当前页码查询图书信息
				BookService bs = new BookServiceImpl();
				List<Book> listPage = bs.selectByPage(currentPage);
				//获取总页数
				List<Book> all = bs.selectByPage(0);//查询中数据
				int pageNum;
				if (all.size() % BookPageMes.PAGEBOOKNUM == 0) {
					pageNum = all.size() / BookPageMes.PAGEBOOKNUM;
				} else {
					pageNum = all.size() / BookPageMes.PAGEBOOKNUM + 1;
				}
				//装到bookpagemes对象，打包到前端
				bp.setBookMes(listPage);
				bp.setCurrentPage(currentPage);
				bp.setPageNum(pageNum);
				bp.setBookNum(all.size());
				request.setAttribute("bookMes",bp);
				request.getRequestDispatcher("book_user_index.jsp").forward(request, response);
	}

	private void doIndexManager(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO 查询所有图书数据信息 返回管理端
//		BookService bs = new BookServiceImpl();
//		List<Book> list = bs.selectAll();
//		if (list != null && list.size() > 0) {
//			request.setAttribute("book_mes", list);
//			request.getRequestDispatcher("book_manager_index.jsp").forward(request, response);
//		} else {
//			System.out.println("书籍为空");
//		}
		
		//接收jsp传来的page数据
		String Page = request.getParameter("page");
		int currentPage;
		//图书信息分页查询，不能显示全部图书信息，需要显示每页信息；
		//第一步每页需要显示，1总页数，当前页数，本页包含的图书信息，每页的展示条数
		//创建每页显示的对象
		BookPageMes bp = new BookPageMes();
		if (Page != null) {
			currentPage = Integer.parseInt(Page);
		} else {
			currentPage = 1;
		}
		
		//按照当前页码查询图书信息
		BookService bs = new BookServiceImpl();
		List<Book> listPage = bs.selectByPage(currentPage);
		//获取总页数
		List<Book> all = bs.selectByPage(0);//查询中数据
		int pageNum;
		if (all.size() % BookPageMes.PAGEBOOKNUM == 0) {
			pageNum = all.size() / BookPageMes.PAGEBOOKNUM;
		} else {
			pageNum = all.size() / BookPageMes.PAGEBOOKNUM + 1;
		}
		//装到bookpagemes对象，打包到前端
		bp.setBookMes(listPage);
		bp.setCurrentPage(currentPage);
		bp.setPageNum(pageNum);
		bp.setBookNum(all.size());
		request.setAttribute("bookMes",bp);
		request.getRequestDispatcher("book_manager_index.jsp").forward(request, response);
	}

}
