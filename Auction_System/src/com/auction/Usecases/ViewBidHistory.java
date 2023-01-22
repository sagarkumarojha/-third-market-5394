package com.auction.Usecases;

import java.util.List;
import java.util.Scanner;

import com.auction.Dao.SellerDAO;
import com.auction.Dao.SellerDAOImpl;
import com.auction.bean.Bid;
import com.auction.bean.Colors;

public class ViewBidHistory {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Item ID: ");
		int Id = scanner.nextInt();
				SellerDAO sellers =new SellerDAOImpl();
				 try {
						
						List<Bid> bids =  sellers.getBidHistory(Id);
						bids.forEach(b -> System.out.println(Colors.getBbgGreen()
			                    +b+ Colors.getReset()));
						
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
	}

}
