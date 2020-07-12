package com.asjy.serive;

import java.util.List;

import com.asjy.model.Car;

public interface CarService {

	List<Car> findCar();
	
	boolean addCar(Car car);
}
