package Hexaware.CarRentalSystem.main;

import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import Hexaware.CarRentalSystem.dao.LeaseDao;
import Hexaware.CarRentalSystem.dao.LeaseDaoImpl;
import Hexaware.CarRentalSystem.exception.LeaseNotFoundException;
import Hexaware.CarRentalSystem.model.Lease;

public class ShowLeaseByDateMain {

	public static void main(String[] args) throws ParseException {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the start date :");
		String start_date=sc.next();
		System.out.println("Enter the end date");
		String end_date=sc.next();
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
			List<Lease> LeaseList=dao.showLeaseByDate(startDate, endDate);
			for(Lease lease:LeaseList) {
				System.out.println(lease);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LeaseNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
				 
	}
}
