package com.auction.Usecases;
import java.util.Scanner;



class AAS {

	public static void main(String[] args) {

		System.out.println("Welcome to Automated Auction System...");
		while (true) {

			System.out.println("\nPlease select an option to continue.");
			System.out.println(
					"\n1. Login as Admin \n2. Login as Seller \n3. Login as Buyer \n4. Register as Seller \n5. Register as Buyer.");

			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				try {
					AdminUseCases.main(null);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
					break;
				}
			case 2:
				try {
					SellerUseCases.main(null);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
					break;
				}
			case 3:
				try {
					BuyerUseCases.main(null);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
					break;
				}
			case 4:
				try {
					RegisterSeller.main(null);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
					break;
				}
			case 5:
				try {
					RegisterBuyer.main(null);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
					break;
				}

			}

		}
	}
}