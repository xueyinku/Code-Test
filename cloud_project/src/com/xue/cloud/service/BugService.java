package com.xue.cloud.service;

import java.util.List;

import com.xue.cloud.model.BugMes;

public interface BugService {
	boolean deleteByBugId(int id);//根据bugid删除该条bug数据；
	boolean insertBug(BugMes bugMes);//新增bug
	boolean uodateBugByNoState(int no);//根据标号将state改为4
	BugMes selectBugByBugId(int id);//根据bugid查询bug信息
	List<BugMes> selectByProIdName(int proId,int currentPage,String name);//根据项目id和页数查找所有bug
}
