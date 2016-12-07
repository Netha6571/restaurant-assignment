package com.restaurant.service;

public interface RestaurantService {

	/**
	 * This method will return the maximum satisfaction value in the given Menu within the capacity
	 * @param filePath
	 * @return
	 */
	public double	findMaxSatisfactionValue(String filePath) throws Exception;
	
}

