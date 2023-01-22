package com.auction.Dao;
import java.time.LocalDateTime;
import java.util.List;

import com.auction.Exception.ProductExcept;
import com.auction.Exception.SellerExcept;
import com.auction.bean.Items;
import com.auction.bean.Bid;
import com.auction.bean.Users;

public interface SellerDAO {
	
	public Users SellerLogin(String username, String password)throws SellerExcept;
	
	public String RegisterSeller(Users seller) throws SellerExcept;
	
	public String createNewItem(Items item)throws ProductExcept;
	
	public String updateItemauctionTime(int itemId,LocalDateTime auctionStartTime, LocalDateTime auctionEndTime)throws ProductExcept;
	
	public String RemoveProductfromList(int id) throws ProductExcept;
	
	public List<Bid> ViewSoldProductHistory() throws ProductExcept;
}
