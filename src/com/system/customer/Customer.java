package com.system.customer;

public class Customer {

	private Integer customerEntryNumber;
	private Integer customerMemberShipId;
	private String customerName;
	private Integer customerBill;
	private String customerFoodItemIds;
	private String customerFoodPurchaseTime;
	
	public Customer() {}

	public Customer(Integer customerEntryNumber, Integer customerMemberShipId, String customerName,
			Integer customerBill, String customerFoodItemId, String customerFoodPurchaseTime) {
		this.customerEntryNumber = customerEntryNumber;
		this.customerMemberShipId = customerMemberShipId;
		this.customerName = customerName;
		this.customerBill = customerBill;
		this.customerFoodItemIds = customerFoodItemId;
		this.customerFoodPurchaseTime = customerFoodPurchaseTime;
	}

	@Override
	public String toString() {
		return "Customer [customerEntryNumber=" + customerEntryNumber + ", customerMemberShipId=" + customerMemberShipId
				+ ", customerName=" + customerName + ", customerBill=" + customerBill + ", customerFoodItemId="
				+ customerFoodItemIds + ", customerFoodPurchaseTime=" + customerFoodPurchaseTime + "]";
	}

	public Integer getCustomerEntryNumber() {
		return customerEntryNumber;
	}

	public void setCustomerEntryNumber(Integer customerEntryNumber) {
		this.customerEntryNumber = customerEntryNumber;
	}

	public Integer getCustomerMemberShipId() {
		return customerMemberShipId;
	}

	public void setCustomerMemberShipId(Integer customerMemberShipId) {
		this.customerMemberShipId = customerMemberShipId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Integer getCustomerBill() {
		return customerBill;
	}

	public void setCustomerBill(Integer customerBill) {
		this.customerBill = customerBill;
	}

	public String getCustomerFoodItemIds() {
		return customerFoodItemIds;
	}

	public void setCustomerFoodItemIds(String customerFoodItemIds) {
		this.customerFoodItemIds = customerFoodItemIds;
	}

	public String getCustomerFoodPurchaseTime() {
		return customerFoodPurchaseTime;
	}

	public void setCustomerFoodPurchaseTime(String customerFoodPurchaseTime) {
		this.customerFoodPurchaseTime = customerFoodPurchaseTime;
	}
	
}
