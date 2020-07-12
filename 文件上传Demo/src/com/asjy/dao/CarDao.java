package com.asjy.dao;

import java.util.List;

import com.asjy.model.Car;

public interface CarDao {

	List<Car> findCar();
	
	int addCar(Car car);
}
