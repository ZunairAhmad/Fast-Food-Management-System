package com.system.foodItemdeals;

import java.util.LinkedList;

import com.system.foodItem.FoodItem;
import com.system.foodItem.FoodItemDao;

public class FoodItemDeals {
	
	private static LinkedList<FoodItem> foodItems = new LinkedList<>();
	private static LinkedList<LinkedList<FoodItem>> foodItemDeals = new LinkedList<>();
	private static FoodItem foodItem;
	private double foodItemDealsPrice;

	public static void test() {
		Integer[] ids = new Integer[3];
		for(int i = 0 ; i<ids.length ; i++) {
			foodItems.add(FoodItemDao.getById(i));
		}
		foodItemDeals.add(foodItems);
		foodItemDeals.add(foodItems);
		foodItemDeals.forEach(item -> System.out.println(item.get(0)));
	}
	
}
