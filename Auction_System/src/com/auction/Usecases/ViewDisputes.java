package com.auction.Usecases;

import java.util.List;

import com.auction.Dao.AdminDAO;
import com.auction.Dao.AdminDAOImpl;
import com.auction.bean.Colors;
import com.auction.bean.Disputes;

public class ViewDisputes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AdminDAO admin = new AdminDAOImpl();
        try {
			
			List<Disputes> disputes =  admin.ViewDailyDispute();
			disputes.forEach(b -> System.out.println(Colors.getBbgGreen()
                    +b+ Colors.getReset()));
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
