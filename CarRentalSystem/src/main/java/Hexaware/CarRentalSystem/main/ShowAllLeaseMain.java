package Hexaware.CarRentalSystem.main;

import java.sql.SQLException;
import java.util.List;

import Hexaware.CarRentalSystem.dao.LeaseDao;
import Hexaware.CarRentalSystem.dao.LeaseDaoImpl;
import Hexaware.CarRentalSystem.model.Lease;

public class ShowAllLeaseMain {

	public static void main(String[] args) {
		LeaseDao dao= new LeaseDaoImpl();
		try {
			List<Lease> LeaseList=dao.showAllLease();
			for(Lease lease:LeaseList) {
				System.out.println(lease);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
