package com.auction.Usecases;

import java.util.Scanner;

import com.auction.Dao.AdminDAO;
import com.auction.Dao.AdminDAOImpl;
import com.auction.bean.Colors;
import com.auction.bean.Users;

public class ViewABuyers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		System.out.println(Colors.getBbgYellow() + "Enter Customer BuyerId : " + Colors.getReset());
		int buyerId = sc.nextInt();
		AdminDAO admin = new AdminDAOImpl();
		try {

			Users seller = admin.SearchABuyerDetail(buyerId);
			System.out.println(Colors.getBbgGreen() + seller + Colors.getReset());

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
