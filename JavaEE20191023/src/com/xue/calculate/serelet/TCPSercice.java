package com.xue.calculate.serelet;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class TCPSercice {
	public static void main(String[] args) throws IOException {
		//����ServerSocket����
		ServerSocket ss1 = new ServerSocket(8889);
		FileOutputStream fos1 = null;
		Socket socket = null;
		//��������ֱ���������
		try {
			fos1 = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\tupian\\p10000.jpg");
		//����accept����������socket����
			socket = ss1.accept();
			//����������ru��
			InputStream is = socket.getInputStream();
			int len = 0;
			byte[] bytes = new byte[1024];
			while ((len = is.read(bytes)) != -1) {
				//�����ַ�������ͼƬ
				fos1.write(bytes,0,len);
			}
			//�������������������
			socket.getOutputStream().write("�ϴ��ɹ�".getBytes());;
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			socket.close();
			fos1.close();
			ss1.close();
		}
	}

}
