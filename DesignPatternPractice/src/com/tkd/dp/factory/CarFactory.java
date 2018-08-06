package com.tkd.dp.factory;

public class CarFactory {
	
	public static Car buildCar(CarType type) {
		Car car = null;
		switch(type) {
		case SMALL:
			car =  new SmallCar();
			break;
		case LUXURY:
			car =  new LuxuryCar();
			break;
		case SEDAN:
			car =  new SedanCar();
			break;
		}
		return car;
	}

}
