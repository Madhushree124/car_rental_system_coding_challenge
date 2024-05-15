package Hexaware.CarRentalSystem.model;

import java.sql.Date;

public class Payment {

	private int paymentID;
	private int leaseID ;
	private Date transactionDate ;
	private double amount;
	public int getPaymentID() {
		return paymentID;
	}
	public void setPaymentID(int paymentID) {
		this.paymentID = paymentID;
	}
	public int getLeaseID() {
		return leaseID;
	}
	public void setLeaseID(int leaseID) {
		this.leaseID = leaseID;
	}
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Payment() {
	
		// TODO Auto-generated constructor stub
	}
	public Payment(int paymentID, int leaseID, Date transactionDate, double amount) {
		super();
		this.paymentID = paymentID;
		this.leaseID = leaseID;
		this.transactionDate = transactionDate;
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "Payment [paymentID=" + paymentID + ", leaseID=" + leaseID + ", transactionDate=" + transactionDate
				+ ", amount=" + amount + "]";
	}
	
	
	
	
}
