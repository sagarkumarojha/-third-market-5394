package com.auction.bean;

import java.time.LocalDateTime;

public class Bid {
	int bidId;
    int itemId;
    int userId;
    float bidAmount;
    LocalDateTime bidTime;
	public int getBidId() {
		return bidId;
	}
	public void setBidId(int bidId) {
		this.bidId = bidId;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public float getBidAmount() {
		return bidAmount;
	}
	public void setBidAmount(float bidAmount) {
		this.bidAmount = bidAmount;
	}
	public LocalDateTime getBidTime() {
		return bidTime;
	}
	public void setBidTime(LocalDateTime bidTime) {
		this.bidTime = bidTime;
	}
	public Bid(int bidId, int itemId, int userId, float bidAmount, LocalDateTime bidTime) {
		super();
		this.bidId = bidId;
		this.itemId = itemId;
		this.userId = userId;
		this.bidAmount = bidAmount;
		this.bidTime = bidTime;
	}
	@Override
	public String toString() {
		return "Bid [bidId=" + bidId + ", itemId=" + itemId + ", userId=" + userId + ", bidAmount=" + bidAmount
				+ ", bidTime=" + bidTime + "]";
	}
	public Bid() {
		super();
		// TODO Auto-generated constructor stub
	}

}
