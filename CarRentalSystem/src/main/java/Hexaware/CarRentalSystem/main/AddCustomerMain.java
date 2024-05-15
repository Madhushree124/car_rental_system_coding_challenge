package Hexaware.CarRentalSystem.main;

import java.sql.SQLException;
import java.util.Scanner;

import Hexaware.CarRentalSystem.dao.CustomerDao;
import Hexaware.CarRentalSystem.dao.CustomerDaoImpl;
import Hexaware.CarRentalSystem.model.Customer;

public class AddCustomerMain {

	public static void main(String[] args) {
		Customer customer=new Customer();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the customer id :");
		int customerID=sc.nextInt();
		System.out.println("Enter the first name :");
		String firstName=sc.next();
		System.out.println("Enter the last name :");
		String lastName=sc.next();
		System.out.println("Enter the email :");
		String email=sc.next();
		System.out.println("Enter the phone number :");
		String phoneNumber=sc.next();
		customer.setCustomerID(customerID);
		customer.setFirstName(firstName);
		customer.setLastName(lastName);
		customer.setEmail(email);
		customer.setPhoneNumber(phoneNumber);
		CustomerDao dao=new CustomerDaoImpl();
		try {
			System.out.println(dao.addCustomer(customer));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
