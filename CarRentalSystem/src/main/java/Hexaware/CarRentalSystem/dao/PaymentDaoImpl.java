package Hexaware.CarRentalSystem.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Hexaware.CarRentalSystem.exception.PaymentNotFoundException;
import Hexaware.CarRentalSystem.model.Payment;

import Hexaware.CarRentalSystem.util.DBConnUtil;
import Hexaware.CarRentalSystem.util.DBPropertyUtil;

public class PaymentDaoImpl implements Paymentdao {

	Connection connection;
	PreparedStatement pst;
	@Override
	public List<Payment> showPaymentByLeaseID(int leaseID) throws ClassNotFoundException, SQLException,PaymentNotFoundException {
		// TODO Auto-generated method stub
		String connStr = DBPropertyUtil.connectionString("db");
		connection = DBConnUtil.getConnection(connStr);
		String cmd = "select * from payment where leaseID=?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, leaseID);
		ResultSet rs = pst.executeQuery();
		List<Payment> PaymentList=new ArrayList<Payment>();
		Payment payment=null;
		
		while(rs.next()) {
			payment=new Payment();
			payment.setPaymentID(rs.getInt("paymentID"));
			payment.setLeaseID(rs.getInt("leaseID"));
			payment.setTransactionDate(rs.getDate("transactionDate"));
			payment.setAmount(rs.getDouble("amount"));
			PaymentList.add(payment);
		}
		if(PaymentList.isEmpty()) {
			throw new PaymentNotFoundException("No payment record found with lease id :"+ leaseID);
		}
		return PaymentList;
	}
	@Override
	public String addPaymentDao(Payment payment) throws ClassNotFoundException, SQLException {
		String connStr = DBPropertyUtil.connectionString("db");
		connection = DBConnUtil.getConnection(connStr);
		String cmd="Insert into Payment (paymentID, leaseID, transactionDate, amount)\r\n"
				+ "VALUES(?,?,?,?)";
		pst=connection.prepareStatement(cmd);
		pst.setInt(1, payment.getPaymentID());
		pst.setInt(2, payment.getLeaseID());
		pst.setDate(3, payment.getTransactionDate());
		pst.setDouble(4, payment.getAmount());
		pst.executeUpdate();
		return "Payment record inserted successfully";
	}

	
}
