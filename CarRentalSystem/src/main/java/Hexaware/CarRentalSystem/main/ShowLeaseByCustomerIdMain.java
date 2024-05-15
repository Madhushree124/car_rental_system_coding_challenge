package Hexaware.CarRentalSystem.main;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import Hexaware.CarRentalSystem.dao.LeaseDao;
import Hexaware.CarRentalSystem.dao.LeaseDaoImpl;
import Hexaware.CarRentalSystem.exception.LeaseNotFoundException;
import Hexaware.CarRentalSystem.model.Lease;

public class ShowLeaseByCustomerIdMain {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the customer ID :");
		int customerID=sc.nextInt();
		LeaseDao dao=new LeaseDaoImpl();
		try {
			List<Lease> LeaseList=dao.showLeaseByCustomerId(customerID);
			for(Lease lease :LeaseList) {
				System.out.println(lease);
			}
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		} catch (LeaseNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
}
