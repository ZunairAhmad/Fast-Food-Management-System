package com.system.foodItem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.system.customer.Customer;

public class FoodItemDao {

	public static LinkedList<FoodItem> foodItems = new LinkedList<>();
	
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
					+"WHERE TABLE_SCHEMA = 'fastFood' AND TABLE_NAME = 'FoodItem'"; 

			Statement stmt = con.createStatement();
			boolean exists = stmt.execute(queryTableCheck);
			if (!exists) {
				String query = "CREATE TABLE FoodItem("
						+ "foodItemId INT NOT NULL, "
						+ "foodItemName VARCHAR (50) NOT NULL, "
						+ "foodItemPrice INT NOT NULL, "
						+ "foodItemSize VARCHAR (50) NOT NULL, "
						+ "isAvailable bool(1) NOT NULL, "
						+ "PRIMARY KEY (foodItemId))";
				stmt.execute(query);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public FoodItemDao() {}
	
	public static FoodItem addFoodItem(FoodItem foodItem) {
		String queryInsert = "insert into FoodItem value (?,?,?,?,?)";
		try {
			con = DriverManager.getConnection(url, username, password);
			PreparedStatement st = con.prepareStatement(queryInsert);
			st.setInt(1, foodItem.getFoodItemId());
			st.setString(2, foodItem.getFoodItemName());
			st.setInt(3, foodItem.getFoodItemPrice());
			st.setString(4, foodItem.getFoodItemSize());
			st.setBoolean(5, foodItem.isAvailable());
			st.execute();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return foodItem;
	}
	
	public static FoodItem getFoodItem(int foodItemId) {
		FoodItem foodItem = new FoodItem();
		String queryGet = "select * from FoodItem WHERE foodItemId='"+foodItemId+"'";
		try {
			con = DriverManager.getConnection(url, username, password);
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(queryGet);
			rs.next();
			foodItem.setFoodItemId(rs.getInt(1));
			foodItem.setFoodItemName(rs.getString(2));
			foodItem.setFoodItemPrice(rs.getInt(3));
			foodItem.setFoodItemSize(rs.getString(4));
			foodItem.setAvailable(rs.getBoolean(5));
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return foodItem;
	}
	
	public static List<FoodItem> getAllFoodItems() {
		List<FoodItem> foodItems = new LinkedList<>();
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
		foodItems.forEach(food -> System.out.println(food.toString()));
	}
	
	public void updateFoodItem() {
		FoodItem foodItem = foodItems.get(2);
		foodItem.setFoodItemId(foodItem.getFoodItemId());
		foodItem.setFoodItemName("Patty Burger");
		foodItem.setFoodItemPrice(foodItem.getFoodItemPrice());
		foodItem.setFoodItemSize(foodItem.getFoodItemSize());
		foodItem.setAvailable(foodItem.isAvailable());
		foodItems.set(2, foodItem );
	}
	
	public void deleteFoodItem() {
		foodItems.remove(1);
	}
	
	public void test() {
		double sum = 0;
		for (FoodItem f : foodItems) {
			sum += f.getFoodItemPrice();
		}
		System.out.println("Sum is: " + (sum - ((sum/100)*20)));
	}

}
