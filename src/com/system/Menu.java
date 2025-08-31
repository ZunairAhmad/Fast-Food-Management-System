package com.system;

import java.util.Scanner;

import com.system.customer.CustomerMemberShipMenu;
import com.system.customer.CustomerMenu;
import com.system.employee.EmployeeMenu;

public class Menu {

	public static void menu() {
		try(Scanner scan = new Scanner(System.in);){
			while (true) {
				char ch = ' ';
				do {
					System.out.println("Enter Your Choice:\n ");
					System.out.println("1. Enter Customer Menu");
					System.out.println("2. Enter Customer MemberShip Menu");
					System.out.println("3. Enter Employee Menu");
					System.out.println("4. Enter Food Menu");
					System.out.println("5. Enter Food Deals Menu");
					System.out.print("Choice:->");
					ch =  scan.next().charAt(0);
					System.out.println("\n\n\n\n");
					switch (ch) {
					case '1':
						CustomerMenu.customerMenu();
						break;
					case '2':
						CustomerMemberShipMenu.customerMemberShipMenu();
						break;
					case '3':
						EmployeeMenu.employeeMenu();
						break;
					case '4':
						break;
					case '5':
						break;
					default:
						System.out.println("\nInvalid Input!!!");
						System.out.println("Enter Your Choice again!!");
						break;
					}
				} while (!(ch=='1'||ch=='2'||ch=='3'||ch=='4'||ch=='5'));
			}
		} catch(Exception e) {

		}
	}

}
