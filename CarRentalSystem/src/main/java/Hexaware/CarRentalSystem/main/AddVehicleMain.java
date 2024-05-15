package Hexaware.CarRentalSystem.main;

import java.sql.SQLException;
import java.util.Scanner;

import Hexaware.CarRentalSystem.dao.VehicleDao;
import Hexaware.CarRentalSystem.dao.VehicleDaoImpl;
import Hexaware.CarRentalSystem.model.Vehicle;

public class AddVehicleMain {

	public static void main(String[] args) {
		Vehicle vehicle=new Vehicle();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the vehicle id :");
		int vehicleID=sc.nextInt();
		System.out.println("Enter the make");
		String make=sc.next();
		
		System.out.println("Enter the model");
		String model=sc.next();
		sc.nextLine();
		System.out.println("Enter the year");
		int year=sc.nextInt();
		System.out.println("Enter the dailyRate");
		double dailyRate=sc.nextDouble();
		System.out.println("Enter the status");
		String status=sc.next();
		System.out.println("Enter the passengerCapacity");
		int passengerCapacity=sc.nextInt();
		System.out.println("Enter the engine capacity :");
		int engineCapacity=sc.nextInt();
		vehicle.setVehicleID(vehicleID);
		vehicle.setMake(make);
		vehicle.setModel(model);
		vehicle.setYear(year);
		vehicle.setDailyRate(dailyRate);
		vehicle.setStatus(status);
		vehicle.setPassengerCapacity(passengerCapacity);
		vehicle.setEngineCapacity(engineCapacity);
		VehicleDao dao=new VehicleDaoImpl();
		try {
			System.out.println(dao.addVehicleDao(vehicle));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}
}
