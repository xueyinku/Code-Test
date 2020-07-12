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
		// TODO ��flag���ж�֮���ڵ�����Ӧҳ��
		String flag = request.getParameter("flag");
		if ("goinsert".equals(flag)) {
			doGoinsert(request,response);
		} else if ("goindex_manager".equals(flag)) {
			doIndexManager(request,response);
		} else if ("goindex_user".equals(flag)) {
			doIndexUser(request, response);
		} else if ("gotoupdate".equals(flag)) {
			doUpdate(request, response);//��ת���޸�ҳ�棬
		} else if ("gotodelete".equals(flag)) {
			doDeleteBook(request, response);
		} else if ("gobuy".equals(flag)) {
			dobuy(request, response);
		} 
	}

	private void dobuy(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO ��ת�������� 1.�ӵ�����
		String no = request.getParameter("book_no");
		
		//����no���book����
		BookService bs = new BookServiceImpl();
		Book book = bs.seleteByno(Integer.parseInt(no));
		request.setAttribute("book", book);
		request.getRequestDispatcher("book_buy.jsp").forward(request, response);
	}

	private void doDeleteBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO 1��ȡjsp��ֵ��
		String bookno = request.getParameter("bookno");
		//��ֵ����delete������
		request.setAttribute("no", bookno);
		request.getRequestDispatcher("book_delete.jsp").forward(request, response);
	}

	private void doUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//��ת���޸�ҳ��
		// TODO 1��ȡjsp��ֵ��
		String bookno = request.getParameter("bookno");
		System.out.println(bookno);
		//����bookno�����ݿ��в�ѯ��book���󣬸�updatejsp�ļ�����ֵ
		BookService bs = new BookServiceImpl();
		Book book = bs.seleteByno(Integer.parseInt(bookno));
		System.out.println(book);
		request.setAttribute("book", book);
		//��ֵ���ݵ�book_update.jspҳ��
		request.getRequestDispatcher("book_update.jsp").forward(request, response);
	}

	private void doGoinsert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO ת��insertҳ��
		request.getRequestDispatcher("book_insert.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO ���յ�½֮���ǽ����ĸ�ϵͳ����չʾ��Ϣ
		request.setCharacterEncoding("UTF-8");
		String flag = request.getParameter("flag");
		if ("goindex_manager".equals(flag)) {
			doIndexManager(request,response);
		} else if ("goindex_user".equals(flag)) {
			doIndexUser(request,response);
		} else if ("goinsertok".equals(flag)) {
			doInsertBook(request,response);
		} else if ("goupdateok".equals(flag)) {
			//����jsp���ݣ�ȥssql�޸�book��Ϣ����������ҳ
			doupdateok(request,response);
		} else if ("godeleteok".equals(flag)) {
			//����jsp���ݣ�ȥssqlɾ��book��Ϣ����������ҳ
			doupdeleteok(request,response);
		} else if ("gobuyok".equals(flag)) {
			//����jsp���ݣ���ѯ�����Ƿ�С�ڸ�������С���޸�store��������ҳ�����ڵĻ�����buy����ʾ
			dobuyok(request,response);
		} else if ("goselect_by_no_and_name".equals(flag)) {
			//����jsp���ݣ���ѯ�����Ƿ�С�ڸ�������С���޸�store��������ҳ�����ڵĻ�����buy����ʾ
			doselectbynoandname(request,response);
		} else if ("ajaxdeleteno".equals(flag)) {
			doAjaxDeleteByNo(request,response);
		} else if ("goajaxdeletemany".equals(flag)) {
			doAjaxDeleteMany(request,response);
		}
	}

	private void doAjaxDeleteMany(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO ���ݴ�����no��ɾ������
		String manyno = request.getParameter("manyno");
		String[] nolist = manyno.split(",");//�õ���Ҫɾ����ŵ�����
		//����service��������������ɾ��
		BookService bs = new BookServiceImpl();
		//��Ҫ��ɾ�����������֤�������½�һ����������
		int count = 0;
		for (String string : nolist) {    //�������ݿ�ɾ������
			boolean result = bs.delete(Integer.parseInt(string));	
			count++;
		}
		if (count == nolist.length) {  //˵��ȫ��ɾ���ɹ�
 			//����Ҫ����������룬ֱ��ajax�����з���true
			response.getWriter().print(true);
		} else {
			response.getWriter().print(false);
		}
		
	}

	private void doAjaxDeleteByNo(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO ִ��ɾ���������ݹ��ܣ�����no��
		//��ȡno
		String no = request.getParameter("no");
		//����service��������������ɾ��
		BookService bs = new BookServiceImpl();
		boolean result = bs.delete(Integer.parseInt(no));
		//����Ҫ����������룬ֱ����Ӧ��ȥajax
		response.getWriter().print(result);
	}

	private void doselectbynoandname(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO ���Ƚ������ݣ�Ȼ��������ݽ���ģ����ѯ������ѯ�������ݷ���
		//��������
		String no = request.getParameter("no");
		String name = request.getParameter("name");
		String currentPage = request.getParameter("currentPage");
		//�������������ݿ��в鵽��Ӧ��Ϣ
//		BookService bs = new BookServiceImpl();
//		
//		List<Book>	list = bs.selectByNoAndName(Integer.parseInt(no), name);

//		//�ӵ����ض��󣬽�����ת����json���飬
//		JSONArray array = JSONArray.fromObject(list);
//		//����������ݴ���ajax����
//		//���ȴ�����Ӧ��������
//		response.setContentType("text/html;charset=UTF-8");
//		response.getWriter().print(array);
		
		
		//����name no page�������Ȼ�ȡ��ǰҳ��ͼʾ��Ϣ
		BookService bs = new BookServiceImpl();
		List<Book> listPage = bs.selectByNoAndName(no, name, Integer.parseInt(currentPage));
		
		
		if (listPage == null) {
			BookPageMes bpm = new BookPageMes();
			bpm.setCurrentPage(1);
			JSONObject json = JSONObject.fromObject(bpm);
			response.getWriter().print(json);
		} else {
			//h��ȡname ��no������ͼ����Ϣ�������ڵõ���ҳ��
			List<Book> allBooks = bs.selectByNoAndName(no, name, 0);
			int pageNum;
			if (allBooks.size() % BookPageMes.PAGEBOOKNUM == 0) {
				pageNum  = allBooks.size() / BookPageMes.PAGEBOOKNUM;
			} else {
				pageNum  = allBooks.size() / BookPageMes.PAGEBOOKNUM + 1;
			}
			//������ǰҳ����
			BookPageMes bpm = new BookPageMes();
			bpm.setBookMes(listPage); //��ǰҳ����book��Ϣ
			bpm.setCurrentPage(Integer.parseInt(currentPage)); //��ǰҳnum
			bpm.setPageNum(pageNum); //��ҳ��
			bpm.setBookNum(allBooks.size()); //����������book����
			//����ajax����
			//ת��json����
			JSONObject json = JSONObject.fromObject(bpm);
			//���Ƚ����������
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().print(json);
		}
		
	}

	private void dobuyok(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO ����jsp���ݣ���ѯ�����Ƿ�С�ڸ�������С���޸�store��������ҳ�����ڵĻ�����buy����ʾ
		//��ȡname��store
		String name = request.getParameter("name");
		String count = request.getParameter("store");
		//������ô��ѯ����
		BookService bs = new BookServiceImpl();
		Book book = bs.seleteByName(name);
		if (book.getStore() >= Integer.parseInt(count)) {  //���ڣ���ȥsql��store��ȥcount
			boolean result = bs.buyBook(book.getNo(), book.getStore() - Integer.parseInt(count));
			if (result) {  //�޸���sql���ݣ�������ҳ
				doIndexUser(request,response);
			} else {
				System.out.println("���ݿ�ɾ��ʧ��");
				request.getRequestDispatcher("book_buy.jsp").forward(request, response);
			}
		} else {
			request.setAttribute("book", book);
			String alert = "sorry������������";
			request.setAttribute("alert", alert);
			request.getRequestDispatcher("book_buy.jsp").forward(request, response);
		}
		
	}

	private void doupdeleteok(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO //����jsp���ݣ�ȥssqlɾ��book��Ϣ����������ҳ
		String no = request.getParameter("no");
		//����service�����÷���ɾ����Ϣ
		BookService bs = new BookServiceImpl();
		boolean result = bs.delete(Integer.parseInt(no));
		if (result) {
			doIndexManager(request,response);
		} else {
			String alert = "��Ϣɾ��ʧ��";
			request.setAttribute("alert", alert);
			request.getRequestDispatcher("book_update.jsp").forward(request, response);
		}
	}

	private void doupdateok(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO ��ȡjsp����
		String no = request.getParameter("no");
		String name = request.getParameter("name");
		String author = request.getParameter("author");
		String publish = request.getParameter("publish");
		String price = request.getParameter("price");
		String store = request.getParameter("store");
		//��������װ��Щ��Ϣ
		Book book = new Book();
		book.setNo(Integer.parseInt(no));
		book.setName(name);
		book.setAuthor(author);
		book.setPublish(publish);
		book.setPrice(Double.parseDouble(price));
		book.setStore(Integer.parseInt(store));
		//���÷���ɷ���
		BookService bs = new BookServiceImpl();
		boolean result = bs.update(book); //�ɹ�����������ҳ
		if (result) {
			doIndexManager(request,response);
		} else { //���򷵻�update����
			String alert = "��Ϣ�޸�ʧ��";
			request.setAttribute("alert", alert);
			request.getRequestDispatcher("book_update.jsp").forward(request, response);
		}
	}

	private void doInsertBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO gei���ݿ��������ݣ���������ҳ���������ʧ�ܷ��ر�ҳ
		String no = request.getParameter("no");
		String name = request.getParameter("name");
		String author = request.getParameter("author");
		String publish = request.getParameter("publish");
		String price = request.getParameter("price");
		String store = request.getParameter("store");
		//�½�book����
		Book book = new Book();
		book.setNo(Integer.parseInt(no));
		book.setName(name);
		book.setAuthor(author);
		book.setPublish(publish);
		book.setPrice(Double.parseDouble(price));
		book.setStore(Integer.parseInt(store));
		//���÷���
		BookService bookService = new BookServiceImpl();
		boolean result = bookService.insert(book);
		if (result) {
//			// TODO ��ѯ����ͼ��������Ϣ ���ع�����
//			BookService bs = new BookServiceImpl();
//			List<Book> list = bs.selectAll();
//			if (list != null && list.size() > 0) {
//				request.setAttribute("book_mes", list);
//				request.getRequestDispatcher("book_manager_index.jsp").forward(request, response);
//			} else {
//				System.out.println("�鼮Ϊ��");
//			}
//			String Page = request.getParameter("page");
//			int currentPage;
//			//ͼ����Ϣ��ҳ��ѯ��������ʾȫ��ͼ����Ϣ����Ҫ��ʾÿҳ��Ϣ��
//			//��һ��ÿҳ��Ҫ��ʾ��1��ҳ������ǰҳ������ҳ������ͼ����Ϣ��ÿҳ��չʾ����
//			//����ÿҳ��ʾ�Ķ���
			BookPageMes bp = new BookPageMes();
//			if (Page != null) {
//				currentPage = Integer.parseInt(Page);
//			} else {
//				currentPage = 1;
//			}
			int currentPage = 1;
			//���յ�ǰҳ���ѯͼ����Ϣ
			BookService bs = new BookServiceImpl();
			List<Book> listPage = bs.selectByPage(currentPage);
			//��ȡ��ҳ��
			List<Book> all = bs.selectByPage(0);//��ѯ������
			int pageNum;
			if (all.size() % BookPageMes.PAGEBOOKNUM == 0) {
				pageNum = all.size() / BookPageMes.PAGEBOOKNUM;
			} else {
				pageNum = all.size() / BookPageMes.PAGEBOOKNUM + 1;
			}
			//װ��bookpagemes���󣬴����ǰ��
			bp.setBookMes(listPage);
			bp.setCurrentPage(currentPage);
			bp.setPageNum(pageNum);
			bp.setBookNum(all.size());
			request.setAttribute("bookMes",bp);
			request.getRequestDispatcher("book_manager_index.jsp").forward(request, response);
			
		} else {
			String alert = "����ʧ�ܣ����ڸ�ʽΪ1999-12-12";
			request.setAttribute("alert", alert);
			request.getRequestDispatcher("book_insert.jsp").forward(request, response);
		}
	}

	private void doIndexUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO  ��ѯ����ͼ��������Ϣ �����û�
//		BookService bs = new BookServiceImpl();
//		List<Book> list = bs.selectAll();
//		if (list != null && list.size() > 0) {
//			request.setAttribute("book_mes", list);
//			request.getRequestDispatcher("book_user_index.jsp").forward(request, response);
//		} else {
//			System.out.println("�鼮Ϊ��");
//		}
		
				//����jsp������page����
				String Page = request.getParameter("page");
				int currentPage;
				//ͼ����Ϣ��ҳ��ѯ��������ʾȫ��ͼ����Ϣ����Ҫ��ʾÿҳ��Ϣ��
				//��һ��ÿҳ��Ҫ��ʾ��1��ҳ������ǰҳ������ҳ������ͼ����Ϣ��ÿҳ��չʾ����
				//����ÿҳ��ʾ�Ķ���
				BookPageMes bp = new BookPageMes();
				if (Page != null) {
					currentPage = Integer.parseInt(Page);
				} else {
					currentPage = 1;
				}
				
				//���յ�ǰҳ���ѯͼ����Ϣ
				BookService bs = new BookServiceImpl();
				List<Book> listPage = bs.selectByPage(currentPage);
				//��ȡ��ҳ��
				List<Book> all = bs.selectByPage(0);//��ѯ������
				int pageNum;
				if (all.size() % BookPageMes.PAGEBOOKNUM == 0) {
					pageNum = all.size() / BookPageMes.PAGEBOOKNUM;
				} else {
					pageNum = all.size() / BookPageMes.PAGEBOOKNUM + 1;
				}
				//װ��bookpagemes���󣬴����ǰ��
				bp.setBookMes(listPage);
				bp.setCurrentPage(currentPage);
				bp.setPageNum(pageNum);
				bp.setBookNum(all.size());
				request.setAttribute("bookMes",bp);
				request.getRequestDispatcher("book_user_index.jsp").forward(request, response);
	}

	private void doIndexManager(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO ��ѯ����ͼ��������Ϣ ���ع�����
//		BookService bs = new BookServiceImpl();
//		List<Book> list = bs.selectAll();
//		if (list != null && list.size() > 0) {
//			request.setAttribute("book_mes", list);
//			request.getRequestDispatcher("book_manager_index.jsp").forward(request, response);
//		} else {
//			System.out.println("�鼮Ϊ��");
//		}
		
		//����jsp������page����
		String Page = request.getParameter("page");
		int currentPage;
		//ͼ����Ϣ��ҳ��ѯ��������ʾȫ��ͼ����Ϣ����Ҫ��ʾÿҳ��Ϣ��
		//��һ��ÿҳ��Ҫ��ʾ��1��ҳ������ǰҳ������ҳ������ͼ����Ϣ��ÿҳ��չʾ����
		//����ÿҳ��ʾ�Ķ���
		BookPageMes bp = new BookPageMes();
		if (Page != null) {
			currentPage = Integer.parseInt(Page);
		} else {
			currentPage = 1;
		}
		
		//���յ�ǰҳ���ѯͼ����Ϣ
		BookService bs = new BookServiceImpl();
		List<Book> listPage = bs.selectByPage(currentPage);
		//��ȡ��ҳ��
		List<Book> all = bs.selectByPage(0);//��ѯ������
		int pageNum;
		if (all.size() % BookPageMes.PAGEBOOKNUM == 0) {
			pageNum = all.size() / BookPageMes.PAGEBOOKNUM;
		} else {
			pageNum = all.size() / BookPageMes.PAGEBOOKNUM + 1;
		}
		//װ��bookpagemes���󣬴����ǰ��
		bp.setBookMes(listPage);
		bp.setCurrentPage(currentPage);
		bp.setPageNum(pageNum);
		bp.setBookNum(all.size());
		request.setAttribute("bookMes",bp);
		request.getRequestDispatcher("book_manager_index.jsp").forward(request, response);
	}

}