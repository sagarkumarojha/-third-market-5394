package com.auction.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.auction.Exception.ProductExcept;
import com.auction.Exception.SellerExcept;
import com.auction.Utility.DB;
import com.auction.bean.Users;
import com.auction.bean.Bid;
import com.auction.bean.Items;


public class SellerDAOImpl implements SellerDAO{
	
	public String RegisterSeller(Users user) throws SellerExcept {
	    try (Connection connection = DB.getConnection()) {
	        PreparedStatement statement = connection.prepareStatement("INSERT INTO users (username, password, email, first_name, last_name, role) VALUES (?, ?, ?, ?, ?, 'seller')");
	        statement.setString(1, user.getUsername());
	        statement.setString(2, user.getPassword());
	        statement.setString(3, user.getEmail());
	        statement.setString(4, user.getFirstName());
	        statement.setString(5, user.getLastName());
	        int result = statement.executeUpdate();
	        if(result==1) {
	        	return "Registration Sucessfull";
	        }else {
	        	throw new SellerExcept("registration Failed");
	        }
	    } catch (SQLException e) {
	    	throw new SellerExcept(e.getMessage());
	    }
	}
	
	public Users SellerLogin(String username, String password) throws SellerExcept {
	    try (Connection connection = DB.getConnection()) {
	        PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE username = ? AND password = ? and role = 'seller'");
	        statement.setString(1, username);
	        statement.setString(2, password);
	        ResultSet resultSet = statement.executeQuery();
	        if (resultSet.next()) {
	            return new Users(resultSet.getInt("user_id"), resultSet.getString("first_name"),resultSet.getString("last_name"),resultSet.getString("username"), resultSet.getString("email"), resultSet.getString("password"), resultSet.getString("role"));
	        }else {
	        	throw new SellerExcept("Wrong Credentials");
	        }
	    } catch (SQLException e) {
	    	throw new SellerExcept(e.getMessage());
	    }
	}

	
	public String createNewItem(Items item) throws ProductExcept {
	    try (Connection connection = DB.getConnection()) {
	        PreparedStatement statement = connection.prepareStatement("INSERT INTO items (item_name, starting_price, seller_id, current_bid, auction_start_time, auction_end_time, category) VALUES (?, ?, ?, ?, ?, ?, ?)");
	        statement.setString(1, item.getItemName());
	        statement.setFloat(2, item.getStartingPrice());
	        statement.setInt(3, item.getSellerId());
	        statement.setFloat(4, item.getCurrentBid());
	        statement.setObject(5, item.getAuctionStartTime());
	        statement.setObject(6,item.getAuctionEndTime());
	        statement.setString(7, item.getCategory());
	        int result = statement.executeUpdate();
	        if(result==1) {
	        	return "Item Added Sucessfully";
	        }else {
	        	throw new ProductExcept("Item not Failed");
	        }
	    } catch (SQLException e) {
	    	throw new ProductExcept(e.getMessage());
	    }
	}
	public String updateItemauctionTime(int itemId,LocalDateTime auctionStartTime, LocalDateTime auctionEndTime) throws ProductExcept {
	    try (Connection connection = DB.getConnection()) {
	        PreparedStatement statement = connection.prepareStatement("UPDATE items SET auction_start_time = ?, auction_end_time = ? WHERE item_id = ?");
	        statement.setFloat(3, itemId);
	        statement.setObject(1, auctionStartTime);
	        statement.setObject(2, auctionStartTime);
	        int result = statement.executeUpdate();
	        if(result==1) {
	        	return "Item Added Sucessfully";
	        }else {
	        	throw new ProductExcept("Item not Failed");
	        }
	    } catch (SQLException e) {
	    	throw new ProductExcept(e.getMessage());
	    }
	}

	
	public String RemoveProductfromList(int itemId) throws ProductExcept {
	    try (Connection connection = DB.getConnection()) {
	        PreparedStatement statement = connection.prepareStatement("DELETE FROM items WHERE item_id = ?");
	        statement.setInt(1, itemId);
	        int result = statement.executeUpdate();
	        if(result==1) {
	        	return "Item Added Sucessfully";
	        }else {
	        	throw new ProductExcept("Item not Failed");
	        }
	    } catch (SQLException e) {
	    	throw new ProductExcept(e.getMessage());
	    }
	}

	public List<Bid> getBidHistory(int itemId) {
	    try (Connection connection = DB.getConnection()) {
	        PreparedStatement statement = connection.prepareStatement("SELECT * FROM bids WHERE item_id = ? ORDER BY bid_time DESC");
	        statement.setInt(1, itemId);
	        ResultSet resultSet = statement.executeQuery();
	        List<Bid> bidHistory = new ArrayList<>();
	        while (resultSet.next()) {
	            bidHistory.add(new Bid(resultSet.getInt("bid_id"), resultSet.getInt("item_id"), resultSet.getInt("user_id"), resultSet.getFloat("bid_amount"), resultSet.getTimestamp("bid_time").toLocalDateTime()));
	        }
	        return bidHistory;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return null;
	    }
	}


	@Override
	public List<Bid> ViewSoldProductHistory() throws ProductExcept {
		// TODO Auto-generated method stub
		return null;
	}


}
