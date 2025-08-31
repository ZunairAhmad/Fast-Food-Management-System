package com.system.customer;

enum MemberShipType{
	BRONZE("Bronze"),
	SILVER("Silver"),
	GOLD("Gold");

	MemberShipType(String string) {}
	
}

public class CustomerMemberShip {
	private int memberShipID;
	private String memberShipName;
	private Long memberShipCode;
	private String memberShipStartDate;
	private String memberShipEndDate;
	private MemberShipType memberShipType;
	private boolean isActive;
	
	public CustomerMemberShip() {}
	
	public CustomerMemberShip(int memberShipID, String memberShipName, Long memberShipCode, String memberShipStartDate,
			String memberShipEndDate, MemberShipType memberShipType, boolean isActive) {
		super();
		this.memberShipID = memberShipID;
		this.memberShipName = memberShipName;
		this.memberShipCode = memberShipCode;
		this.memberShipStartDate = memberShipStartDate;
		this.memberShipEndDate = memberShipEndDate;
		this.memberShipType = memberShipType;
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "CustomerMemberShip [memberShipID=" + memberShipID + ", memberShipName=" + memberShipName
				+ ", memberShipCode=" + memberShipCode + ", memberShipStartDate=" + memberShipStartDate
				+ ", memberShipEndDate=" + memberShipEndDate + ", memberShipType=" + memberShipType + ", isActive="
				+ isActive + "]";
	}

	public int getMemberShipID() {
		return memberShipID;
	}

	public void setMemberShipID(int memberShipID) {
		this.memberShipID = memberShipID;
	}

	public String getMemberShipName() {
		return memberShipName;
	}

	public void setMemberShipName(String memberShipName) {
		this.memberShipName = memberShipName;
	}

	public Long getMemberShipCode() {
		return memberShipCode;
	}

	public void setMemberShipCode(Long memberShipCode) {
		this.memberShipCode = memberShipCode;
	}

	public String getMemberShipStartDate() {
		return memberShipStartDate;
	}

	public void setMemberShipStartDate(String memberShipStartDate) {
		this.memberShipStartDate = memberShipStartDate;
	}

	public String getMemberShipEndDate() {
		return memberShipEndDate;
	}

	public void setMemberShipEndDate(String memberShipEndDate) {
		this.memberShipEndDate = memberShipEndDate;
	}

	public MemberShipType getMemberShipType() {
		return memberShipType;
	}

	public void setMemberShipType(MemberShipType memberShipType) {
		this.memberShipType = memberShipType;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	
}
