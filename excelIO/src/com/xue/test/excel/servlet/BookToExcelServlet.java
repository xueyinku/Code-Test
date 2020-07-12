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
		//��ȡǰ��ajax������ֵ
		String flag = request.getParameter("flag");
		if ("toexcel".equals(flag)) {
			try {
				toSqlSelectBook(request,response);
			} catch (WriteException e) {
				// TODO Auto-generated catch block
			System.out.println("д��ʧ��");
			} 
		}
	}

	private void toSqlSelectBook(HttpServletRequest request, HttpServletResponse response) throws IOException, RowsExceededException, WriteException {
		// TODO ��һ��ȥ���ݿ�鵽����book��Ϣ
		BookService bs = new BookServiceImpl();
		List<Book> alllist = bs.selectAll();
		//�鵽֮��ȥ
		File file = new File("G:\\����ļ�\\test01.xls");
		//����ָ��·������Excel������
		WritableWorkbook wwb = Workbook.createWorkbook(file);
		
		//ָ���������е�һ��ҳ����һ������
		//��һ��������ָ��sheetҳ������
		//�ڶ���������ָ���ڼ�ҳ(0ָ����һҳ)
		WritableSheet sheet = wwb.createSheet("��һҳ", 0);
		//������ͷ��ʹ�õ�����
		String[] arr = {"���", "����", "����", "����ʱ��", "�۸�","���" };
		Label label = null;
		//������Ӧ��Ԫ��
		//��һ��������ʾ�ڵڼ��д�����Ԫ��(0�����һ��)
		//�ڶ���������ʾ�ڵڼ��д�����Ԫ��(0�����һ��)
		//������������ʾ��ָ��λ�õĵ�Ԫ������������
		for (int i = 0; i < arr.length; i++) {
			label = new Label(i, 0, arr[i]);
			//����Ԫ����뵽sheetҳ��
			sheet.addCell(label);
//					
//			//�������(�������ѭ���򻯴���)
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
			labelNo = new Label(0, i, alllist.get(i-1).getNo() + ""); //��noװ��excel��
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
			labelStore = new Label(5, i, alllist.get(i-1).getStore() + ""); //��storeװ��excel��
			sheet.addCell(labelStore);
		}
		//������д�뵽Excel�����
			wwb.write();
				//�ͷ���Դ
			wwb.close();
			response.getWriter().print(true);
	}
	
}
