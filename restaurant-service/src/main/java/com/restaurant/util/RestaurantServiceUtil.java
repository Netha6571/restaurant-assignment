package com.restaurant.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

import com.restaurant.entity.Item;
import com.restaurant.entity.RestaurantMenu;
import com.restaurant.exception.RestaurantServiceException;

/**
 * 
 * Utility class
 * 
 * @author Ravindranathnetha_Rapolu
 *
 */
public final class RestaurantServiceUtil {

	private RestaurantServiceUtil() {

	}

	/**
	 * Method used to read input file and returns a list object
	 * 
	 * @param filePath
	 * @return
	 * @throws RestaurantServiceException 
	 * @throws Exception
	 */
	public static RestaurantMenu prepareRestaurantMenu(String filePath) throws RestaurantServiceException {

		RestaurantMenu restaurantMenu = new RestaurantMenu();

		URL url=RestaurantServiceUtil.class.getClassLoader().getResource(filePath);
		if(url==null){
			throwCustomException("File not found in the specified location");
		}
		File configFile = new File(RestaurantServiceUtil.class.getClassLoader().getResource(filePath).getFile());

		FileInputStream inputStream = null;
		BufferedReader br =null; 

		List<Item> items = new LinkedList<Item>();
		try {
			inputStream = new FileInputStream(configFile);
			br=	new BufferedReader(new InputStreamReader(inputStream));
			String line = br.readLine();
			if(line==null){
				throwCustomException("Input file is empty");
			}
			restaurantMenu.setCapacity(Integer.valueOf(line.split(" ")[0].trim()));
			
			// maximum time capacity should be greater than 0.
			if(restaurantMenu.getCapacity()<=0){
				inputStream.close();
				throwCustomException("Invalid maximum time");
			}
			while (line != null) {
				line = br.readLine();
				int i = 1;
				if (line != null) {
					Item item = new Item();
					item.setLabel(i);
					double satisfactionValue=0;
					double time=0;
					try {
						satisfactionValue = Double.valueOf(line.split(" ")[0].trim());
						time = Double.valueOf(Double.valueOf(line.split(" ")[1].trim()));
						
						if(satisfactionValue<0||time<0){
							inputStream.close();
							throwCustomException("Invalid time/satisfactionValue");
						}
					} catch (NumberFormatException e) {
						inputStream.close();
						throwCustomException("Invalid time/satisfactionValue");
					}
				
					item.setSatisfactionValue(satisfactionValue);
					item.setTime(time);
					items.add(item);
				}
			}
			restaurantMenu.setItems(items);
		} catch (IOException ex) {
			throwCustomException("File not found in the specified location");
		}
		finally {
			try {
				br.close();
			} catch (IOException e) {
			}
		}
		validateCapacity(restaurantMenu);
		return restaurantMenu;
	}
	private static void throwCustomException(String msg) throws RestaurantServiceException{
		throw new RestaurantServiceException(msg);
	}
	
	private static void validateCapacity(RestaurantMenu menu){
		int capacity=menu.getCapacity();
		List<Item> itemList=menu.getItems();
		boolean flag=false;
		for (Item item : itemList) {
			if(item.getTime()<capacity){
				flag=true;
			}
		}
		if(!flag){
			throwCustomException("Invalid maximum time ");
		}
	}
}
