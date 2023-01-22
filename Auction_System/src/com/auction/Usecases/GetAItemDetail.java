package com.auction.Usecases;

import java.util.List;
import java.util.Scanner;

import com.auction.Dao.BuyerDAO;
import com.auction.Dao.BuyerDAOImpl;
import com.auction.Exception.ProductExcept;
import com.auction.bean.Items;

public class GetAItemDetail {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter item ID: ");
		int itemId = scanner.nextInt();
		BuyerDAO buyer= new BuyerDAOImpl();
		try {
		 Items	item = buyer.getItemDetails(itemId);
			    System.out.println("Item ID: " + item.getItemId());
			    System.out.println("Item Name: " + item.getItemName());
			    System.out.println("Starting Price: " + item.getStartingPrice());
			    System.out.println("Auction Start Time: " + item.getAuctionStartTime());
			    System.out.println("Auction End Time: " + item.getAuctionEndTime());
			    System.out.println("---");

		} catch (ProductExcept e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



	}

}
