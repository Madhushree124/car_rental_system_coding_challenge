package Hexaware.CarRentalSystem.main;

import java.sql.SQLException;
import java.util.Scanner;

import Hexaware.CarRentalSystem.dao.CustomerDao;
import Hexaware.CarRentalSystem.dao.CustomerDaoImpl;
import Hexaware.CarRentalSystem.exception.CustomerNotFoundException;
import Hexaware.CarRentalSystem.model.Customer;

public class SearchCustomerByIDMain {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the customer Id :");
		int customerID=sc.nextInt();
		CustomerDao dao=new CustomerDaoImpl();
		try {
			Customer customer=dao.searchByCustomerID(customerID);
			if(customer!=null) {
				System.out.println(customer);
			}
			
		} catch (ClassNotFoundException | SQLException  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CustomerNotFoundException e) {
			
			System.out.println(e.getMessage());
		}
	}
}
