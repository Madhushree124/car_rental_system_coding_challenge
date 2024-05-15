package Hexaware.CarRentalSystem.dao;

import java.sql.SQLException;
import java.util.List;

import Hexaware.CarRentalSystem.exception.CustomerNotFoundException;
import Hexaware.CarRentalSystem.model.Customer;

public interface CustomerDao {

	String addCustomer(Customer customer) throws ClassNotFoundException, SQLException;
	List<Customer> showCustomerdao() throws ClassNotFoundException, SQLException;
	Customer searchByCustomerID(int customerID) throws ClassNotFoundException, SQLException, CustomerNotFoundException;
}
