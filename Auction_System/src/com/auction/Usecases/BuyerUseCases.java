package com.auction.Usecases;

import java.util.Scanner;

import com.auction.Dao.BuyerDAO;
import com.auction.Dao.BuyerDAOImpl;
import com.auction.Dao.SellerDAO;
import com.auction.Dao.SellerDAOImpl;
import com.auction.bean.Colors;
import com.auction.bean.Users;

public class BuyerUseCases extends SellerDAOImpl {
public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println(Colors.getBbgYellow() +"Enter Buyer Username: " + Colors.getReset());
		String UserName = sc.next();
		
		System.out.println(Colors.getBbgYellow()+"Enter Buyer Password: " + Colors.getReset());
		String Password = sc.next();
		
		try {
			
			BuyerDAO buyer = new BuyerDAOImpl();
			
			Users user = buyer.LoginBuyer(UserName, Password);
			
			if(user != null) {
				System.out.println("============================================");
				System.out.println("Login Successful");
				System.out.println("Your BuerId is "+ user.getUserId());

				System.out.println("============================================");
				
				while(true) {
					System.out.println();
					System.out.println("+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+**+*+*");
					System.out.println();
					
					System.out.println(Colors.getBgWhite() +"Enter 1 to Get All Item"+Colors.getReset());
					System.out.println(Colors.getBgWhite() +"Enter 2 to Get A Item Detail"+Colors.getReset());
					System.out.println(Colors.getBgWhite() +"Enter 3 to Get Item By Seller."+Colors.getReset());
					System.out.println(Colors.getBgWhite() +"Enter 4 to Get Won Item"+Colors.getReset());
					System.out.println(Colors.getBgWhite() +"Enter 5 to Place a Bid"+Colors.getReset());	
					System.out.println(Colors.getBgWhite() +"Enter 6 to Register a Dispute"+Colors.getReset());				
					System.out.println(Colors.getBgWhite() +"Enter 6 to Logout"+Colors.getReset());
					System.out.println();
					System.out.println("+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+**+*+*");
					System.out.println();
					
					int num = sc.nextInt();
					
					
					
				
                   switch(num) {
					
					case 1 : GetAllItem.main(args);
							  break;
					case 2 : GetAItemDetail.main(args);
					  		  break;
					case 3 : GetAItembySeller.main(args);
							  break;
					case 4 : WonitemsList.main(args);
							  break;
					case 5 : PlaceBid.main(args);
					  		  break;
					case 6 : RegisterDispute.main(args);
			  		  break;
					case 7 : {
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
