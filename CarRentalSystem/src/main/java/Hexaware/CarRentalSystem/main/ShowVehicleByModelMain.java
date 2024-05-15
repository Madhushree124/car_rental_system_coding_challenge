package Hexaware.CarRentalSystem.main;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import Hexaware.CarRentalSystem.dao.VehicleDao;
import Hexaware.CarRentalSystem.dao.VehicleDaoImpl;
import Hexaware.CarRentalSystem.exception.VehicleNotFoundException;
import Hexaware.CarRentalSystem.model.Vehicle;

public class ShowVehicleByModelMain {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the model:");
		String model=sc.next();
		VehicleDao dao=new VehicleDaoImpl();
		try {
			List<Vehicle> VehicleList =dao.showVehicleByModel(model);
			for(Vehicle vehicle:VehicleList) {
				System.out.println(vehicle);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (VehicleNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
}
