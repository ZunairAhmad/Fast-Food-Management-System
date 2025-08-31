package com.system.customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

public class CustomerDao {

	static String url = "jdbc:mysql://localhost/fastFood?useSSL=false";
	static String username = "student";
	static String password = "student";
	static Connection con = null;
	static Statement myStmt = null;

	static {
		try {
			Connection con = DriverManager.getConnection(url, username, password);
			System.out.println("Connection established......");

			String queryTableCheck = "SELECT * FROM INFORMATION_SCHEMA.TABLES "
					+"WHERE TABLE_SCHEMA = 'fastFood' AND TABLE_NAME = 'CUSTOMER'"; 

			Statement stmt = con.createStatement();
			boolean exists = stmt.execute(queryTableCheck);
			if (!exists) {
				String query = "CREATE TABLE CUSTOMER("
						+ "customerEntryNumber INT NOT NULL, "
						+ "customerMemberShipId INT NOT NULL, "
						+ "customerName VARCHAR (50) NOT NULL, "
						+ "customerBill INT NOT NULL, "
						+ "customerFoodItemIds VARCHAR (50) NOT NULL, "
						+ "customerFoodPurchaseTime VARCHAR (100) NOT NULL, "
						+ "PRIMARY KEY (customerEntryNumber))";
				stmt.execute(query);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public CustomerDao() {
	}

	public static Customer addRecord(Customer customer) {
		String queryInsert = "insert into customer value (?,?,?,?,?,?)";
		try {
			con = DriverManager.getConnection(url, username, password);
			PreparedStatement st = con.prepareStatement(queryInsert);
			st.setInt(1, customer.getCustomerEntryNumber());
			st.setInt(2, customer.getCustomerMemberShipId());
			st.setString(3, customer.getCustomerName());
			st.setLong(4, customer.getCustomerBill());
			st.setString(5, customer.getCustomerFoodItemIds());
			st.setString(6, customer.getCustomerFoodPurchaseTime());
			st.execute();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customer;
	}

	public static List<Customer> getAllHistory(){
		List<Customer> customers = new LinkedList<>();
		String queryGet = "select * from customer";
		try {
			con = DriverManager.getConnection(url, username, password);
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(queryGet);
			while (rs.next()) {
				Customer customer = new Customer();
				customer.setCustomerEntryNumber(rs.getInt(1));
				customer.setCustomerMemberShipId(rs.getInt(2));
				customer.setCustomerName(rs.getString(3));
				customer.setCustomerBill(rs.getInt(4));
				customer.setCustomerFoodItemIds(rs.getString(5).substring(1, rs.getString(5).length()-1));
				customer.setCustomerFoodPurchaseTime(rs.getString(6));
				customers.add(customer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customers;
	}

	public static List<Customer> getTodayHistory(){
		List<Customer> customers = new LinkedList<>();
		String queryGet = "select * from customer";
		try {
			con = DriverManager.getConnection(url, username, password);
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(queryGet);
			while (rs.next()) {
				Customer customer = new Customer();
				customer.setCustomerEntryNumber(rs.getInt(1));
				customer.setCustomerMemberShipId(rs.getInt(2));
				customer.setCustomerName(rs.getString(3));
				customer.setCustomerBill(rs.getInt(4));
				customer.setCustomerFoodItemIds(rs.getString(5).substring(1, rs.getString(5).length()-1));
				customer.setCustomerFoodPurchaseTime(rs.getString(6));

				String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
				String[] timeSplit = customer.getCustomerFoodPurchaseTime().split(" ");
				if(timeSplit[0].equals(time)) {
					customers.add(customer);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customers;
	}

	public static List<Customer> getPresentMonthHistory(){
		List<Customer> customers = new LinkedList<>();
		String queryGet = "select * from customer";
		try {
			con = DriverManager.getConnection(url, username, password);
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(queryGet);
			while (rs.next()) {
				Customer customer = new Customer();
				customer.setCustomerEntryNumber(rs.getInt(1));
				customer.setCustomerMemberShipId(rs.getInt(2));
				customer.setCustomerName(rs.getString(3));
				customer.setCustomerBill(rs.getInt(4));
				customer.setCustomerFoodItemIds(rs.getString(5).substring(1, rs.getString(5).length()-1));
				customer.setCustomerFoodPurchaseTime(rs.getString(6));

				String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("MM"));
				String[] timeSplit = customer.getCustomerFoodPurchaseTime().split("-");
				if(timeSplit[1].equals(time)) {
					customers.add(customer);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customers;
	}

	public static boolean updateCustomer(Customer customer){
		boolean success = false;
		String queryUpdate = "UPDATE CUSTOMER SET "
				+" customerName='"+customer.getCustomerName()+"'"
				+", customerBill='"+customer.getCustomerBill()+"'"
				+", customerFoodItemIds='"+customer.getCustomerFoodItemIds()+"'"
				+", customerFoodPurchaseTime='"+customer.getCustomerFoodPurchaseTime()+"'"
				+" WHERE customerEntryNumber='"+customer.getCustomerEntryNumber()+"'";

		try {
			con = DriverManager.getConnection(url, username, password);
			Statement s = con.createStatement();
			int st = s.executeUpdate(queryUpdate);
			success = (st != 0 ? true : false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return success;
	}

	public static boolean deleteCustomer(Integer customerEntryNumber){
		boolean success = false;
		String queryDelete = "delete from CUSTOMER where customerEntryNumber = '"+ customerEntryNumber +"'";
		try {
			con = DriverManager.getConnection(url, username, password);
			Statement s = con.createStatement();
			int st = s.executeUpdate(queryDelete);
			success = (st != 0 ? true : false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return success;
	}
}
