package com.omar.training.jcf.ex6;

public class Tester {

	public static void main(String[] args) {
		
		CarRegister park = new CarRegister(3);
		
		park.givePermit("1919");
		park.givePermit("2020");
		park.givePermit("2121");
		System.out.println(park.getPermit());
		System.out.println(park.getParked());
		System.out.println(park.getCapacity());
		System.out.println(park.numberParked());
		System.out.println(park.isFull());
		System.out.println();
		
		try {
			park.recordParking("1919");
			park.recordParking("2020");
			//park.recordParking("2121");
			park.recordParking("1919");
			//System.out.println(park.recordParking("0000"));
		} catch (CarRegisterException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println();
		System.out.println(park.getPermit());
		System.out.println(park.getParked());
		System.out.println(park.getCapacity());
		System.out.println(park.numberParked());
		System.out.println(park.isFull());
	}

}
