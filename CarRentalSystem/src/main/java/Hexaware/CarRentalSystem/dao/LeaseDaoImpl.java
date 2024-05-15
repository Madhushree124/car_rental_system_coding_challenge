package Hexaware.CarRentalSystem.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Hexaware.CarRentalSystem.exception.LeaseNotFoundException;
import Hexaware.CarRentalSystem.model.Lease;

import Hexaware.CarRentalSystem.util.DBConnUtil;
import Hexaware.CarRentalSystem.util.DBPropertyUtil;

public class LeaseDaoImpl implements LeaseDao{

	Connection connection;
	PreparedStatement pst;
	
	@Override
	public List<Lease> showAllLease() throws ClassNotFoundException, SQLException {
		String connStr = DBPropertyUtil.connectionString("db");
		connection = DBConnUtil.getConnection(connStr);
		String cmd = "select * from lease";
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		List<Lease> LeaseList=new ArrayList<Lease>();
		Lease lease=null;
		
		while(rs.next()) {
			lease=new Lease();
			lease.setLeaseID(rs.getInt("leaseID"));
			lease.setVehicleID(rs.getInt("vehicleID"));
			lease.setCustomerID(rs.getInt("customerID"));
			lease.setStartDate(rs.getDate("startDate"));
			lease.setEndDate(rs.getDate("endDate"));
			lease.setLeaseType(rs.getString("leaseType"));
			LeaseList.add(lease);
		}
		return LeaseList;
	}

	@Override
	public List<Lease> showLeaseById(int leaseID) throws ClassNotFoundException, SQLException ,LeaseNotFoundException{
		String connStr = DBPropertyUtil.connectionString("db");
		connection = DBConnUtil.getConnection(connStr);
		String cmd = "select * from lease where leaseID=?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, leaseID);
		ResultSet rs = pst.executeQuery();
		List<Lease> LeaseList=new ArrayList<Lease>();
		Lease lease=null;
		
		while(rs.next()) {
			lease=new Lease();
			lease.setLeaseID(rs.getInt("leaseID"));
			lease.setVehicleID(rs.getInt("vehicleID"));
			lease.setCustomerID(rs.getInt("customerID"));
			lease.setStartDate(rs.getDate("startDate"));
			lease.setEndDate(rs.getDate("endDate"));
			lease.setLeaseType(rs.getString("leaseType"));
			LeaseList.add(lease);
		}
		if(LeaseList.isEmpty()) {
			throw new LeaseNotFoundException("No record found with leaseID :"+leaseID);
		}
		return LeaseList;
		
	}

	@Override
	public List<Lease> showLeaseByCustomerId(int customerID) throws ClassNotFoundException, SQLException,LeaseNotFoundException {
		
		String connStr = DBPropertyUtil.connectionString("db");
		connection = DBConnUtil.getConnection(connStr);
		String cmd = "select * from lease where customerID=?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, customerID);
		ResultSet rs = pst.executeQuery();
		List<Lease> LeaseList=new ArrayList<Lease>();
		Lease lease=null;
		
		while(rs.next()) {
			lease=new Lease();
			lease.setLeaseID(rs.getInt("leaseID"));
			lease.setVehicleID(rs.getInt("vehicleID"));
			lease.setCustomerID(rs.getInt("customerID"));
			lease.setStartDate(rs.getDate("startDate"));
			lease.setEndDate(rs.getDate("endDate"));
			lease.setLeaseType(rs.getString("leaseType"));
			LeaseList.add(lease);
		}
		if(LeaseList.isEmpty()) {
			throw new LeaseNotFoundException("No record found with customerID :"+customerID);
		}
		return LeaseList;
	}

	@Override
	public List<Lease> showLeaseByDate(Date startDate, Date endDate) throws ClassNotFoundException, SQLException,LeaseNotFoundException {
	
		String connStr = DBPropertyUtil.connectionString("db");
		connection = DBConnUtil.getConnection(connStr);
		String cmd = "select * from lease where startDate>=? and enddate<=?";
		pst = connection.prepareStatement(cmd);
		pst.setDate(1,startDate );
		pst.setDate(2, endDate);
		ResultSet rs = pst.executeQuery();
		List<Lease> LeaseList=new ArrayList<Lease>();
		Lease lease=null;
		
		while(rs.next()) {
			lease=new Lease();
			lease.setLeaseID(rs.getInt("leaseID"));
			lease.setVehicleID(rs.getInt("vehicleID"));
			lease.setCustomerID(rs.getInt("customerID"));
			lease.setStartDate(rs.getDate("startDate"));
			lease.setEndDate(rs.getDate("endDate"));
			lease.setLeaseType(rs.getString("leaseType"));
			LeaseList.add(lease);
		}
		if(LeaseList.isEmpty()) {
			throw new LeaseNotFoundException("No record found between startdate :"+ startDate +"and end date :"+endDate);
		}
		return LeaseList;
	}

	@Override
	public List<Lease> showByLeaseType(String leaseType) throws ClassNotFoundException, SQLException,LeaseNotFoundException {
		
		String connStr = DBPropertyUtil.connectionString("db");
		connection = DBConnUtil.getConnection(connStr);
		String cmd = "select * from lease where leaseType=?";
		pst = connection.prepareStatement(cmd);
		pst.setString(1, leaseType);
		ResultSet rs = pst.executeQuery();
		List<Lease> LeaseList=new ArrayList<Lease>();
		Lease lease=null;
		
		while(rs.next()) {
			lease=new Lease();
			lease.setLeaseID(rs.getInt("leaseID"));
			lease.setVehicleID(rs.getInt("vehicleID"));
			lease.setCustomerID(rs.getInt("customerID"));
			lease.setStartDate(rs.getDate("startDate"));
			lease.setEndDate(rs.getDate("endDate"));
			lease.setLeaseType(rs.getString("leaseType"));
			LeaseList.add(lease);
		}
		if(LeaseList.isEmpty()) {
			throw new LeaseNotFoundException("No record found with lease type :"+leaseType);
		}
		return LeaseList;
	}

	@Override
	public String addLeaseDao(Lease lease) throws ClassNotFoundException, SQLException {
		String connStr = DBPropertyUtil.connectionString("db");
		connection = DBConnUtil.getConnection(connStr);
		String cmd="Insert into lease (leaseID, vehicleID, customerID, startDate, endDate, leaseType)"
				+ "VALUES(?,?,?,?,?,?)";
		pst=connection.prepareStatement(cmd);
		pst.setInt(1, lease.getLeaseID());
		pst.setInt(2, lease.getVehicleID());
		pst.setInt(3, lease.getCustomerID());
		pst.setDate(4, lease.getStartDate());
		pst.setDate(5, lease.getEndDate());
		pst.setString(6, lease.getLeaseType());
		pst.executeUpdate();
		return "Lease record inserted successfully ";
	}

}
