package com.auction.bean;

import java.time.LocalDateTime;

public class Items {
	
	    private int itemId;
	    private int sellerId;
	    private String itemName;
	    private float startingPrice;
	    private float currentBid;
	    private LocalDateTime auctionStartTime;
	    public Items() {
			super();
			// TODO Auto-generated constructor stub
		}
		private LocalDateTime auctionEndTime;
	    private String category;
	    private int winnerId;

	    
		public int getItemId() {
			return itemId;
		}
		public void setItemId(int itemId) {
			this.itemId = itemId;
		}
		public int getSellerId() {
			return sellerId;
		}
		public void setSellerId(int sellerId) {
			this.sellerId = sellerId;
		}
		public String getItemName() {
			return itemName;
		}
		public void setItemName(String itemName) {
			this.itemName = itemName;
		}
		public float getStartingPrice() {
			return startingPrice;
		}
		public void setStartingPrice(float startingPrice) {
			this.startingPrice = startingPrice;
		}
		public float getCurrentBid() {
			return currentBid;
		}
		public void setCurrentBid(float currentBid) {
			this.currentBid = currentBid;
		}
		public LocalDateTime getAuctionStartTime() {
			return auctionStartTime;
		}
		public void setAuctionStartTime(LocalDateTime auctionStartTime) {
			this.auctionStartTime = auctionStartTime;
		}
		public LocalDateTime getAuctionEndTime() {
			return auctionEndTime;
		}
		public void setAuctionEndTime(LocalDateTime auctionEndTime) {
			this.auctionEndTime = auctionEndTime;
		}
		public String getCategory() {
			return category;
		}
		public void setCategory(String category) {
			this.category = category;
		}
		
		public Items(int itemId, int sellerId, String itemName, float startingPrice, float currentBid,
				LocalDateTime auctionStartTime, LocalDateTime auctionEndTime, String category, int winnerId) {
			super();
			this.itemId = itemId;
			this.sellerId = sellerId;
			this.itemName = itemName;
			this.startingPrice = startingPrice;
			this.currentBid = currentBid;
			this.auctionStartTime = auctionStartTime;
			this.auctionEndTime = auctionEndTime;
			this.category = category;
			this.winnerId = winnerId;
		}
		public Items(int itemId, String itemName, float startingPrice, float currentBid,
				LocalDateTime auctionStartTime, LocalDateTime auctionEndTime, String category, int sellerId) {
			super();
			this.itemId = itemId;
			this.sellerId = sellerId;
			this.itemName = itemName;
			this.startingPrice = startingPrice;
			this.currentBid = currentBid;
			this.auctionStartTime = auctionStartTime;
			this.auctionEndTime = auctionEndTime;
			this.category = category;
		}
		public Items(int itemId, String itemName, float startingPrice, float currentBid,
				LocalDateTime auctionStartTime, LocalDateTime auctionEndTime, String category) {
			super();
			this.itemId = itemId;
			this.itemName = itemName;
			this.startingPrice = startingPrice;
			this.currentBid = currentBid;
			this.auctionStartTime = auctionStartTime;
			this.auctionEndTime = auctionEndTime;
			this.category = category;
		}
		public int getWinnerId() {
			return winnerId;
		}
		public void setWinnerId(int winnerId) {
			this.winnerId = winnerId;
		}
		@Override
		public String toString() {
			return "Items [itemId=" + itemId + ", sellerId=" + sellerId + ", itemName=" + itemName + ", startingPrice="
					+ startingPrice + ", currentBid=" + currentBid + ", auctionStartTime=" + auctionStartTime
					+ ", auctionEndTime=" + auctionEndTime + ", category=" + category + ", winnerId=" + winnerId + "]";
		}
}
	

	

