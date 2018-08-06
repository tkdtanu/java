package com.tkd.dp.factory;

public abstract class Car {
	private CarType model;

	public Car(CarType model) {
		this.model = model;
		this.construct();
	}

	public CarType getModel() {
		return model;
	}

	public void setModel(CarType model) {
		this.model = model;
	}
	
	private void arrangeParts() {
		System.out.println("Arranging parts!!!");
	}
	protected abstract void construct();
}
