package com.system.employee;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class EmployeeDao {

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
					+"WHERE TABLE_SCHEMA = 'fastFood' AND TABLE_NAME = 'EMPLOYEE'"; 
			
			Statement stmt = con.createStatement();
			boolean exists = stmt.execute(queryTableCheck);
			if (!exists) {
				String query = "CREATE TABLE EMPLOYEE("
						+ "employeeCode INT NOT NULL, "
						+ "employeeName VARCHAR (50) NOT NULL, "
						+ "employeeAge INT NOT NULL, "
						+ "employeeContactNumber INT NOT NULL, "
						+ "employeeWorkHours INT NOT NULL, "
						+ "employeeStatus CHAR(2) NOT NULL, "
						+ "employeeAddress VARCHAR (100) NOT NULL, "
						+ "employeeSalary INT NOT NULL, "
						+ "isWorking BOOLEAN NOT NULL, "
						+ "PRIMARY KEY (employeeCode))";
				boolean success = stmt.execute(query);
				System.out.println((success == true) ? "Table Created......" : "Table Not Created.....");
			}else {
				System.out.println("Employee Table......");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static Employee addEmployee(Employee employee) {
		String queryInsert = "insert into employee value (?,?,?,?,?,?,?,?,?)";
		try {
			con = DriverManager.getConnection(url, username, password);
			PreparedStatement st = con.prepareStatement(queryInsert);
			st.setInt(1, employee.getEmployeeCode());
			st.setString(2, employee.getEmployeeName());
			st.setInt(3, employee.getEmployeeAge());
			st.setLong(4, employee.getEmployeeContactNumber());
			st.setInt(5, employee.getEmployeeWorkHours());
			st.setString(6, employee.getEmployeeStatus());
			st.setString(7, employee.getEmployeeAddress());
			st.setLong(8, employee.getEmployeeSalary());
			st.setBoolean(9, employee.isWorking());
			st.execute();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employee;
	}

	public static List<Employee> getAllEmployees(){
		List<Employee> employees = new LinkedList<>();
		
		String queryGet = "select * from employee";
		try {
			con = DriverManager.getConnection(url, username, password);
			Statement s = con.createStatement();
			ResultSet st = s.executeQuery(queryGet);
			
			while(st.next()) {
				Employee employee = new Employee();
				employee.setEmployeeCode(st.getInt(1));
				employee.setEmployeeName(st.getString(2));
				employee.setEmployeeAge(st.getInt(3));
				employee.setEmployeeContactNumber(st.getLong(4));
				employee.setEmployeeWorkHours(st.getInt(5));
				employee.setEmployeeStatus(st.getString(6));
				employee.setEmployeeAddress(st.getString(7));
				employee.setEmployeeSalary(st.getLong(8));
				employee.setWorking(st.getBoolean(9));

				employees.add(employee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employees;
	}

	public static Employee getEmployee(int employeeCode) {
		Employee employee = new Employee();
		String queryGet = "select * from employee WHERE employeeCode='"+employeeCode+"'";
		try {
			con = DriverManager.getConnection(url, username, password);
			Statement s = con.createStatement();
			ResultSet st = s.executeQuery(queryGet);
			st.next();
			employee.setEmployeeCode(st.getInt(1));
			employee.setEmployeeName(st.getString(2));
			employee.setEmployeeAge(st.getInt(3));
			employee.setEmployeeContactNumber(st.getLong(4));
			employee.setEmployeeWorkHours(st.getInt(5));
			employee.setEmployeeStatus(st.getString(6));
			employee.setEmployeeAddress(st.getString(7));
			employee.setEmployeeSalary(st.getLong(8));
			employee.setWorking(st.getBoolean(9));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employee;
	}

	public static List<String> getWorkingEmployee(){
		List<String> employees = new LinkedList<>();
		
		String queryGet = "select * from employee where isWorking = '0'";
		try {
			con = DriverManager.getConnection(url, username, password);
			Statement s = con.createStatement();
			ResultSet st = s.executeQuery(queryGet);

			while(st.next()) {
				Employee employee = new Employee();
				employee.setEmployeeCode(st.getInt(1));
				employee.setEmployeeName(st.getString(2));
				employee.setEmployeeAge(st.getInt(3));
				employee.setEmployeeContactNumber(st.getLong(4));
				employee.setEmployeeWorkHours(st.getInt(5));
				employee.setEmployeeStatus(st.getString(6));
				employee.setEmployeeAddress(st.getString(7));
				employee.setEmployeeSalary(st.getLong(8));
				employee.setWorking(st.getBoolean(9));
				employees.add("[Employee Code: "+employee.getEmployeeCode() + " | Employee Name: "+employee.getEmployeeName()+"]");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employees;
	}

	public static List<String> getEmployeeByStatus(String employeeStatus){
		List<String> employees = new LinkedList<>();
		String queryGet = "select * from employee where employeeStatus = '"+ employeeStatus +"'";
		try {
			con = DriverManager.getConnection(url, username, password);
			Statement s = con.createStatement();
			ResultSet st = s.executeQuery(queryGet);

			while(st.next()) {
				Employee employee = new Employee();
				employee.setEmployeeCode(st.getInt(1));
				employee.setEmployeeName(st.getString(2));
				employee.setEmployeeAge(st.getInt(3));
				employee.setEmployeeContactNumber(st.getLong(4));
				employee.setEmployeeWorkHours(st.getInt(5));
				employee.setEmployeeStatus(st.getString(6));
				employee.setEmployeeAddress(st.getString(7));
				employee.setEmployeeSalary(st.getLong(8));
				employee.setWorking(st.getBoolean(9));
				employees.add("[Employee Code: "+employee.getEmployeeCode() + " | Employee Name: "+employee.getEmployeeName()
				+" | Employee Status: "+employee.getEmployeeStatus()+"]");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employees;
	}

	public static boolean updateEmployee(Employee employee){
		boolean success = false;
		String queryUpdate = "UPDATE EMPLOYEE SET "
				+" employeeName='"+employee.getEmployeeName()+"'"
				+", employeeAge='"+employee.getEmployeeAge()+"'"
				+", employeeContactNumber='"+employee.getEmployeeContactNumber()+"'"
				+", employeeWorkHours='"+employee.getEmployeeWorkHours()+"'"
				+", employeeStatus='"+employee.getEmployeeStatus()+"'"
				+", employeeAddress='"+employee.getEmployeeAddress()+"'"
				+", isWorking='"+(employee.isWorking()==true?1:0)+"'"
				+", employeeSalary='"+employee.getEmployeeSalary()+"'"
				+" WHERE employeeCode='"+employee.getEmployeeCode()+"'";

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

	public static boolean deleteEmployee(Integer employeeCode){
		boolean success = false;
		String queryDelete = "delete from employee where employeeCode = '"+ employeeCode +"'";
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