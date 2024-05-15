package Hexaware.CarRentalSystem.main;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import Hexaware.CarRentalSystem.dao.PaymentDaoImpl;
import Hexaware.CarRentalSystem.dao.Paymentdao;
import Hexaware.CarRentalSystem.exception.PaymentNotFoundException;
import Hexaware.CarRentalSystem.model.Payment;

public class ShowPaymentByLeaseIdMain {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the lease id :");
		int leaseID=sc.nextInt();
		
		Paymentdao dao=new PaymentDaoImpl();
		List<Payment> PaymentList;
		try {
			PaymentList = dao.showPaymentByLeaseID(leaseID);
			for(Payment payment:PaymentList) {
				System.out.println(payment);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PaymentNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		
	}
}
