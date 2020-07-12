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
		// TODO 根据page和name查询到当页信息
		//第一步查询当页的project信息
		SqlSession sqlSession = MybatisUtil.getSqlsession();
		//返回值代表会话，底层封装了jdbc所有的步骤代码
		//2.获取代理接口的的代理对象
		ProjectDao mapper = sqlSession.getMapper(ProjectDao.class);
		//返回值mapper代表代理接口层的代理对象，我们可以用该对象调用代理的方法
		//3.调用代理方法
		List<Project> projectList = mapper.selectDynamic((currentpage - 1) * ProjectByPage.PAGEBOOKNUM, ProjectByPage.PAGEBOOKNUM, name);
		//第二步，获取页数
		//2.1获取所有符合条件的project
		List<Project> AllList = mapper.selectDynamic((currentpage - 1) * ProjectByPage.PAGEBOOKNUM, 0, name);
		//计算总页数
		int pagenum = 0;
		if (AllList.size() % ProjectByPage.PAGEBOOKNUM == 0) {
			pagenum = AllList.size() / ProjectByPage.PAGEBOOKNUM;
		} else {
			pagenum = AllList.size() / ProjectByPage.PAGEBOOKNUM + 1;
		}
		//2.3将这些数据装到对象中
		ProjectByPage pbp = new ProjectByPage();
		pbp.setProject(projectList);
		pbp.setCurrentPage(currentpage);
		pbp.setPagenum(pagenum);
		//4增删改操作需要提交数据
//		sqlsession.commit();//提交数据
		//5.关闭资源
		sqlSession.close();
		return pbp;
	}
}
