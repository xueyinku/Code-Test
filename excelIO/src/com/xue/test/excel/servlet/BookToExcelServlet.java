package com.xue.test.excel.servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jdt.internal.compiler.flow.FinallyFlowContext;


import com.xue.book.model.Book;
import com.xue.test.excel.service.BookService;
import com.xue.test.excel.service.BookServiceImpl;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

/**
 * Servlet implementation class BookToExcelServlet
 */
@WebServlet("/BookToExcelServlet")
public class BookToExcelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookToExcelServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//接取前端ajax传来的值
		String flag = request.getParameter("flag");
		if ("toexcel".equals(flag)) {
			try {
				toSqlSelectBook(request,response);
			} catch (WriteException e) {
				// TODO Auto-generated catch block
			System.out.println("写入失败");
			} 
		}
	}

	private void toSqlSelectBook(HttpServletRequest request, HttpServletResponse response) throws IOException, RowsExceededException, WriteException {
		// TODO 第一步去数据库查到所有book信息
		BookService bs = new BookServiceImpl();
		List<Book> alllist = bs.selectAll();
		//查到之后去
		File file = new File("G:\\层层文件\\test01.xls");
		//根据指定路径创建Excel工作簿
		WritableWorkbook wwb = Workbook.createWorkbook(file);
		
		//指定工作表中的一个页，起一个名字
		//第一个参数：指定sheet页的名字
		//第二个参数：指定第几页(0指代第一页)
		WritableSheet sheet = wwb.createSheet("第一页", 0);
		//创建表头所使用的数据
		String[] arr = {"编号", "书名", "作者", "发表时间", "价格","库存" };
		Label label = null;
		//创建对应单元格
		//第一个参数表示在第几列创建单元格(0代表第一列)
		//第二个参数表示在第几行创建单元格(0代表第一行)
		//第三个参数表示在指定位置的单元格加入具体内容
		for (int i = 0; i < arr.length; i++) {
			label = new Label(i, 0, arr[i]);
			//将单元格加入到sheet页中
			sheet.addCell(label);
//					
//			//如此往复(这段请用循环简化代码)
//			label = new Label(1, 0, arr[1]);
//			sheet.addCell(label);
//			label = new Label(2, 0, arr[2]);
//			sheet.addCell(label);	
		}
		Label labelNo =null;
		Label labelName =null;
		Label labelAuthor =null;
		Label labelPublish =null;
		Label labelPrice =null;
		Label labelStore =null;
		for (int i = 1; i < alllist.size() + 1; i++) {
			labelNo = new Label(0, i, alllist.get(i-1).getNo() + ""); //将no装到excel中
			sheet.addCell(labelNo);
			labelName = new Label(1, i, alllist.get(i-1).getName());
			sheet.addCell(labelName);
			labelAuthor = new Label(2, i, alllist.get(i-1).getAuthor());
			sheet.addCell(labelAuthor);
			labelPublish = new Label(3, i, alllist.get(i-1).getPublish());
			sheet.addCell(labelPublish);
			String price = String.valueOf(alllist.get(i-1).getPrice());
			labelPrice = new Label(4, i, price);
			sheet.addCell(labelPrice);
			labelStore = new Label(5, i, alllist.get(i-1).getStore() + ""); //将store装到excel中
			sheet.addCell(labelStore);
		}
		//将数据写入到Excel表格中
			wwb.write();
				//释放资源
			wwb.close();
			response.getWriter().print(true);
	}
	
}
