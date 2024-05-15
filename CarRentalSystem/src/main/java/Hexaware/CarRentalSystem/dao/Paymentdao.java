package Hexaware.CarRentalSystem.dao;

import java.sql.SQLException;
import java.util.List;

import Hexaware.CarRentalSystem.exception.PaymentNotFoundException;
import Hexaware.CarRentalSystem.model.Payment;

public interface Paymentdao {

	List<Payment> showPaymentByLeaseID(int leaseID) throws ClassNotFoundException, SQLException, PaymentNotFoundException;
    String addPaymentDao(Payment payment) throws ClassNotFoundException, SQLException;
}
