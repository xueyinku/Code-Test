package com.xue.cloud.serviceImpl;

import java.util.List;

import com.xue.cloud.dao.StrDao;
import com.xue.cloud.model.Str;
import com.xue.cloud.service.StrService;

public class StrServiceImpl implements StrService{

	@Override
	public List<Str> selectAll() {
		// TODO Auto-generated method stub
		String sql = "select str_id,str_name from strategy";
		return StrDao.query(sql);
	}

}
