package com.system.foodItem;

public class FoodItem {

	private Integer foodItemId;
	private String foodItemName;
	private Integer foodItemPrice;
	private String foodItemSize;
	private boolean isAvailable;
	
	public FoodItem() {}

	public FoodItem(Integer foodItemId, String foodItemName, Integer foodItemPrice, boolean isAvailable, String foodItemSize) {
		super();
		this.foodItemId = foodItemId;
		this.foodItemName = foodItemName;
		this.foodItemPrice = foodItemPrice;
		this.isAvailable = isAvailable;
		this.foodItemSize = foodItemSize;
	}

	@Override
	public String toString() {
		return "FoodItem [foodItemId=" + foodItemId + ", foodItemName=" + foodItemName + ", foodItemPrice="
				+ foodItemPrice + ", foodItemSize=" + foodItemSize + ", isAvailable=" + isAvailable + "]";
	}

	public Integer getFoodItemId() {
		return foodItemId;
	}

	public void setFoodItemId(Integer foodItemId) {
		this.foodItemId = foodItemId;
	}

	public String getFoodItemName() {
		return foodItemName;
	}

	public void setFoodItemName(String foodItemName) {
		this.foodItemName = foodItemName;
	}

	public Integer getFoodItemPrice() {
		return foodItemPrice;
	}

	public void setFoodItemPrice(Integer foodItemPrice) {
		this.foodItemPrice = foodItemPrice;
	}

	public String getFoodItemSize() {
		return foodItemSize;
	}

	public void setFoodItemSize(String foodItemSize) {
		this.foodItemSize = foodItemSize;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
}
