package com.auction.Usecases;

import java.util.Scanner;

import com.auction.Dao.BuyerDAO;
import com.auction.Dao.BuyerDAOImpl;
import com.auction.Exception.DisputeExcept;

public class RegisterDispute {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter item ID: ");
		int saleId = scanner.nextInt();
		System.out.println("Enter User Id: ");
		int userid = scanner.nextInt();
		System.out.println("Enter Reson (if any): ");
		String reason = scanner.next();
		BuyerDAO buyer= new BuyerDAOImpl();
		
		try {
			String res=buyer.RegisterDisputes(saleId,userid, reason);
			System.out.println(res);
		} catch (DisputeExcept e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
