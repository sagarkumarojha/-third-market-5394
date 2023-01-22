package com.auction.bean;

public class Sells {
	private String itemName;
	private String sellerName;
	private String buyername;
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getSellerName() {
		return sellerName;
	}
	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}
	public String getBuyername() {
		return buyername;
	}
	public void setBuyername(String buyername) {
		this.buyername = buyername;
	}
	@Override
	public String toString() {
		return "Sells [itemName=" + itemName + ", sellerName=" + sellerName + ", buyername=" + buyername + "]";
	}
	public Sells(String itemName, String sellerName, String buyername) {
		super();
		this.itemName = itemName;
		this.sellerName = sellerName;
		this.buyername = buyername;
	}
	public Sells() {
		// TODO Auto-generated constructor stub
	}
	}
