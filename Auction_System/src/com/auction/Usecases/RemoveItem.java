package com.auction.Usecases;

import java.time.LocalDateTime;
import java.util.Scanner;

import com.auction.Dao.SellerDAO;
import com.auction.Dao.SellerDAOImpl;
import com.auction.Exception.ProductExcept;

public class RemoveItem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Item ID: ");
		int Id = scanner.nextInt();
				SellerDAO seller =new SellerDAOImpl();
		try {
		String res=	seller.RemoveProductfromList(Id);
		System.out.println(res);
		} catch (ProductExcept e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}
