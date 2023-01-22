package com.auction.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.auction.Exception.AdminExcept;
import com.auction.Exception.BuyerExcept;
import com.auction.Exception.DisputeExcept;
import com.auction.Exception.ProductExcept;
import com.auction.Exception.SellerExcept;
import com.auction.Utility.DB;
import com.auction.bean.Disputes;
import com.auction.bean.Sells;
import com.auction.bean.Users;

public class AdminDAOImpl implements AdminDAO {

	public Users AdminLogin(String username, String password) throws AdminExcept {
		try (Connection connection = DB.getConnection()) {
			PreparedStatement statement = connection
					.prepareStatement("SELECT * FROM users WHERE username = ? AND password = ? and role = 'admin'");
			statement.setString(1, username);
			statement.setString(2, password);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				return new Users(resultSet.getInt("user_id"), resultSet.getString("first_name"),
						resultSet.getString("last_name"), resultSet.getString("username"), resultSet.getString("email"),
						resultSet.getString("password"), resultSet.getString("role"));
			} else {
				throw new AdminExcept("Wrong Credentials");
			}
		} catch (SQLException e) {
			throw new AdminExcept(e.getMessage());
		}
	}

	public Users SearchABuyerDetail(int userId) throws BuyerExcept {
		try (Connection connection = DB.getConnection()) {
			PreparedStatement statement = connection
					.prepareStatement("SELECT * FROM users WHERE user_id = ? and role= 'buyer'");
			statement.setInt(1, userId);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				return new Users(resultSet.getInt("user_id"), resultSet.getString("first_name"),
						resultSet.getString("last_name"), resultSet.getString("username"), resultSet.getString("email"),
						resultSet.getString("password"), resultSet.getString("role"));
			} else {
				throw new BuyerExcept("No buyers are with this Id");
			}
		} catch (SQLException e) {
			throw new BuyerExcept(e.getMessage());
		}
	}

	public Users SearchASellerDetail(int userId) throws SellerExcept {
		try (Connection connection = DB.getConnection()) {
			PreparedStatement statement = connection
					.prepareStatement("SELECT * FROM users WHERE user_id = ? and role= 'seller'");
			statement.setInt(1, userId);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				return new Users(resultSet.getInt("user_id"), resultSet.getString("first_name"),
						resultSet.getString("last_name"), resultSet.getString("username"), resultSet.getString("email"),
						resultSet.getString("password"), resultSet.getString("role"));
			} else {
				throw new SellerExcept("No seller are with this Id");
			}
		} catch (SQLException e) {
			throw new SellerExcept(e.getMessage());
		}
	}

	@Override
	public List<Users> ViewRegisteredBuyerList() throws BuyerExcept {
		// TODO Auto-generated method stub
		try (Connection connection = DB.getConnection()) {
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE role= 'buyer'");
			ResultSet resultSet = statement.executeQuery();
			List<Users> users = new ArrayList<>();
			while (resultSet.next()) {
				users.add(new Users(resultSet.getInt("user_id"), resultSet.getString("first_name"),
						resultSet.getString("last_name"), resultSet.getString("username"), resultSet.getString("email"),
						resultSet.getString("password"), resultSet.getString("role")));
			}
			if (users.size() < 1) {
				throw new BuyerExcept("No buyers are Registered Till Now");
			} else {
				return users;
			}
		} catch (SQLException e) {
			throw new BuyerExcept(e.getMessage());
		}
	}

	@Override
	public List<Users> ViewRegisteredSellerList() throws SellerExcept {
		// TODO Auto-generated method stub
		try (Connection connection = DB.getConnection()) {
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE role= 'seller'");
			ResultSet resultSet = statement.executeQuery();
			List<Users> users = new ArrayList<>();
			while (resultSet.next()) {
				users.add(new Users(resultSet.getInt("user_id"), resultSet.getString("first_name"),
						resultSet.getString("last_name"), resultSet.getString("username"), resultSet.getString("email"),
						resultSet.getString("password"), resultSet.getString("role")));
			}
			if (users.size() < 1) {
				throw new SellerExcept("No sellers are Registered Till Now");
			} else {
				return users;
			}
		} catch (SQLException e) {
			throw new SellerExcept(e.getMessage());
		}
	}

	@Override
	public List<Sells> ViewSellingReport() throws ProductExcept {
		try (Connection connection = DB.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(
					"SELECT s.username, i.item_name, u.username FROM items i INNER JOIN users s ON s.user_id = i.seller_id INNER JOIN users u ON u.user_id = i.winner_id WHERE auction_end_time < now() ORDER BY i.auction_end_time DESC");
			ResultSet resultSet = statement.executeQuery();
			List<Sells> sales = new ArrayList<>();
			while (resultSet.next()) {
				Sells sale = new Sells();
				sale.setSellerName( resultSet.getString("username"));
				sale.setItemName( resultSet.getString("item_name"));
				sale.setBuyername( resultSet.getString("username"));
				sales.add(sale);
			}
			if (sales.size() < 1) {
				throw new ProductExcept("No items");
			} else {
				return sales;
			}
		} catch (SQLException e) {
			throw new ProductExcept(e.getMessage());
		}
		}

	public List<Disputes> ViewDailyDispute() throws ProductExcept {
		try (Connection connection = DB.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(
					"SELECT * FROM disputes WHERE dispute_time >= CURDATE() ORDER BY dispute_time DESC");
			ResultSet resultSet = statement.executeQuery();
			List<Disputes> disputes = new ArrayList<>();
			while (resultSet.next()) {
				disputes.add(new Disputes(resultSet.getInt("dispute_id"), resultSet.getInt("item_id"),
						resultSet.getInt("user_id"), resultSet.getString("dispute_reason"),
						resultSet.getString("dispute_resolution"), resultSet.getBoolean("resolved"),
						resultSet.getTimestamp("created_at").toLocalDateTime()));
			}
			if (disputes.size() < 1) {
				throw new ProductExcept("No sellers are Registered Till Now");
			} else {
				return disputes;
			}
		} catch (SQLException e) {
			throw new ProductExcept(e.getMessage());
		}
	}

	public String SolveDailyDispute(int disputeId, String resolution) throws DisputeExcept {
		try (Connection connection = DB.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(
					"UPDATE disputes SET resolved = TRUE, dispute_resolution = ? WHERE dispute_id = ?");
			statement.setString(2, resolution);
			statement.setInt(3, disputeId);
			int result = statement.executeUpdate();

			if (result < 1) {
				throw new DisputeExcept("Something Went Wrong");
			} else {
				return "Dispute Solved";
			}
		} catch (SQLException e) {
			throw new DisputeExcept(e.getMessage());
		}

	}
}
