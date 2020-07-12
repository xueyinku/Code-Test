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
		//创建ServerSocket对象
		ServerSocket ss1 = new ServerSocket(8889);
		FileOutputStream fos1 = null;
		Socket socket = null;
		//创建本地直接输出流啊
		try {
			fos1 = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\tupian\\p10000.jpg");
		//调用accept方法，调用socket对象
			socket = ss1.accept();
			//接收网络输ru流
			InputStream is = socket.getInputStream();
			int len = 0;
			byte[] bytes = new byte[1024];
			while ((len = is.read(bytes)) != -1) {
				//本地字符输出输出图片
				fos1.write(bytes,0,len);
			}
			//给网络输出流输入数据
			socket.getOutputStream().write("上传成功".getBytes());;
		
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
