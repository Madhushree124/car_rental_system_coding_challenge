package Hexaware.CarRentalSystem.main;

import java.sql.SQLException;
import java.util.List;

import Hexaware.CarRentalSystem.dao.VehicleDao;
import Hexaware.CarRentalSystem.dao.VehicleDaoImpl;
import Hexaware.CarRentalSystem.model.Vehicle;

public class ShowAllVehiclesmain {

	public static void main(String[] args) {
		VehicleDao dao=new VehicleDaoImpl();
		try {
			List<Vehicle> VehicleList =dao.showAllVehiclesDao();
			for(Vehicle vehicle:VehicleList) {
				System.out.println(vehicle);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
