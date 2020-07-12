package com.xue.cloud.serviceImpl;

import java.util.List;

import com.xue.cloud.dao.ProjectDao;
import com.xue.cloud.model.Project;
import com.xue.cloud.model.ProjectByPage;
import com.xue.cloud.service.ProjectService;

public class ProjectServiceImpl implements ProjectService{

	@Override
	public List<Project> selectByNameAndpage(String name, int curretpage) {
		// TODO ����name����ģ����ѯ������currentpage������
		if (curretpage != 0) {
			String sql = "select PRO_ID,PRO_NAME,START_TIME,END_TIME,HEADER from project where PRO_NAME like ? limit ?,?";
			return ProjectDao.query(sql, "%" + name + "%",(curretpage - 1) * ProjectByPage.PAGEBOOKNUM ,ProjectByPage.PAGEBOOKNUM);
		} else {
			String sql = "select PRO_ID,PRO_NAME,START_TIME,END_TIME,HEADER from project where PRO_NAME like ? ";  //����name����ȫ��ѯ
			return ProjectDao.query(sql, "%" + name + "%");
		}
	}

	@Override
	public boolean insert(Project project) {
		// TODO Auto-generated method stub
		String sql = "insert into project values(default,?,?,?,?)";
		return ProjectDao.update(sql, project.getName(),project.getStarttime(),project.getEndtime(),project.getHearer());
	}

	@Override
	public boolean delete(int no) {
		// TODO ����no�����ݿ���ɾ����Ŀ��Ϣ
		String sql = "delete from project where PRO_ID = ?";
		return ProjectDao.update(sql, no);
	}

	@Override
	public List<Project> selectAll() {
		// TODO 
		String sql = "select PRO_ID,PRO_NAME,START_TIME,END_TIME,HEADER from project";
		return ProjectDao.query(sql);
	}

	@Override
	public Project selecrByProId(int proId) {
		// TODO //������Ŀid��ѯ��Ŀ��Ϣ
		String sql = "select PRO_ID,PRO_NAME,START_TIME,END_TIME,HEADER from project where PRO_ID = ?";
		List<Project> list = ProjectDao.query(sql, proId);
		if (list != null && list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}
	}

	@Override
	public boolean updateProById(Project project) {
		// TODO ����id�޸Ķ�Ӧpro����
		String sql = "update project set PRO_NAME = ?, START_TIME =?, END_TIME = ?,HEADER = ? where PRO_ID = ? ";
		return ProjectDao.update(sql, project.getName(),project.getStarttime(),project.getEndtime(),project.getHearer(),project.getId());
	}


}
