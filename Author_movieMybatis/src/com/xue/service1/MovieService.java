package com.xue.service1;

import java.util.List;

import com.xue.model.Movie;

public interface MovieService {
	List<Movie> selectByName(String name);//根据电影名称，看到电影所有有信息
}
