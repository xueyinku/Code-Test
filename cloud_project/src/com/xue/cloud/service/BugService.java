package com.xue.cloud.service;

import java.util.List;

import com.xue.cloud.model.BugMes;

public interface BugService {
	boolean deleteByBugId(int id);//����bugidɾ������bug���ݣ�
	boolean insertBug(BugMes bugMes);//����bug
	boolean uodateBugByNoState(int no);//���ݱ�Ž�state��Ϊ4
	BugMes selectBugByBugId(int id);//����bugid��ѯbug��Ϣ
	List<BugMes> selectByProIdName(int proId,int currentPage,String name);//������Ŀid��ҳ����������bug
}
