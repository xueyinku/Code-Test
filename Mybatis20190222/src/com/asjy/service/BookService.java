package com.asjy.service;

import com.asjy.model.BookPage;

public interface BookService {

	//��������ɵ�����+��ҳ��ѯ�Ĺ���
	BookPage findBookByPage(String id, String name, int currentPage);
}
