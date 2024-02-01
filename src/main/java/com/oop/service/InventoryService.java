/**
 * Contract for the implementation of Inventory Service .
 * 
 * @author Romeshika
 * @version 1.0
 */
package com.oop.service;

import com.oop.model.Inventory;

import java.util.ArrayList;
import java.util.logging.Logger;

public interface InventoryService {

	/** Initialize logger */
	public static final Logger log = Logger.getLogger(InventoryService.class.getName());

	/**
	 * Add inventory for inventory table
	 * 
	 * @param inventory
	 */
	public void addInventory(Inventory inventory);

	/**
	 * Get a particular Inventory
	 * 
	 * @param inventoryID
	 * @return Inventory
	 */
	public Inventory getInventoryByID(String inventoryID);

	/**
	 * Get all list of inventory
	 * 
	 * @return ArrayList<Inventory>
	 */
	public ArrayList<Inventory> getInventories();

	/**
	 * Update existing inventory
	 * 
	 * @param inventoryID
	 * @param inventory
	 * 
	 * @return
	 */
	public Inventory updateInventory(String inventoryID, Inventory inventory);

	/**
	 * Remove existing inventory
	 * 
	 * @param inventoryID
	 */
	public void removeInventory(String inventoryID);

}
