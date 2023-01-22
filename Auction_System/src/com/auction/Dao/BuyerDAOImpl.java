package com.auction.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.auction.Exception.BidExcept;
import com.auction.Exception.BuyerExcept;
import com.auction.Exception.DisputeExcept;
import com.auction.Exception.ProductExcept;
import com.auction.Utility.DB;
import com.auction.bean.Items;
import com.auction.bean.Users;

public class BuyerDAOImpl implements BuyerDAO {
	public String registerBuyer(Users user) throws BuyerExcept {
		try (Connection connection = DB.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(
					"INSERT INTO users (username, password, email, first_name, last_name, role) VALUES (?, ?, ?, ?, ?, 'buyer')");
			statement.setString(1, user.getUsername());
			statement.setString(2, user.getPassword());
			statement.setString(3, user.getEmail());
			statement.setString(4, user.getFirstName());
			statement.setString(5, user.getLastName());
			int result = statement.executeUpdate();
			if (result == 1) {
				return "Registration Sucessfull";
			} else {
				throw new BuyerExcept("registration Failed");
			}
		} catch (SQLException e) {
			throw new BuyerExcept(e.getMessage());
		}
	}

	public Users LoginBuyer(String username, String password) throws BuyerExcept {
		try (Connection connection = DB.getConnection()) {
			PreparedStatement statement = connection
					.prepareStatement("SELECT * FROM users WHERE username = ? AND password = ? and role = 'buyer'");
			statement.setString(1, username);
			statement.setString(2, password);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				return new Users(resultSet.getInt("user_id"), resultSet.getString("first_name"),
						resultSet.getString("last_name"), resultSet.getString("username"), resultSet.getString("email"),
						resultSet.getString("password"), resultSet.getString("role"));
			} else {
				throw new BuyerExcept("Wrong Credentials");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public String placeBid(int itemId, int userId, float bidAmount) throws BidExcept {
		try (Connection connection = DB.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(
					"UPDATE items SET current_bid = ?, winner_id = ? WHERE item_id = ? AND current_bid < ?");
			statement.setFloat(1, bidAmount);
			statement.setInt(2, userId);
			statement.setInt(3, itemId);
			statement.setFloat(4, bidAmount);
			int result = statement.executeUpdate();
			if (result == 1) {
				statement = connection.prepareStatement(
						"INSERT INTO bid_history (item_id, user_id, bid_amount) VALUES (?, ?, ?)");
				statement.setInt(1, itemId);
				statement.setInt(2, userId);
				statement.setFloat(3, bidAmount);
				statement.executeUpdate();
				return "Bid Sucessfull";
			} else {
				throw new BidExcept("bidAmount is low ");
			}

		} catch (SQLException e) {
			throw new BidExcept(e.getMessage());
		}
	}

	public List<Items> getAllItems() throws ProductExcept {
		try (Connection connection = DB.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(
					"SELECT * FROM items WHERE auction_end_time > now() ORDER BY auction_end_time ASC");
			ResultSet resultSet = statement.executeQuery();
			List<Items> items = new ArrayList<>();
			while (resultSet.next()) {
				items.add(new Items(resultSet.getInt("item_id"), resultSet.getString("item_name"),
						resultSet.getFloat("starting_price"), resultSet.getFloat("current_bid"),
						resultSet.getTimestamp("auction_start_time").toLocalDateTime(),
						resultSet.getTimestamp("auction_end_time").toLocalDateTime(), resultSet.getString("category")));
			}
			if (items.size() < 1) {
				throw new ProductExcept("None Products are Listed Now");
			} else {
				return items;
			}

		} catch (SQLException e) {
			throw new ProductExcept(e.getMessage());
		}
	}

	public List<Items> getItemsbySeller(int userId) throws ProductExcept {
		try (Connection connection = DB.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(
					"SELECT * FROM items WHERE seller_id = ? AND auction_end_time > now() ORDER BY auction_end_time ASC");
			statement.setInt(1, userId);
			ResultSet resultSet = statement.executeQuery();
			List<Items> items = new ArrayList<>();
			while (resultSet.next()) {
				items.add(new Items(resultSet.getInt("item_id"), resultSet.getString("item_name"),
						resultSet.getFloat("starting_price"), resultSet.getFloat("current_bid"),
						resultSet.getTimestamp("auction_start_time").toLocalDateTime(),
						resultSet.getTimestamp("auction_end_time").toLocalDateTime(), resultSet.getString("category")));
			}
			if (items.size() < 1) {
				throw new ProductExcept("None Products are Listed Now");
			} else {
				return items;
			}
		} catch (SQLException e) {
			throw new ProductExcept(e.getMessage());
		}
	}

	public Items getItemDetails(int itemId) throws ProductExcept {
		try (Connection connection = DB.getConnection()) {
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM items WHERE item_id = ?");
			statement.setInt(1, itemId);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				return new Items(resultSet.getInt("item_id"), resultSet.getString("item_name"),
						resultSet.getFloat("starting_price"), resultSet.getFloat("current_bid"),
						resultSet.getTimestamp("auction_start_time").toLocalDateTime(),
						resultSet.getTimestamp("auction_end_time").toLocalDateTime(), resultSet.getString("category"));
			} else {
				throw new ProductExcept("Wrong itemId");
			}
		} catch (SQLException e) {
			throw new ProductExcept(e.getMessage());
		}
	}

	public List<Items> getWonItems(int userId) throws ProductExcept {
		try (Connection connection = DB.getConnection()) {
			PreparedStatement statement = connection
					.prepareStatement("SELECT * FROM items WHERE winner_id = ? AND auction_end_time < now()");
			statement.setInt(1, userId);
			ResultSet resultSet = statement.executeQuery();
			List<Items> items = new ArrayList<>();
			while (resultSet.next()) {
				items.add(new Items(resultSet.getInt("item_id"), resultSet.getString("item_name"),
						resultSet.getFloat("starting_price"), resultSet.getFloat("current_bid"),
						resultSet.getTimestamp("auction_start_time").toLocalDateTime(),
						resultSet.getTimestamp("auction_end_time").toLocalDateTime(), resultSet.getString("category")));
			}
			if (items.size() < 1) {
				throw new ProductExcept("No Products  Purchased by You");
			} else {
				return items;
			}

		} catch (SQLException e) {
			throw new ProductExcept(e.getMessage());

		}
	}

	@Override
	public String RegisterDisputes(int itemid,int user_id, String reason) throws DisputeExcept {
		try (Connection connection = DB.getConnection()) {
	        PreparedStatement statement = connection.prepareStatement("INSERT INTO disputes (item_id, user_id, dispute_reason) VALUES (?, ?, ?)");
	        statement.setInt(1, itemid);
	        statement.setInt(2, user_id);
	        statement.setString(3, reason);
	        int result = statement.executeUpdate();
			if (result == 1) {
				return " Dispute Registerd Sucessfully";
			} else {
				throw new DisputeExcept("Dispute Not Registerd");
			}
	    } catch (SQLException e) {
			throw new DisputeExcept(e.getMessage());
	    }
	}

}
