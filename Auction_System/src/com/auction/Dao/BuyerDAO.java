package com.auction.Dao;

import java.util.List;

import com.auction.Exception.BuyerExcept;
import com.auction.Exception.BuyerProductDTOExcept;
import com.auction.Exception.ProductExcept;
import com.auction.bean.Items;
import com.auction.bean.Users;
 interface BuyerDAO {

	public Users BuyerLogin(String username, String password)throws BuyerExcept;

	public String RegisterBuyer(Users buyer);
	
	public List<Items> SearchProduct(String category) throws ProductExcept;
	
	public Items SelectProductstoBuy(int BuyerId, int ProductID, int Quantity)throws BuyerExcept, ProductExcept;
	
	public List<?> SelectBuyerandProduct() throws BuyerProductDTOExcept;
	
}
