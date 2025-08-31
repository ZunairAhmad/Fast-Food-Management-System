package com.system.customer;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class C {

	public static void main(String[] args) throws ParseException {
		Customer c = new Customer();
		c.setCustomerEntryNumber(1004);
		c.setCustomerMemberShipId(0);
		c.setCustomerName("Saqib");
		c.setCustomerBill(5000);
		c.setCustomerFoodItemIds(Arrays.asList(1,2,3,4).toString());
		c.setCustomerFoodPurchaseTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")));
		//c.setCustomerFoodPurchaseTime("09-11-2020 15:39:35");
		//CustomerDao.addRecord(c);
		String time = c.getCustomerFoodPurchaseTime();

		DateFormat sdf = new SimpleDateFormat("dd-MM");
		Date date = sdf.parse(time);

		System.out.println("Time: " + sdf.format(date));
		
		System.out.println("Today Date: "+ (LocalDateTime.now().minusDays(30).format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))));
		int day = Integer.parseInt(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd")));
		System.out.println(Integer.parseInt(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd"))));
		CustomerDao dao = new CustomerDao();

		List<Customer> cust = dao.getPresentMonthHistory();
		//cust.forEach(System.out::println);
		//cust.forEach(x -> System.out.println(x.getCustomerFoodItemIds()));
	}

}
