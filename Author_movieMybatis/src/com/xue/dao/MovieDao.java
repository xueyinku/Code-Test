package com.xue.dao;

import java.util.List;

import com.xue.model.Movie;

public interface MovieDao {
	List<Movie> selectMoviesByName(String name);//���ݵ�Ӱ�� ��ѯ��Ӱ������Ϣ
}
