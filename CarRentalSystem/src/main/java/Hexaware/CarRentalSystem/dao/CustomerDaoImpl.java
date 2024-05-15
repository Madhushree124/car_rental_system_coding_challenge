package Hexaware.CarRentalSystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Hexaware.CarRentalSystem.exception.CustomerNotFoundException;
import Hexaware.CarRentalSystem.model.Customer;
import Hexaware.CarRentalSystem.util.DBConnUtil;
import Hexaware.CarRentalSystem.util.DBPropertyUtil;

public class CustomerDaoImpl implements CustomerDao {

	Connection connection;
	PreparedStatement pst;
	
	@Override
	public String addCustomer(Customer customer) throws ClassNotFoundException, SQLException {
		String connStr = DBPropertyUtil.connectionString("db");
		connection = DBConnUtil.getConnection(connStr);
		String cmd="Insert into Customer (customerID, firstName, lastName, email, phoneNumber)\r\n"
				+ "VALUES(?,?,?,?,?)";
		pst=connection.prepareStatement(cmd);
		pst.setInt(1, customer.getCustomerID());
		pst.setString(2, customer.getFirstName());
		pst.setString(3, customer.getLastName());
		pst.setString(4, customer.getEmail());
		pst.setString(5, customer.getPhoneNumber());
		pst.executeUpdate();
		return "Customer record inserted successfully";
	}
	
	@Override
	public List<Customer> showCustomerdao() throws ClassNotFoundException, SQLException {
		String connStr = DBPropertyUtil.connectionString("db");
		connection = DBConnUtil.getConnection(connStr);
		String cmd="Select * from customer";
		pst=connection.prepareStatement(cmd);
		ResultSet rs=pst.executeQuery();
		List<Customer> customerList=new ArrayList<Customer>();
		Customer customer=null;
		while(rs.next()) {
			customer=new Customer();
			customer.setCustomerID(rs.getInt("customerID"));
			customer.setFirstName(rs.getString("firstName"));
			customer.setLastName(rs.getString("lastName"));
			customer.setEmail(rs.getString("email"));
			customer.setPhoneNumber(rs.getString("phoneNumber"));
			customerList.add(customer);
		}
		return customerList;
	}

	@Override
	public Customer searchByCustomerID(int customerID) throws ClassNotFoundException, SQLException,CustomerNotFoundException {
		String connStr = DBPropertyUtil.connectionString("db");
		connection = DBConnUtil.getConnection(connStr);
		String cmd="Select * from customer where customerID=?";
		pst=connection.prepareStatement(cmd);
		pst.setInt(1, customerID);
		ResultSet rs=pst.executeQuery();
		Customer customer=null;
		if(rs.next()) {
			customer=new Customer();
			customer.setCustomerID(rs.getInt("customerID"));
			customer.setFirstName(rs.getString("firstName"));
			customer.setLastName(rs.getString("lastName"));
			customer.setEmail(rs.getString("email"));
			customer.setPhoneNumber(rs.getString("phoneNumber"));
		}
		if(customer==null) {
			throw new CustomerNotFoundException("No customers found with customer id :"+customerID);
		}
		return customer;
	}

}
