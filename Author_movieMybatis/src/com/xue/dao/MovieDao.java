package com.xue.dao;

import java.util.List;

import com.xue.model.Movie;

public interface MovieDao {
	List<Movie> selectMoviesByName(String name);//根据电影名 查询电影所有信息
}
