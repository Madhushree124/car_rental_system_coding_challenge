package Hexaware.CarRentalSystem.dao;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import Hexaware.CarRentalSystem.exception.LeaseNotFoundException;
import Hexaware.CarRentalSystem.model.Lease;

public interface LeaseDao {

	List<Lease> showAllLease() throws ClassNotFoundException, SQLException;
	List<Lease> showLeaseById(int leaseID) throws ClassNotFoundException, SQLException, LeaseNotFoundException;
	List<Lease> showLeaseByCustomerId(int customerID) throws ClassNotFoundException, SQLException, LeaseNotFoundException;
	List<Lease> showLeaseByDate(Date startDate,Date endDate) throws ClassNotFoundException, SQLException, LeaseNotFoundException;
	List<Lease> showByLeaseType(String leaseType) throws ClassNotFoundException, SQLException, LeaseNotFoundException;
	String addLeaseDao(Lease lease) throws ClassNotFoundException, SQLException;
	
}
