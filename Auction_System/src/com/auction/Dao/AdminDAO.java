package com.auction.Dao;



import java.util.List;

import com.auction.Exception.AdminExcept;
import com.auction.Exception.BuyerExcept;
import com.auction.Exception.DisputeExcept;
import com.auction.Exception.ProductExcept;
import com.auction.Exception.SellerExcept;
import com.auction.bean.Disputes;
import com.auction.bean.Bid;
import com.auction.bean.Users;


public interface AdminDAO {
	//For admin login py passing username and password.
	public Users AdminLogin(String username, String password)throws AdminExcept;
	
	//For admin to view the registered Buyer list;
	public List<Users> ViewRegisteredBuyerList() throws BuyerExcept;
	
	//For admin to view the registered Seller List;
	public List<Users> ViewRegisteredSellerList() throws SellerExcept;
	
	public List<Bid> ViewSellingReport()throws ProductExcept;
	
	public List<Disputes> ViewDailyDispute() throws ProductExcept;
	
	public String SolveDailyDispute(int disputeId, String resolution) throws DisputeExcept;

}
