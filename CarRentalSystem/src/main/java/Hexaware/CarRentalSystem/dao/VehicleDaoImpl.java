package Hexaware.CarRentalSystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Hexaware.CarRentalSystem.exception.VehicleNotFoundException;
import Hexaware.CarRentalSystem.model.Vehicle;
import Hexaware.CarRentalSystem.util.DBConnUtil;
import Hexaware.CarRentalSystem.util.DBPropertyUtil;

public class VehicleDaoImpl implements VehicleDao{

	Connection connection;
	PreparedStatement pst;
	@Override
	public List<Vehicle> showAllVehiclesDao() throws ClassNotFoundException, SQLException {
		String connStr = DBPropertyUtil.connectionString("db");
		connection = DBConnUtil.getConnection(connStr);
		String cmd = "select * from vehicle";
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		List<Vehicle> VehicleList=new ArrayList<Vehicle>();
		Vehicle vehicle=null;
		
		while(rs.next()) {
			vehicle=new Vehicle();
			vehicle.setVehicleID(rs.getInt("vehicleID"));
			vehicle.setMake(rs.getString("make"));
			vehicle.setModel(rs.getString("model"));
			vehicle.setYear(rs.getInt("year"));
			vehicle.setDailyRate(rs.getDouble("dailyRate"));
			vehicle.setStatus(rs.getString("status"));
			vehicle.setPassengerCapacity(rs.getInt("passengerCapacity"));
			vehicle.setEngineCapacity(rs.getInt("engineCapacity"));
			VehicleList.add(vehicle);
		}
		return VehicleList;
	}
	@Override
	public List<Vehicle> showVehicleByMakeDao(String make) throws ClassNotFoundException, SQLException, VehicleNotFoundException {
		String connStr = DBPropertyUtil.connectionString("db");
		connection = DBConnUtil.getConnection(connStr);
		String cmd = "select * from vehicle where make=?";
		pst = connection.prepareStatement(cmd);
		pst.setString(1,make );
		ResultSet rs = pst.executeQuery();
		List<Vehicle> VehicleList=new ArrayList<Vehicle>();
		Vehicle vehicle=null;
		
		while(rs.next()) {
			vehicle=new Vehicle();
			vehicle.setVehicleID(rs.getInt("vehicleID"));
			vehicle.setMake(rs.getString("make"));
			vehicle.setModel(rs.getString("model"));
			vehicle.setYear(rs.getInt("year"));
			vehicle.setDailyRate(rs.getDouble("dailyRate"));
			vehicle.setStatus(rs.getString("status"));
			vehicle.setPassengerCapacity(rs.getInt("passengerCapacity"));
			vehicle.setEngineCapacity(rs.getInt("engineCapacity"));
			VehicleList.add(vehicle);
		}
		if (VehicleList.isEmpty()) {
            throw new VehicleNotFoundException("No vehicles found with make: " + make);
        }
		return VehicleList;
	}
	@Override
	public List<Vehicle> showVehicleByModel(String model) throws ClassNotFoundException, SQLException, VehicleNotFoundException {
		String connStr = DBPropertyUtil.connectionString("db");
		connection = DBConnUtil.getConnection(connStr);
		String cmd = "select * from vehicle where model=?";
		pst = connection.prepareStatement(cmd);
		pst.setString(1,model);
		ResultSet rs = pst.executeQuery();
		List<Vehicle> VehicleList=new ArrayList<Vehicle>();
		Vehicle vehicle=null;
		
		while(rs.next()) {
			vehicle=new Vehicle();
			vehicle.setVehicleID(rs.getInt("vehicleID"));
			vehicle.setMake(rs.getString("make"));
			vehicle.setModel(rs.getString("model"));
			vehicle.setYear(rs.getInt("year"));
			vehicle.setDailyRate(rs.getDouble("dailyRate"));
			vehicle.setStatus(rs.getString("status"));
			vehicle.setPassengerCapacity(rs.getInt("passengerCapacity"));
			vehicle.setEngineCapacity(rs.getInt("engineCapacity"));
			VehicleList.add(vehicle);
		}
		if (VehicleList.isEmpty()) {
            throw new VehicleNotFoundException("No vehicles found with model: " + model);
        }
		return VehicleList;
	}
	@Override
	public List<Vehicle> showVehicleByYear(int year) throws ClassNotFoundException, SQLException, VehicleNotFoundException {
		String connStr = DBPropertyUtil.connectionString("db");
		connection = DBConnUtil.getConnection(connStr);
		String cmd = "select * from vehicle where year=?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1,year);
		ResultSet rs = pst.executeQuery();
		List<Vehicle> VehicleList=new ArrayList<Vehicle>();
		Vehicle vehicle=null;
		
		while(rs.next()) {
			vehicle=new Vehicle();
			vehicle.setVehicleID(rs.getInt("vehicleID"));
			vehicle.setMake(rs.getString("make"));
			vehicle.setModel(rs.getString("model"));
			vehicle.setYear(rs.getInt("year"));
			vehicle.setDailyRate(rs.getDouble("dailyRate"));
			vehicle.setStatus(rs.getString("status"));
			vehicle.setPassengerCapacity(rs.getInt("passengerCapacity"));
			vehicle.setEngineCapacity(rs.getInt("engineCapacity"));
			VehicleList.add(vehicle);
		}
		if (VehicleList.isEmpty()) {
            throw new VehicleNotFoundException("No vehicles found with year : " + year);
        }
		return VehicleList;
	}
	@Override
	public List<Vehicle> showVehicleByPassengerCapacity(int passengerCapacity) throws ClassNotFoundException, SQLException, VehicleNotFoundException {
		String connStr = DBPropertyUtil.connectionString("db");
		connection = DBConnUtil.getConnection(connStr);
		String cmd = "select * from vehicle where passengerCapacity=?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1,passengerCapacity);
		ResultSet rs = pst.executeQuery();
		List<Vehicle> VehicleList=new ArrayList<Vehicle>();
		Vehicle vehicle=null;
		
		while(rs.next()) {
			vehicle=new Vehicle();
			vehicle.setVehicleID(rs.getInt("vehicleID"));
			vehicle.setMake(rs.getString("make"));
			vehicle.setModel(rs.getString("model"));
			vehicle.setYear(rs.getInt("year"));
			vehicle.setDailyRate(rs.getDouble("dailyRate"));
			vehicle.setStatus(rs.getString("status"));
			vehicle.setPassengerCapacity(rs.getInt("passengerCapacity"));
			vehicle.setEngineCapacity(rs.getInt("engineCapacity"));
			VehicleList.add(vehicle);
		}
		if (VehicleList.isEmpty()) {
            throw new VehicleNotFoundException("No vehicles found with passenger capacity: " + passengerCapacity);
        }
		return VehicleList;
	}
	@Override
	public String addVehicleDao(Vehicle vehicle) throws ClassNotFoundException, SQLException {
		String connStr = DBPropertyUtil.connectionString("db");
		connection = DBConnUtil.getConnection(connStr);
		String cmd="Insert into vehicle(vehicleID, make, model, year, dailyRate, status, passengerCapacity, engineCapacity) "
				+ "values(?,?,?,?,?,?,?,?)";
		pst=connection.prepareStatement(cmd);
		pst.setInt(1, vehicle.getVehicleID());
		pst.setString(2, vehicle.getMake());
		pst.setString(3, vehicle.getModel());
		pst.setInt(4, vehicle.getYear());
		pst.setDouble(5, vehicle.getDailyRate());
		pst.setString(6, vehicle.getStatus());
		pst.setInt(7, vehicle.getPassengerCapacity());
		pst.setInt(8, vehicle.getEngineCapacity());
		pst.executeUpdate();
		return "Vehicle record inserted";
	}
}

	

