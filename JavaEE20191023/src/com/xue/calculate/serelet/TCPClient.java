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
		//创建本地字节输入流
		FileInputStream fis1 = null;
		Socket s1 = null;
		try {
			fis1 = new FileInputStream("C:\\Users\\Administrator\\Desktop\\tupian\\p1.jpg");
			//chuanjian客户端对象
			s1 = new Socket("localhost", 8889); 
			//获取网络输出流队形outputstream
			OutputStream out1 = s1.getOutputStream();
			//本地直接输入流读取数据
			int len = 0;
			byte[] bytes = new byte[1024];
			while ((len = fis1.read(bytes)) != -1) {
				//网络输出流输出数据
				out1.write(bytes,0,len);
			}
			//解决一致处在死循环中
			s1.shutdownOutput();
			//获取网络输入流输入的对象
			InputStream inputIntInputStream = s1.getInputStream();
			while ((len = inputIntInputStream.read(bytes)) != -1) {
				//网络输出流输出数据
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
