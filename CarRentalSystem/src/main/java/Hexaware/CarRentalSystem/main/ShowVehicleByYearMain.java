package Hexaware.CarRentalSystem.main;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import Hexaware.CarRentalSystem.dao.VehicleDao;
import Hexaware.CarRentalSystem.dao.VehicleDaoImpl;
import Hexaware.CarRentalSystem.exception.VehicleNotFoundException;
import Hexaware.CarRentalSystem.model.Vehicle;

public class ShowVehicleByYearMain {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the year:");
		int year=sc.nextInt();
		VehicleDao dao=new VehicleDaoImpl();
		try {
			List<Vehicle> VehicleList =dao.showVehicleByYear(year);
			for(Vehicle vehicle:VehicleList) {
				System.out.println(vehicle);
			}
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		} catch (VehicleNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
}
