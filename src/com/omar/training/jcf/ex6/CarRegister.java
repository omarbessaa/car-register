package com.omar.training.jcf.ex6;

import java.util.HashSet;
import java.util.Set;

public class CarRegister {

	private Set<String> permit;
	private Set<String> parked;
	private int capacity;

	public CarRegister(int capacity) {
		this.parked = new HashSet<String>();
		this.permit = new HashSet<String>();
		if (capacity <= 0) {
			// throw new CarRegisterException("Capacity should be > 0");
			throw new RuntimeException("Capacity should be > 0");
		}
		this.capacity = capacity;
	}

	public boolean givePermit(String carResitrationNumber) {
		return this.permit.add(carResitrationNumber);
	}

	public boolean isFull() {
		return (this.capacity == this.parked.size());
	}

	public boolean isParked(String carResitrationNumber) {
		return this.parked.contains(carResitrationNumber);
	}

	public Set<String> getPermit() {
		return permit;
	}

	public Set<String> getParked() {
		return parked;
	}

	public int getCapacity() {
		return capacity;
	}

	public int numberParked() {
		return this.parked.size();
	}

	private boolean havePermit(String carResitrationNumber) {
		return this.permit.contains(carResitrationNumber);
	}

	public boolean recordParking(String carResitrationNumber) throws CarRegisterException {
		if (this.isFull())
			return false;
		if (!this.havePermit(carResitrationNumber))
			return false;
		if (this.isParked(carResitrationNumber))
			throw new CarRegisterException("Car already parked");

		this.parked.add(carResitrationNumber);
		return true;
	}

	public boolean recordExit(String carResitrationNumber) {
		return this.parked.remove(carResitrationNumber);
	}

}
