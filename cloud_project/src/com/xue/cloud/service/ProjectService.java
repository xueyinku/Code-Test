package com.xue.cloud.service;

import java.util.List;

import com.xue.cloud.model.Project;

public interface ProjectService {
	List<Project> selectByNameAndpage(String name,int curretpage); //������Ŀ���ƺ�page����project��Ϣ
	boolean insert(Project project); //������Ŀ
	boolean delete(int no);//������Ŀ���ɾ����Ŀ��Ϣ
	List<Project> selectAll();//��ѯ������Ŀ��Ϣ
	Project selecrByProId(int proId);//������Ŀid��ѯ��Ŀ��Ϣ
	boolean updateProById(Project project);
}
