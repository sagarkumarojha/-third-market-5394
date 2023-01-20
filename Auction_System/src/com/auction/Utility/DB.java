package com.auction.Utility;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {

	public static Connection getConnection() {
		Connection connect = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String url = "jdbc:mysql://localhost:3306/Auction_System";
		try {
			connect = DriverManager.getConnection(url, "root", "Sagar@109");
		} catch (SQLException e) {

			e.getMessage();
		}

		return connect;

	}
}


