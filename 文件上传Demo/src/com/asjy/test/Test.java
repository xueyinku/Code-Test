package com.asjy.test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.UUID;

public class Test {

	public static void main(String[] args) {
		//��������������ı��ĵ���
//		BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\10159\\Desktop\\a1.txt"));
		UUID uuid = UUID.randomUUID();
		System.out.println(uuid.toString());
	}
}
