package com.system.employee;

import java.util.List;
import java.util.Scanner;

import com.system.Menu;

public class EmployeeMenu {

	public static void employeeMenu() {
		List<String> employees = null;
		Employee employee = null;
		Employee e = null;
		int employeeCode = 0;
		try(Scanner scan = new Scanner(System.in);){
			while (true) {
				char ch = ' ';
				do {
					System.out.println("\n\n\n\nEnter Your Choice:\n ");
					System.out.println("1. Add a new Employee");
					System.out.println("2. View All Employees");
					System.out.println("3. View All Employees By thier status");
					System.out.println("4. View All Working Employees");
					System.out.println("5. Get an Employee");
					System.out.println("6. Update an Employee");
					System.out.println("7. Delete an Employee");
					System.out.println("8. Return to menu");
					System.out.print("Choice:");
					ch =  scan.next().charAt(0);
					switch (ch) {
					case '1':
						e = new Employee();
						e.setEmployeeCode(1283);
						e.setEmployeeName("Abdullah Saqib");
						e.setEmployeeAge(20);
						e.setEmployeeContactNumber((long) 03311231333);
						e.setEmployeeWorkHours(6);
						e.setEmployeeStatus("Ma");
						e.setEmployeeAddress("Shadman, Gujrat");
						e.setWorking(false);
						e.setEmployeeSalary(10000);
						EmployeeDao.addEmployee(e);
						System.out.println(e.toString());
						break;
					case '2':
						List<Employee> employes = EmployeeDao.getAllEmployees();
						if(employes == null) {
							System.out.println("No Employee Record Found!");
						}else {
							employes.forEach(System.out::println);
						}
						break;
					case '3':
						employees = EmployeeDao.getEmployeeByStatus("Ma");
						if(employees == null) {
							System.out.println("No Employee Record Found!");
						}else {
							employees.forEach(System.out::println);
						}
						break;
					case '4':
						employees = EmployeeDao.getWorkingEmployee();
						if(employees == null) {
							System.out.println("No Employee Record Found!");
						}else {
							employees.forEach(System.out::println);
						}
						break;
					case '5':
						System.out.print("Enter Employee Code:");
						employeeCode = scan.nextInt();
						
						employee = EmployeeDao.getEmployee(employeeCode);
						if(employee == null) {
							System.out.println("No Employee With The Given Id is Found!");
						}else {
							System.out.println(employee.toString());
						}
						break;
					case '6':
						e = new Employee();
						e.setEmployeeCode(1281);
						e.setEmployeeName("Muhammad Saqib");
						e.setEmployeeAge(20);
						e.setEmployeeContactNumber((long) 03311232111);
						e.setEmployeeWorkHours(6);
						e.setEmployeeStatus("st");
						e.setEmployeeAddress("Shadman, Gujrat");
						e.setWorking(true);
						e.setEmployeeSalary(10000);
						boolean isUpdated = EmployeeDao.updateEmployee(e);
						System.out.println((isUpdated==true) ? "Record Updated\n"+e.toString() : "Record Not Updated");
						break;
					case '7':
						System.out.print("Enter Employee Code:");
						employeeCode = scan.nextInt();
						
						boolean isDeleted = EmployeeDao.deleteEmployee(employeeCode);
						System.out.println((isDeleted==true) ? "Record Deleted" : "Record Not Deleted");
						break;
					case '8':
						Menu.menu();
						break;	
					default:
						System.out.println("\nInvalid Input!!!");
						System.out.println("Enter Your Choice again!!");
						break;
					}
				} while (!(ch=='1'||ch=='2'||ch=='3'||ch=='4'||ch=='5'||ch=='6'||ch=='7'||ch=='8'));
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}

	}


}
