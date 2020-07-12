package com.xue.service.Impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.xue.dao.ProjectDao;
import com.xue.model.Project;
import com.xue.model.ProjectByPage;
import com.xue.service1.ProjectService;
import com.xue.util.MybatisUtil;

public class ProjectServiceImpl implements ProjectService{

	@Override
	public ProjectByPage selectByNameAndPage(int currentpage, String name) {
		// TODO ����page��name��ѯ����ҳ��Ϣ
		//��һ����ѯ��ҳ��project��Ϣ
		SqlSession sqlSession = MybatisUtil.getSqlsession();
		//����ֵ����Ự���ײ��װ��jdbc���еĲ������
		//2.��ȡ����ӿڵĵĴ������
		ProjectDao mapper = sqlSession.getMapper(ProjectDao.class);
		//����ֵmapper�������ӿڲ�Ĵ���������ǿ����øö�����ô���ķ���
		//3.���ô�����
		List<Project> projectList = mapper.selectDynamic((currentpage - 1) * ProjectByPage.PAGEBOOKNUM, ProjectByPage.PAGEBOOKNUM, name);
		//�ڶ�������ȡҳ��
		//2.1��ȡ���з���������project
		List<Project> AllList = mapper.selectDynamic((currentpage - 1) * ProjectByPage.PAGEBOOKNUM, 0, name);
		//������ҳ��
		int pagenum = 0;
		if (AllList.size() % ProjectByPage.PAGEBOOKNUM == 0) {
			pagenum = AllList.size() / ProjectByPage.PAGEBOOKNUM;
		} else {
			pagenum = AllList.size() / ProjectByPage.PAGEBOOKNUM + 1;
		}
		//2.3����Щ����װ��������
		ProjectByPage pbp = new ProjectByPage();
		pbp.setProject(projectList);
		pbp.setCurrentPage(currentpage);
		pbp.setPagenum(pagenum);
		//4��ɾ�Ĳ�����Ҫ�ύ����
//		sqlsession.commit();//�ύ����
		//5.�ر���Դ
		sqlSession.close();
		return pbp;
	}
}
