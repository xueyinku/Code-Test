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
		//根据指定路径创建Excel工作簿
		WritableWorkbook wwb = Workbook.createWorkbook(file);
		
		//指定工作表中的一个页，起一个名字
		//第一个参数：指定sheet页的名字
		//第二个参数：指定第几页(0指代第一页)
		WritableSheet sheet = wwb.createSheet("第一页", 0);
		
		//创建表头所使用的数据
		String[] arr = {"编号", "姓名", "年龄"};
		Label label = null;
		
		//创建对应单元格
		//第一个参数表示在第几列创建单元格(0代表第一列)
		//第二个参数表示在第几行创建单元格(0代表第一行)
		//第三个参数表示在指定位置的单元格加入具体内容
		label = new Label(0, 0, arr[0]);
		
		//将单元格加入到sheet页中
		sheet.addCell(label);
		
		//如此往复(这段请用循环简化代码)
		label = new Label(1, 0, arr[1]);
		sheet.addCell(label);
		label = new Label(2, 0, arr[2]);
		sheet.addCell(label);

		
		//定义添加到表格中的一条数据
		String[] arr2 = {"1001", "小明", "10"};
		//数据必须都是字符串形式：+ ""
		
		//将数据装进表格第二行中(思考：如何利用循环)
		label = new Label(0, 1, arr2[0]);
		sheet.addCell(label);
		label = new Label(1, 1, arr2[1]);
		sheet.addCell(label);
		label = new Label(2, 1, arr2[2]);
		sheet.addCell(label);
		//要求：如果集合中装有对象，如何利用循环取出对象
		//依次将对象的成员变量数据填充到指定单元格中
		
		//将数据写入到Excel表格中
		wwb.write();
		//释放资源
		wwb.close();
		System.out.println("写入成功");
		
		//要求：根据指定的案例分析，完成如下功能！
		//首页的jsp画面中定义一个按钮"一键导出"
		//点击一键导出，通过ajax方式跳转到后台，后台查询数据库所有的数据
		//并通过案例代码，将数据库中所有的数据导入到message.xls表格中，并指定表头名
		
	}
}




