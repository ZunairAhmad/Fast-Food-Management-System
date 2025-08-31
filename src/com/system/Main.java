package com.system;

import java.sql.SQLException;
import java.util.List;

import com.system.employee.Employee;
import com.system.employee.EmployeeDao;

@SuppressWarnings("unused")
public class Main {

	public static void main(String[] args) {
		Menu.menu();
//		String dbUrl = "jdbc:mysql://localhost:3306/student_jdbc?useSSL=false";
//		String user = "student";
//		String pass = "student";
		
//		try {
//			Employee e = new Employee();
//			e.setEmployeeCode(1281);
//			e.setEmployeeName("Abdullah Saqib");
//			e.setEmployeeAge(20);
//			e.setEmployeeContactNumber((long) 03311231333);
//			e.setEmployeeWorkHours(6);
//			e.setEmployeeStatus("Ma");
//			e.setEmployeeAddress("Shadman, Gujrat");
//			e.setWorking(false);
//			e.setEmployeeSalary(10000);
			
			
			//EmployeeDao.addEmployee(e);
			
			//System.out.println(EmployeeDao.updateEmployee(e));
			//System.out.println(EmployeeDao.deleteEmployee(1280));
			
			//List<Employee> employees = EmployeeDao.getAllEmployees();
			//employees.forEach(System.out::println);
			
//			List<String> employee = EmployeeDao.getWorkingEmployee();
//			employee.forEach(System.out::println);
//			
//			employee = EmployeeDao.getEmployeeByStatus("St");
//			employee.forEach(System.out::println);
			
			
			//Employee ee = EmployeeDao.getEmployee(1280);
			//System.out.println(ee.toString());
			
//			Connection myCon = DriverManager.getConnection(dbUrl, user, pass);
//			Statement myStmt = myCon.createStatement();
//			PreparedStatement ps = null;
//			ResultSet myRs = null;
//			int rowsAffected = 0;
			
			// add query
			//rowsAffected = myStmt.executeUpdate("insert into employees values ('15', 'saqib', 'muhammad', 'saqib@gmail.com', 'HR', '33000.00') ");
			
			//update query
			//rowsAffected = myStmt.executeUpdate("update employees set email=('saqi@facebook.com') where last_name='saqib'");
			
			//delete query
			//rowsAffected = myStmt.executeUpdate("delete from employees where last_name='saqib' and first_name='muhammad'");
			
			//get all data query
			//myRs = myStmt.executeQuery("select * from employees ");
			//while(myRs.next()) {
			//	System.out.println(myRs.getString("last_name") +", "+ myRs.getString("email"));
			//}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
	}

}
