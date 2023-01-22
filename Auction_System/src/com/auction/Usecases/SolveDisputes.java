package com.auction.Usecases;

import java.util.Scanner;

import com.auction.Dao.AdminDAO;
import com.auction.Dao.AdminDAOImpl;
import com.auction.bean.Colors;

public class SolveDisputes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		System.out.println(Colors.getBbgYellow() + "Enter Dispute Id : " + Colors.getReset());
		int disId = sc.nextInt();
		System.out.println(Colors.getBbgYellow() + "Enter resolution details : " + Colors.getReset());
		String res = sc.nextLine();
		AdminDAO admin = new AdminDAOImpl();
		try {

			String result = admin.SolveDailyDispute(disId,res);
			System.out.println(Colors.getBbgGreen() + result + Colors.getReset());

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
		
	}

