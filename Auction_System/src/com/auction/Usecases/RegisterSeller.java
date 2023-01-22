package com.auction.Usecases;

import java.util.Scanner;

import com.auction.Dao.SellerDAO;
import com.auction.Dao.SellerDAOImpl;
import com.auction.Exception.SellerExcept;
import com.auction.bean.Users;

public class RegisterSeller {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		scanner.useDelimiter("\n");
		Users user=new Users();
		System.out.println("Enter First name:");
		user.setFirstName( scanner.next());
		System.out.println("Enter Last name:");
		user.setLastName( scanner.next());
		System.out.println("Enter username:");
		user.setUsername( scanner.next());
		System.out.println("Enter password:");
		user.setPassword( scanner.next());
		System.out.println("Enter email:");
		user.setEmail( scanner.next());
		SellerDAO seller =new SellerDAOImpl();
		try {
			String res=seller.RegisterSeller(user);
			System.out.println(res);

		} catch (SellerExcept e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}
