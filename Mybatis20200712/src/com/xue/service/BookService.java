package com.xue.service;

import com.xue.model.BookPageMes;

public interface BookService {
	
	//ʵ�ֶ�̬��ѯ ��ɵ�����+��ҳ��ѯ�Ĺ���
	BookPageMes findBookByPage(int id,String name,int currentPage);

}
