package com.system.customer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.system.Menu;

public class CustomerMenu {
	
	public static void customerMenu() {
		List<Customer> customers = null;
		Customer c = null;
		Integer customerEntryNumber = 0;
		
		try(Scanner scan = new Scanner(System.in);){
			while (true) {
				char ch = ' ';
				do {
					System.out.println("\n\n\n\nEnter Your Choice:\n ");
					System.out.println("1. Get All Customers History");
					System.out.println("2. Get Customers Today History");
					System.out.println("3. Get This Months Customer History");
					System.out.println("4. Update a Customer Record");
					System.out.println("5. Delete a Customer Record");
					System.out.println("6. Return to Main Menu");
					System.out.print("Choice:");
					ch =  scan.next().charAt(0);
					customers = null;
					switch (ch) {
					case '1':
						customers = CustomerDao.getAllHistory();
						if(customers==null) {
							System.out.println("No Record of today Date exists");
						} else {
							customers.forEach(System.out::println);
						}
						break;
					case '2':
						customers = CustomerDao.getTodayHistory();
						if(customers==null) {
							System.out.println("No Record of today Date exists");
						} else {
							customers.forEach(System.out::println);
						}
						break;
					case '3':
						customers = CustomerDao.getPresentMonthHistory();
						if(customers==null) {
							System.out.println("No Record of today Date exists");
						} else {
							customers.forEach(System.out::println);
						}
						break;
					case '4':
						c = new Customer(); 
						c.setCustomerEntryNumber(1003);
						c.setCustomerMemberShipId(0);
						c.setCustomerName("Saqib");
						c.setCustomerBill(5000);
						c.setCustomerFoodItemIds(Arrays.asList(1,2,3,4).toString());
						c.setCustomerFoodPurchaseTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")));
						
						boolean isUpdated = CustomerDao.updateCustomer(c);
						System.out.println((isUpdated==true) ? "Record Updated" : "Record Not Updated");
						System.out.println(c.toString());
						break;
					case '5':
						System.out.println("Enter Customer Entry Number");
						boolean isDeleted = CustomerDao.deleteCustomer(customerEntryNumber);
						System.out.println((isDeleted==true) ? "Record Deleted" : "Record Not Deleted");
						break;
					case '6':
						Menu.menu();
						break;
					default:
						System.out.println("\nInvalid Input!!!");
						System.out.println("Enter Your Choice again!!");
						break;
					}
				} while (!(ch=='1'||ch=='2'||ch=='3'||ch=='4'||ch=='5'||ch=='6'));
			}
		} catch(Exception e) {

		}

	}

}
