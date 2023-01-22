package com.auction.Usecases;

import java.util.Scanner;

import com.auction.Dao.AdminDAO;
import com.auction.Dao.AdminDAOImpl;
import com.auction.bean.Colors;
import com.auction.bean.Users;


public class AdminUseCases {
public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println(Colors.getBbgYellow() +"Enter Admin Username: " + Colors.getReset());
		String adminUserName = sc.next();
		
		System.out.println(Colors.getBbgYellow()+"Enter Addmin Password: " + Colors.getReset());
		String adminPassword = sc.next();
		
		try {
			
			AdminDAO admin = new AdminDAOImpl();
			
			Users user = admin.AdminLogin(adminUserName, adminPassword);
			
			if(user != null) {
				System.out.println("============================================");
				System.out.println("Login Successful");
				System.out.println("============================================");
				
				while(true) {
					System.out.println();
					System.out.println("+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+**+*+*");
					System.out.println();
					
					System.out.println(Colors.getBgWhite() +"Enter 1 to View ALL Registered Buyer List"+Colors.getReset());
					System.out.println(Colors.getBgWhite() +"Enter 2 to View ALL Registered Seller List"+Colors.getReset());
					System.out.println(Colors.getBgWhite() +"Enter 3 to Search A Registered Buyer List."+Colors.getReset());
					System.out.println(Colors.getBgWhite() +"Enter 4 to Search A Registered Seller List"+Colors.getReset());
					System.out.println(Colors.getBgWhite() +"Enter 5 to view Sales Report"+Colors.getReset());
					System.out.println(Colors.getBgWhite() +"Enter 6 to view Disputes."+Colors.getReset());
					System.out.println(Colors.getBgWhite() +"Enter 7 to Solve Disputes"+Colors.getReset());
					
					System.out.println(Colors.getBgWhite() +"Enter 8 to Logout"+Colors.getReset());
					System.out.println();
					System.out.println("+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+**+*+*");
					System.out.println();
					
					int num = sc.nextInt();
					
					
					
				
                   switch(num) {
					
					case 1 : ViewAllBuyers.main(args);
							  break;
					case 2 : ViewAllSellers.main(args);
					  		  break;
					case 3 : ViewABuyers.main(args);
							  break;
					case 4 : ViewASellers.main(args);
							  break;
					case 5 : SalesReport.main(args);
					  		  break;
					case 6 : ViewDisputes.main(args);
							  break;
					case 7 : SolveDisputes.main(args);
							  break;
					case 8 : {
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
