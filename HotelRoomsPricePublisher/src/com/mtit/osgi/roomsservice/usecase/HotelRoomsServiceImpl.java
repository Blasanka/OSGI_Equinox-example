package com.mtit.osgi.roomsservice.usecase;

import java.util.Scanner;

public class HotelRoomsServiceImpl implements IHotelRoomsService {

	Scanner roomNumberInput = new Scanner(System.in);
	
	@Override
	public int requestRoomNumber() {
		try {
			System.out.print("Please input room type number from below catalog,"
					+ "\n[1] Luxury\n[2] Comfortable\n[3] Budget\n[4] Normal\nYour choice: ");
			return roomNumberInput.nextInt();
		} catch (Exception e) {
			System.out.println("Wrong input");
		}
		return -1;
	}

	@Override
	public double calculateRoomFare() {
		
		double defaultFare = 100;
		
		switch (requestRoomNumber()) {
			case 1:
				return defaultFare * 90;
			case 2:
				return defaultFare * 45;
			case 3:
				return defaultFare * 10;
			case 4:
				return defaultFare;
			default:
				return -999;
		}
	}

	@Override
	public void getRoomTypeFare() {
		double fare = calculateRoomFare();
		if (fare == -999)
			return;
		System.out.println("Your calculated fare for the selected room "
				+ "type is: " + fare);
		System.out.println("Thank you!");
	}

}
