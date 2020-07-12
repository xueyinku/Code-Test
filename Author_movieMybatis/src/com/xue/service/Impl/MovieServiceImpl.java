package com.xue.service.Impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.xue.dao.MovieDao;
import com.xue.model.Movie;
import com.xue.service1.MovieService;
import com.xue.util.MybatisUtil;

public class MovieServiceImpl implements MovieService{

	@Override
	public List<Movie> selectByName(String name) {
		// TODO 调用代理的查询所有学生和老师的方法即可
		SqlSession sqlSession = MybatisUtil.getSqlsession();
		MovieDao mapper = sqlSession.getMapper(MovieDao.class);
		List<Movie> selectMoviesByName = mapper.selectMoviesByName(name);
		sqlSession.close();
		return selectMoviesByName;
	}

}
