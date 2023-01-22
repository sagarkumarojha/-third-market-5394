package com.auction.Usecases;

import java.util.Scanner;

import com.auction.Dao.AdminDAO;
import com.auction.Dao.AdminDAOImpl;
import com.auction.Dao.SellerDAO;
import com.auction.Dao.SellerDAOImpl;
import com.auction.bean.Colors;
import com.auction.bean.Users;


public class SellerUseCases {
public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println(Colors.getBbgYellow() +"Enter Seller Username: " + Colors.getReset());
		String UserName = sc.next();
		
		System.out.println(Colors.getBbgYellow()+"Enter Seller Password: " + Colors.getReset());
		String Password = sc.next();
		
		try {
			
			SellerDAO seller = new SellerDAOImpl();
			
			Users user = seller.SellerLogin(UserName, Password);
			
			if(user != null) {
				System.out.println("============================================");
				System.out.println("Login Successful");
				System.out.println("============================================");
				
				while(true) {
					System.out.println();
					System.out.println("+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+**+*+*");
					System.out.println();
					
					System.out.println(Colors.getBgWhite() +"Enter 1 to Create new Item"+Colors.getReset());
					System.out.println(Colors.getBgWhite() +"Enter 2 to Update auction of a Item"+Colors.getReset());
					System.out.println(Colors.getBgWhite() +"Enter 3 to Remove A Item."+Colors.getReset());
					System.out.println(Colors.getBgWhite() +"Enter 4 to view bid history"+Colors.getReset());
					System.out.println(Colors.getBgWhite() +"Enter 5 to view Sales Report"+Colors.getReset());				
					System.out.println(Colors.getBgWhite() +"Enter 6 to Logout"+Colors.getReset());
					System.out.println();
					System.out.println("+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+**+*+*");
					System.out.println();
					
					int num = sc.nextInt();
					
					
					
				
                   switch(num) {
					
					case 1 : CreateNewItem.main(args);
							  break;
					case 2 : UpdateAuctionTime.main(args);
					  		  break;
					case 3 : RemoveItem.main(args);
							  break;
					case 4 : ViewBidHistory.main(args);
							  break;
					case 5 : SalesReport.main(args);
					  		  break;
					case 6 : {
						System.out.println("============================================");
						System.out.println("LogOut Successful");
						System.out.println("============================================");
								return;
							 }
					default : System.out.println("Select valid option");
					
					}
					
				}
			}
			} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
