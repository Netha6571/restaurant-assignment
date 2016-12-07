package com.restaurant.entity;

import java.util.List;

/**
 * @author Ravindranathnetha_Rapolu
 *
 */
public class RestaurantMenu {

	private int capacity;
	
	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	private List<Item> items;
	
}
