package com.auction.Usecases;


import java.util.Scanner;

import com.auction.Dao.AdminDAO;
import com.auction.Dao.AdminDAOImpl;
import com.auction.bean.Colors;
import com.auction.bean.Users;

public class ViewASellers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		System.out.println(Colors.getBbgYellow() + "Enter Seller Id  : " + Colors.getReset());
		int Id = sc.nextInt();
		AdminDAO admin = new AdminDAOImpl();
		try {

			Users seller = admin.SearchABuyerDetail(Id);
			System.out.println(Colors.getBbgGreen() + seller + Colors.getReset());

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
