package com.xue.book.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xue.book.util.ValidateCode;
import java.io.IOException;
/**
 * Servlet implementation class ImgServlet
 */
@WebServlet("/ImgServlet")
public class ImgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImgServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//������Ӧ���ͣ�ͼƬ��ʽ
		response.setContentType("image/jpeg");
		//������Ӧͷ����ֹ������������Ӧ������(��Լ�ڴ�)
		response.setHeader("Pragma", "No-cache");
		
		//���ù������еķ�����������֤��ͼƬ
		com.xue.book.util.ValidateCode code = new com.xue.book.util.ValidateCode();
		code.getValidateCode(request, response);//���û�����֤��ķ���������ͼƬ
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
}
