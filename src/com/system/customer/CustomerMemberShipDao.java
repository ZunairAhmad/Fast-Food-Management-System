package com.system.customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class CustomerMemberShipDao {

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
					+"WHERE TABLE_SCHEMA = 'fastFood' AND TABLE_NAME = 'CUSTOMER_MEMBER_SHIP'"; 

			Statement stmt = con.createStatement();
			boolean exists = stmt.execute(queryTableCheck);
			if(exists == false) {
				String query = "CREATE TABLE CUSTOMER_MEMBER_SHIP("
						+ "memberShipID INT NOT NULL, "
						+ "memberShipCode long NOT NULL UNIQUE, "
						+ "memberShipName VARCHAR(50) NOT NULL, "
						+ "memberShipStartDate VARCHAR (50) NOT NULL, "
						+ "memberShipEndDate VARCHAR (50) NOT NULL, "
						+ "memberShipType VARCHAR (10) NOT NULL,"
						+ "isActive bool not null,"
						+ "PRIMARY KEY (memberShipCode))";
				stmt.execute(query);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public CustomerMemberShipDao() {}

	public static CustomerMemberShip addMemberShipCustomer(CustomerMemberShip customerMemberShip){
		String queryInsert = "insert into CUSTOMER_MEMBER_SHIP value (?,?,?,?,?,?,?)";
		try {
			con = DriverManager.getConnection(url, username, password);
			PreparedStatement st = con.prepareStatement(queryInsert);
			st.setInt(1, customerMemberShip.getMemberShipID());
			st.setLong(2, customerMemberShip.getMemberShipCode());
			st.setString(3, customerMemberShip.getMemberShipName());
			st.setString(4, customerMemberShip.getMemberShipStartDate());
			st.setString(5, customerMemberShip.getMemberShipEndDate());
			st.setString(6, customerMemberShip.getMemberShipType().toString());
			st.setBoolean(7, customerMemberShip.isActive());
			st.execute();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return customerMemberShip;
	}

	public static List<CustomerMemberShip> getAllMemberShipCustomer(){
		List<CustomerMemberShip> memberShipCustomers = new LinkedList<>();
		String queryGet = "select * from CUSTOMER_MEMBER_SHIP";
		try {
			con = DriverManager.getConnection(url, username, password);
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(queryGet);
			while (rs.next()) {
				CustomerMemberShip memberShipCustomer = new CustomerMemberShip();
				memberShipCustomer.setMemberShipID(rs.getInt(1));
				memberShipCustomer.setMemberShipCode(rs.getLong(2));
				memberShipCustomer.setMemberShipName(rs.getString(3));
				memberShipCustomer.setMemberShipStartDate(rs.getString(4));
				memberShipCustomer.setMemberShipEndDate(rs.getString(5));
				memberShipCustomer.setMemberShipType(MemberShipType.valueOf(rs.getString(6)));
				memberShipCustomer.setActive(rs.getBoolean(7));
				memberShipCustomers.add(memberShipCustomer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return memberShipCustomers;
	}

	public static CustomerMemberShip getMemberShipCustomer(Long memberShipCustomerCode){
		CustomerMemberShip memberShipCustomer = new CustomerMemberShip();
		String queryGet = "select * from CUSTOMER_MEMBER_SHIP WHERE memberShipCode='"+memberShipCustomerCode+"'";
		try {
			con = DriverManager.getConnection(url, username, password);
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(queryGet);
			rs.next();
			memberShipCustomer.setMemberShipID(rs.getInt(1));
			memberShipCustomer.setMemberShipCode(rs.getLong(2));
			memberShipCustomer.setMemberShipName(rs.getString(3));
			memberShipCustomer.setMemberShipStartDate(rs.getString(4));
			memberShipCustomer.setMemberShipEndDate(rs.getString(5));
			memberShipCustomer.setMemberShipType(MemberShipType.valueOf(rs.getString(6)));
			memberShipCustomer.setActive(rs.getBoolean(7));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return memberShipCustomer;
	}

	public static boolean updateCustomerMemberShip(CustomerMemberShip customerMemberShip){
		boolean success = false;
		String queryUpdate = "UPDATE CUSTOMER_MEMBER_SHIP SET "
				+" memberShipID='"+customerMemberShip.getMemberShipID()+"'"
				+", memberShipName='"+customerMemberShip.getMemberShipName()+"'"
				+", memberShipStartDate='"+customerMemberShip.getMemberShipStartDate()+"'"
				+", memberShipEndDate='"+customerMemberShip.getMemberShipEndDate()+"'"
				+", memberShipType='"+customerMemberShip.getMemberShipType()+"'"
				+", isActive='"+(customerMemberShip.isActive()==true?1:0)+"'"
				+", where 'memberShipCode='"+customerMemberShip.getMemberShipCode()+"'";

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

	public static boolean deleteCustomerMemberShip(long memberShipCode){
		boolean success = false;
		String queryDelete = "delete from CUSTOMER_MEMBER_SHIP where memberShipCode = '"+ memberShipCode +"'";
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
