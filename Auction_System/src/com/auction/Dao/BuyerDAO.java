package com.auction.Dao;

import java.util.List;

import com.auction.Exception.BidExcept;
import com.auction.Exception.BuyerExcept;
import com.auction.Exception.DisputeExcept;
import com.auction.Exception.ProductExcept;
import com.auction.bean.Items;
import com.auction.bean.Users;
 public interface BuyerDAO {

	public String registerBuyer(Users user)throws BuyerExcept;

	public Users LoginBuyer(String username, String password) throws BuyerExcept;

	public String placeBid(int itemId, int userId, float bidAmount) throws BidExcept;
		
	public List<Items> getAllItems() throws ProductExcept;
	
	public List<Items> getItemsbySeller(int UserId) throws  ProductExcept;

	public Items getItemDetails( int ProductID)throws  ProductExcept;
	
	public List<Items> getWonItems(int UserId) throws ProductExcept;

	String RegisterDisputes(int itemid, int user_id, String reason) throws DisputeExcept;
	
}

 
 