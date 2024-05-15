package Hexaware.CarRentalSystem.main;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import Hexaware.CarRentalSystem.dao.LeaseDao;
import Hexaware.CarRentalSystem.dao.LeaseDaoImpl;
import Hexaware.CarRentalSystem.exception.LeaseNotFoundException;
import Hexaware.CarRentalSystem.model.Lease;

public class ShowByLeaseTypeMain {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the lease type :");
		String leaseType=sc.next();
		LeaseDao dao=new LeaseDaoImpl();
		try {
			List<Lease> LeaseList=dao.showByLeaseType(leaseType);
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
