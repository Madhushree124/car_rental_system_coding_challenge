package Hexaware.CarRentalSystem.main;

import java.sql.SQLException;
import java.util.List;

import Hexaware.CarRentalSystem.dao.CustomerDao;
import Hexaware.CarRentalSystem.dao.CustomerDaoImpl;
import Hexaware.CarRentalSystem.model.Customer;

public class ShowCustomerMain {

	public static void main(String[] args) {
		CustomerDao dao=new CustomerDaoImpl();
		try {
			List<Customer> customerList=dao.showCustomerdao();
			for(Customer customer:customerList) {
				System.out.println(customer);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
