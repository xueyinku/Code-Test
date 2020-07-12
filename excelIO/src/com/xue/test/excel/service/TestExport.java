package com.xue.test.excel.service;

import java.io.File;
import java.io.IOException;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class TestExport {

	public static void main(String[] args) throws IOException, RowsExceededException, WriteException {
		File file = new File("C:\\Users\\10159\\Desktop\\a1.xls");
		//����ָ��·������Excel������
		WritableWorkbook wwb = Workbook.createWorkbook(file);
		
		//ָ���������е�һ��ҳ����һ������
		//��һ��������ָ��sheetҳ������
		//�ڶ���������ָ���ڼ�ҳ(0ָ����һҳ)
		WritableSheet sheet = wwb.createSheet("��һҳ", 0);
		
		//������ͷ��ʹ�õ�����
		String[] arr = {"���", "����", "����"};
		Label label = null;
		
		//������Ӧ��Ԫ��
		//��һ��������ʾ�ڵڼ��д�����Ԫ��(0�����һ��)
		//�ڶ���������ʾ�ڵڼ��д�����Ԫ��(0�����һ��)
		//������������ʾ��ָ��λ�õĵ�Ԫ������������
		label = new Label(0, 0, arr[0]);
		
		//����Ԫ����뵽sheetҳ��
		sheet.addCell(label);
		
		//�������(�������ѭ���򻯴���)
		label = new Label(1, 0, arr[1]);
		sheet.addCell(label);
		label = new Label(2, 0, arr[2]);
		sheet.addCell(label);

		
		//������ӵ�����е�һ������
		String[] arr2 = {"1001", "С��", "10"};
		//���ݱ��붼���ַ�����ʽ��+ ""
		
		//������װ�����ڶ�����(˼�����������ѭ��)
		label = new Label(0, 1, arr2[0]);
		sheet.addCell(label);
		label = new Label(1, 1, arr2[1]);
		sheet.addCell(label);
		label = new Label(2, 1, arr2[2]);
		sheet.addCell(label);
		//Ҫ�����������װ�ж����������ѭ��ȡ������
		//���ν�����ĳ�Ա����������䵽ָ����Ԫ����
		
		//������д�뵽Excel�����
		wwb.write();
		//�ͷ���Դ
		wwb.close();
		System.out.println("д��ɹ�");
		
		//Ҫ�󣺸���ָ���İ���������������¹��ܣ�
		//��ҳ��jsp�����ж���һ����ť"һ������"
		//���һ��������ͨ��ajax��ʽ��ת����̨����̨��ѯ���ݿ����е�����
		//��ͨ���������룬�����ݿ������е����ݵ��뵽message.xls����У���ָ����ͷ��
		
	}
}




