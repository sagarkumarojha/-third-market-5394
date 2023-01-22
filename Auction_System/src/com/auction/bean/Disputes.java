package com.auction.bean;

import java.time.LocalDateTime;

public class Disputes {

	public Disputes(int id, int item_id, int buyer_id, String description,String solution,boolean resolved,LocalDateTime createdAt) {
		super();
		this.id = id;
		this.item_id = item_id;
		this.buyer_id = buyer_id;
		this.description = description;
		this.solution = description;
		this.createdAt=createdAt;
		this.resolved = resolved;
	}
	public Disputes() {
		super();
		// TODO Auto-generated constructor stub
	}
	private int id;
	private int item_id;
	private int buyer_id;
	private String description;
	private String solution;
	private boolean resolved;
	private LocalDateTime createdAt;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getItem_id() {
		return item_id;
	}
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
	public int getBuyer_id() {
		return buyer_id;
	}
	public void setBuyer_id(int buyer_id) {
		this.buyer_id = buyer_id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isResolved() {
		return resolved;
	}
	public void setResolved(boolean resolved) {
		this.resolved = resolved;
	}
	@Override
	public String toString() {
		return "Disputes [id=" + id + ", item_id=" + item_id + ", buyer_id=" + buyer_id + ", description=" + description
				+ ", solution=" + solution + ", resolved=" + resolved + ", createdAt=" + createdAt + "]";
	}
	public String getSolution() {
		return solution;
	}
	public void setSolution(String solution) {
		this.solution = solution;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	

}
