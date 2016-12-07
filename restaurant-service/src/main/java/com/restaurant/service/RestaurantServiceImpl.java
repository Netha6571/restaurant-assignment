package com.restaurant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurant.util.RestaurantServiceUtil;

/**
 * Created by Ravindranathnetha_Rapolu.
 */
@Service
public class RestaurantServiceImpl  implements RestaurantService{

	@Autowired
	SatisfactionSolver satisfactionSolver;
	
	/* (non-Javadoc)
	 * @see com.epam.restaurant.service.RestaurantService#findMaxSatisfactionValue(java.lang.String)
	 */
	public double findMaxSatisfactionValue(String filePath) {
		satisfactionSolver.setRestaurantMenu(RestaurantServiceUtil.prepareRestaurantMenu(filePath));
		return satisfactionSolver.solve();
	}
}
