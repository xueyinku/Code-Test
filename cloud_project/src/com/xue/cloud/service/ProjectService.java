package com.xue.cloud.service;

import java.util.List;

import com.xue.cloud.model.Project;

public interface ProjectService {
	List<Project> selectByNameAndpage(String name,int curretpage); //根据项目名称和page查找project信息
	boolean insert(Project project); //增加项目
	boolean delete(int no);//根据项目编号删除项目信息
	List<Project> selectAll();//查询所有项目信息
	Project selecrByProId(int proId);//根据项目id查询项目信息
	boolean updateProById(Project project);
}
