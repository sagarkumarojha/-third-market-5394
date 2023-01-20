package com.auction.Dao;

import java.util.List;

import com.auction.Exception.ProductExcept;
import com.auction.Exception.SellerExcept;
import com.auction.Exception.SoldProductDTOExcept;
import com.auction.bean.Items;
import com.auction.bean.Sold_items;
import com.auction.bean.Users;

public interface SellerDAO {
	
	public Users SellerLogin(String username, String password)throws SellerExcept;
	
	public String RegisterSeller(Users seller);
	
	public List<Items> CreateListofProducttoSell()throws ProductExcept;
	
	public String UpdateProductinList(Items product);
	
	public String AddProducttoSell(Items product);
	
	public String RemoveProductfromList(int id);
	
	public List<Sold_items> ViewSoldProductHistory() throws SoldProductDTOExcept;
}
