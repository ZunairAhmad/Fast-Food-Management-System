package com.system.customer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import com.system.Menu;

public class CustomerMemberShipMenu {

	public static void customerMemberShipMenu() {
		List<CustomerMemberShip> customers = null;
		CustomerMemberShip customer = null;
		long memberShipCode = 0;
		try(Scanner scan = new Scanner(System.in);){
			while (true) {
				char ch = ' ';
				do {
					System.out.println("\n\n\n\nEnter Your Choice:\n ");
					System.out.println("1. Add a new MemberShip Customer");
					System.out.println("2. View All MemberShip Customers");
					System.out.println("3. Get a MemberShip Customer");
					System.out.println("4. Update a MemberShip Customer");
					System.out.println("5. Delete a MemberShip Customer");
					System.out.println("6. Return to menu");
					System.out.print("Choice:");
					ch =  scan.next().charAt(0);
					customers = null;
					customer = null;
					switch (ch) {
					case '1':
						CustomerMemberShip c = new CustomerMemberShip();
						
						c.setMemberShipID(1);
						c.setMemberShipCode((long)1221);
						c.setMemberShipName("Muhammad Saqib");
						c.setMemberShipType(MemberShipType.GOLD);
						c.setActive(true);
						c.setMemberShipStartDate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
						c.setMemberShipEndDate(LocalDateTime.now().plusDays(30).format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
						
						CustomerMemberShipDao.addMemberShipCustomer(c);
						break;
					case '2':
						customers = CustomerMemberShipDao.getAllMemberShipCustomer();
						if (customers == null) {
							System.out.println("No Record Found");
						} else {
							customers.forEach(System.out::println);
						}
						break;
					case '3':
						customer = new CustomerMemberShip();
						System.out.print("Enter Customer Member Ship Code:");
						memberShipCode = scan.nextLong();
						
						customer = CustomerMemberShipDao.getMemberShipCustomer(memberShipCode);
						System.out.println(customer.toString());
						break;
					case '4':
						System.out.print("Enter Customer Member Ship Code:");
						memberShipCode = scan.nextLong();
						
						customer = new CustomerMemberShip();
						customer.setMemberShipID(1);
						customer.setMemberShipCode(memberShipCode);
						customer.setMemberShipName("Muhammad Saqib");
						customer.setMemberShipType(MemberShipType.GOLD);
						customer.setActive(true);
						customer.setMemberShipStartDate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
						customer.setMemberShipEndDate(LocalDateTime.now().plusDays(30).format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
						
						boolean isUpdated = CustomerMemberShipDao.updateCustomerMemberShip(customer);
						System.out.println((isUpdated==true) ? "Record Updated" : "Record Not Updated");
						
						customer = CustomerMemberShipDao.getMemberShipCustomer(customer.getMemberShipCode());
						System.out.println(customer.toString());
						break;
					case '5':
						System.out.print("Enter Customer Member Ship Code:");
						memberShipCode = scan.nextLong();
						
						boolean isDeleted = CustomerMemberShipDao.deleteCustomerMemberShip(memberShipCode);
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
