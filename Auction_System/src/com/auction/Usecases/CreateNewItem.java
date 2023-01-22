package com.auction.Usecases;

import java.time.LocalDateTime;
import java.util.Scanner;

import com.auction.Dao.SellerDAO;
import com.auction.Dao.SellerDAOImpl;
import com.auction.Exception.ProductExcept;
import com.auction.bean.Items;

public class CreateNewItem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter seller ID: ");
		int sellerId = scanner.nextInt();
		System.out.println("Enter item name: ");
		String itemName = scanner.nextLine();
		System.out.println("Enter starting price: ");
		float startingPrice = scanner.nextFloat();
		System.out.println("Enter auction start time (yyyy-MM-dd HH:mm:ss): ");
		LocalDateTime auctionStartTime = LocalDateTime.parse(scanner.nextLine());
		System.out.println("Enter auction end time (yyyy-MM-dd HH:mm:ss): ");
		LocalDateTime auctionEndTime = LocalDateTime.parse(scanner.nextLine());
		System.out.println("Enter category: ");
		String category = scanner.nextLine();
		Items item =new Items();
		item.setSellerId(sellerId);
		item.setItemName(itemName);
		item.setStartingPrice(startingPrice);
		item.setAuctionStartTime(auctionStartTime);
		item.setAuctionEndTime(auctionEndTime);
		item.setCategory(category);
		SellerDAO seller =new SellerDAOImpl();
		try {
			seller.createNewItem(item);
		} catch (ProductExcept e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		


	}

}
