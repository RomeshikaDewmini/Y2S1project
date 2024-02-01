/**
 * OOP 2018
 * 
 * @author Udara Samaratunge  Department of Software Engineering, SLIIT 
 * 
 * @version 1.0
 * Copyright: SLIIT, All rights reserved
 * 
 */
package com.oop.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.oop.util.*;
import com.oop.model.Inventory;

/**
 * Contract for the implementation of Inventory Service .
 * 
 * @author Romeshika
 * @version 1.0
 */
public class InventoryServiceImpl implements InventoryService {

	/** Initialize logger */
	public static final Logger log = Logger.getLogger(InventoryServiceImpl.class.getName());

	private static Connection connection;

	private static Statement statement;

	private PreparedStatement preparedStatement;

	@Override
	public void addInventory(Inventory inventory) {
		try {
			connection = DBConnect.getConnection();

			// the my-sql insert statement
			String query = "INSERT INTO automate.inventory (part_id, part_name, price, quantity, category, location, date_added, date_modified)\r\n"
					+ "VALUES( ?, ?, ?, ?, ?, ?, ?, ?)";
			preparedStatement = connection.prepareStatement(query);
			connection.setAutoCommit(false);

			// Generate  Inventory IDs
			inventory.setPartId(UUID.randomUUID().toString());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, inventory.getPartId());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, inventory.getPartName());
			preparedStatement.setDouble(CommonConstants.COLUMN_INDEX_THREE, inventory.getPrice());
			preparedStatement.setInt(CommonConstants.COLUMN_INDEX_FOUR, inventory.getQuantity());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, inventory.getCategory());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_SIX, inventory.getLocation());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_SEVEN, LocalDate.now().toString());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_EIGHT, LocalDate.now().toString());
			// Add Inventory
			preparedStatement.execute();
			connection.commit();

		} catch (SQLException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of
			 * transaction
			 */
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
	}

	@Override
	public Inventory getInventoryByID(String inventoryID) {
		return actionOnInventory(inventoryID).get(0);
	}

	@Override
	public ArrayList<Inventory> getInventories() {
		return actionOnInventory(null);
	}

	@Override
	public Inventory updateInventory(String inventoryID, Inventory inventory) {
		try {
			connection = DBConnect.getConnection();

			// the mysql update statement
			String query = "UPDATE automate.inventory\r\n"
					+ "SET part_name=?, price=?, quantity=?, category=?, location=?, date_added=?, date_modified=?\r\n"
					+ "WHERE part_id=?;";
			System.out.println("SQL Query: " + query);
			preparedStatement = connection.prepareStatement(query);
			connection.setAutoCommit(false);

			// Generate Inventory IDs
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, inventory.getPartName());
			preparedStatement.setDouble(CommonConstants.COLUMN_INDEX_TWO, inventory.getPrice());
			preparedStatement.setInt(CommonConstants.COLUMN_INDEX_THREE, inventory.getQuantity());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, inventory.getCategory());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, inventory.getLocation());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_SIX, inventory.getDateAdded().toString());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_SEVEN, LocalDate.now().toString());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_EIGHT, inventory.getPartId());
			// Add inventory
			int rowsAffected = preparedStatement.executeUpdate();
			System.out.println("Rows affected: " + rowsAffected);
			connection.commit();

		} catch (SQLException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of
			 * transaction
			 */
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
		
		// Get the updated inventory
		return getInventoryByID(inventoryID);
	}

	@Override
	public void removeInventory(String partId) {
		try {
			connection = DBConnect.getConnection();

			// the mysql update statement
			String query = "DELETE FROM automate.inventory\r\n"
					+ "WHERE part_id=?;";
			System.out.println("SQL Query: " + query);
			preparedStatement = connection.prepareStatement(query);
			connection.setAutoCommit(false);

			// Generate inventory IDs
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, partId);
			
			// Add inventory
			int rowsAffected = preparedStatement.executeUpdate();
			System.out.println("Rows affected: " + rowsAffected);
			connection.commit();

		} catch (SQLException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of
			 * transaction
			 */
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}

	}
	
	private ArrayList<Inventory> actionOnInventory(String inventoryId) {

		ArrayList<Inventory> inventoryList = new ArrayList<Inventory>();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		try {
			connection = DBConnect.getConnection();
			/*
			 * Before fetching inventory it checks whether inventory id  is
			 * available
			 */
			if (inventoryId != null && !inventoryId.isEmpty()) {
				/*
				 * Get Inventory by ID query will be retrieved from
				 *InventoryQuery.xml
				 */
				preparedStatement = connection
						.prepareStatement("SELECT * FROM automate.inventory WHERE part_id= ?");
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, inventoryId);
			}
			/*
			 * If inventory ID is not provided for get inventory option it display
			 * all inventory
			 */
			else {
				preparedStatement = connection
						.prepareStatement("SELECT * FROM automate.inventory");
			}
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Inventory inventory = new Inventory();
				inventory.setPartId(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
				inventory.setPartName(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));
				inventory.setPrice(Double.valueOf(resultSet.getString(CommonConstants.COLUMN_INDEX_FOUR)));
				inventory.setQuantity(Integer.valueOf(resultSet.getString(CommonConstants.COLUMN_INDEX_FIVE)));
				inventory.setCategory(resultSet.getString(CommonConstants.COLUMN_INDEX_SIX));
				inventory.setLocation(resultSet.getString(CommonConstants.COLUMN_INDEX_SEVEN));
				inventory.setDateAdded(LocalDate.parse(resultSet.getString(CommonConstants.COLUMN_INDEX_EIGHT),formatter));
				inventory.setDateModified(LocalDate.parse(resultSet.getString(CommonConstants.COLUMN_INDEX_NINE),formatter));
				inventoryList.add(inventory);
			}

		} catch (SQLException  e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of
			 * transaction
			 */
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
		return inventoryList;
	}

}
