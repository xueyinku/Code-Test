package com.xue.calculate.serelet;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClient {
	public static void main(String[] args) throws IOException {
		//���������ֽ�������
		FileInputStream fis1 = null;
		Socket s1 = null;
		try {
			fis1 = new FileInputStream("C:\\Users\\Administrator\\Desktop\\tupian\\p1.jpg");
			//chuanjian�ͻ��˶���
			s1 = new Socket("localhost", 8889); 
			//��ȡ�������������outputstream
			OutputStream out1 = s1.getOutputStream();
			//����ֱ����������ȡ����
			int len = 0;
			byte[] bytes = new byte[1024];
			while ((len = fis1.read(bytes)) != -1) {
				//����������������
				out1.write(bytes,0,len);
			}
			//���һ�´�����ѭ����
			s1.shutdownOutput();
			//��ȡ��������������Ķ���
			InputStream inputIntInputStream = s1.getInputStream();
			while ((len = inputIntInputStream.read(bytes)) != -1) {
				//����������������
				System.out.println(new String(bytes,0,len));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			s1.close();
			fis1.close();
		}
	}
}
