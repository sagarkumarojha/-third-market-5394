package com.auction.Usecases;

import java.util.List;

import com.auction.Dao.AdminDAO;
import com.auction.Dao.AdminDAOImpl;
import com.auction.bean.Colors;
import com.auction.bean.Sells;

public class SalesReport {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AdminDAO admin = new AdminDAOImpl();
        try {
			
			List<Sells> sales =  admin.ViewSellingReport();
			sales.forEach(b -> System.out.println(Colors.getBbgGreen()
                    +b+ Colors.getReset()));
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

		
	}


