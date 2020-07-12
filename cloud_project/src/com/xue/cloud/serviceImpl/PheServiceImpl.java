package com.xue.cloud.serviceImpl;

import java.util.List;

import com.xue.cloud.dao.PheDao;
import com.xue.cloud.model.Phenomenon;
import com.xue.cloud.service.PheService;

public class PheServiceImpl implements PheService{

	@Override
	public List<Phenomenon> selectAll() {
		// TODO 查到所有的现象
		String sql = "select phe_id,phe_name from phenomenon";
		return PheDao.query(sql);
	}

}
