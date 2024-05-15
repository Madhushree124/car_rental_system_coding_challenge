package Hexaware.CarRentalSystem.main;

import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import Hexaware.CarRentalSystem.dao.LeaseDao;
import Hexaware.CarRentalSystem.dao.LeaseDaoImpl;
import Hexaware.CarRentalSystem.model.Lease;

public class AddLeaseMain {

	public static void main(String[] args) throws ParseException {
		Lease lease=new Lease();
		Scanner sc=new Scanner(System.in);
	    
		System.out.println("Enter the leaseID");
		int leaseID=sc.nextInt();
		System.out.println("Enter the vehicleID");
		int vehicleID=sc.nextInt();
		System.out.println("Enter the customerID");
		int customerID=sc.nextInt();
		 
		System.out.println("Enter the start date :");
		String start_date=sc.next();
		System.out.println("Enter the end date");
		String end_date=sc.next();
		System.out.println("Enter the lease Type");
		String leaseType=sc.next();
		
		Date startDate = null;
		
	     SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		 java.util.Date utilDate = dateFormat.parse(start_date);
		 startDate= new Date(utilDate.getTime());
		 
		 Date endDate = null;
			
	     SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
		 java.util.Date utilDate1 = dateFormat1.parse(end_date);
		 endDate= new Date(utilDate1.getTime());
	
		 
		 LeaseDao dao=new LeaseDaoImpl();
		 
		 try {
			System.out.println(dao.addLeaseDao(lease));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
