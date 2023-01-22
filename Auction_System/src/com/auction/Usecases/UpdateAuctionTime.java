package com.auction.Usecases;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import com.auction.Dao.SellerDAO;
import com.auction.Dao.SellerDAOImpl;
import com.auction.Exception.ProductExcept;

public class UpdateAuctionTime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Item ID: ");
		int Id = scanner.nextInt();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		System.out.println("Enter auction start time (yyyy-MM-dd HH:mm:ss): ");
		LocalDateTime auctionStartTime = LocalDateTime.parse(scanner.next(),formatter);
		System.out.println("Enter auction end time (yyyy-MM-dd HH:mm:ss): ");
		LocalDateTime auctionEndTime = LocalDateTime.parse(scanner.next(),formatter);

		SellerDAO seller =new SellerDAOImpl();
		try {
		String res=	seller.updateItemauctionTime(Id,auctionStartTime,auctionEndTime);
		System.out.println(res);
		} catch (ProductExcept e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
