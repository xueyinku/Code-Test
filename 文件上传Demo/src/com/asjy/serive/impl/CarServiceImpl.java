package com.asjy.serive.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.asjy.dao.CarDao;
import com.asjy.model.Car;
import com.asjy.serive.CarService;
import com.asjy.util.MybatisUtil;

public class CarServiceImpl implements CarService{

	@Override
	public List<Car> findCar() {
		//���ô����ȫ��ѯ����
		SqlSession sqlSession = MybatisUtil.getSqlsession();
		CarDao mapper = sqlSession.getMapper(CarDao.class);
		List<Car> carList = mapper.findCar();
		sqlSession.close();
		return carList;
	}

	@Override
	public boolean addCar(Car car) {
		//���ô������ӷ���
		SqlSession sqlSession = MybatisUtil.getSqlsession();
		CarDao mapper = sqlSession.getMapper(CarDao.class);
		int result = mapper.addCar(car);
		sqlSession.commit();
		sqlSession.close();
		return result > 0 ? true : false;
	}
}
