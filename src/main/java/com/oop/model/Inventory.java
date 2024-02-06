package com.oop.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * This is the Inventory model class
 * 
 * @author Romeshika
 * @version 1.0
 */
public class Inventory {

	private string partId;

	private String partName;

	private Double price;

	private Integer quantity;

	private String category;

	private String location;

	private LocalDate dateAdded;

	private LocalDate dateModified;

	/**
	 * @return partId
	 */
	public String getPartId() {
		return partId;
	}

	/**
	 * @param partId
	 */
	public void setPartId(String partId) {
		this.partId = partId;
	}

	/**
	 * @return partName
	 */
	public String getPartName() {
		return partName;
	}

	/**
	 * @param partName
	 */
	public void setPartName(String partName) {
		this.partName = partName;
	}

	/**
	 * @return price
	 */
	public Double getPrice() {
		return price;
	}

	/**
	 * @param price
	 */
	public void setPrice(Double price) {
		this.price = price;
	}

	/**
	 * @return quantity
	 */
	public Integer getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity
	 */
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * @return location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @param location
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * @return dateAdded
	 */
	public LocalDate getDateAdded() {
		return dateAdded;
	}

	/**
	 * @param dateAdded
	 */
	public void setDateAdded(LocalDate dateAdded) {
		this.dateAdded = dateAdded;
	}

	/**
	 * @return dateModified
	 */
	public LocalDate getDateModified() {
		return dateModified;
	}

	/**
	 * @param dateModified
	 */
	public void setDateModified(LocalDate dateModified) {
		this.dateModified = dateModified;
	}

	
}
