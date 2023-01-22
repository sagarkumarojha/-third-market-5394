package com.auction.Usecases;

import java.util.Scanner;

import com.auction.Dao.BuyerDAO;
import com.auction.Dao.BuyerDAOImpl;
import com.auction.Exception.BidExcept;

public class PlaceBid {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BuyerDAO buyer= new BuyerDAOImpl();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter item ID: ");
		int itemId = scanner.nextInt();
		System.out.println("Enter user ID: ");
		int userId = scanner.nextInt();
		System.out.println("Enter bid amount: ");
		float bidAmount = scanner.nextFloat();
		try {
			buyer.placeBid(itemId, userId, bidAmount);
		} catch (BidExcept e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}




	}

}
