package Hexaware.CarRentalSystem.dao;

import java.sql.SQLException;
import java.util.List;

import Hexaware.CarRentalSystem.exception.VehicleNotFoundException;
import Hexaware.CarRentalSystem.model.Vehicle;

public interface VehicleDao {

	List<Vehicle> showAllVehiclesDao() throws ClassNotFoundException, SQLException;
	List<Vehicle> showVehicleByMakeDao(String make) throws ClassNotFoundException, SQLException, VehicleNotFoundException;
	List<Vehicle> showVehicleByModel(String model) throws ClassNotFoundException, SQLException, VehicleNotFoundException;
	List<Vehicle> showVehicleByYear(int year) throws ClassNotFoundException, SQLException, VehicleNotFoundException;
	List<Vehicle> showVehicleByPassengerCapacity(int passengerCapacity) throws ClassNotFoundException, SQLException, VehicleNotFoundException;
	String addVehicleDao(Vehicle vehicle) throws ClassNotFoundException, SQLException;
  }
