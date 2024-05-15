package Hexaware.CarRentalSystem.main;

import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import Hexaware.CarRentalSystem.dao.PaymentDaoImpl;
import Hexaware.CarRentalSystem.dao.Paymentdao;
import Hexaware.CarRentalSystem.model.Payment;

public class AddPaymentsMain {

	public static void main(String[] args) throws ParseException {
		Payment payment=new Payment();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the payment id");
		payment.setPaymentID(sc.nextInt());
		
		System.out.println("Enter the lease ID");
		payment.setLeaseID(sc.nextInt());
		
		System.out.println("Enter the transactionDate :");
		String transaction_date=sc.next();
		
		System.out.println("Enter the amount");
		double amount=sc.nextDouble();
		payment.setAmount(amount);
		
		
		Date transactionDate = null;
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date utilDate = dateFormat.parse(transaction_date);
		transactionDate= new Date(utilDate.getTime());
		payment.setTransactionDate(transactionDate);
	    
		Paymentdao dao=new PaymentDaoImpl();
		
		try {
			System.out.println(dao.addPaymentDao(payment));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
