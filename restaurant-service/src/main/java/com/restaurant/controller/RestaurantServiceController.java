package com.restaurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.service.RestaurantService;

/**
 * @author Ravindranathnetha_Ra
 *
 */
@RestController
public class RestaurantServiceController {

	@Autowired
	RestaurantService restaurantService;
	
	@RequestMapping("/findMaxSatisfactionValue")
	public ResponseEntity<String> findMaxValue(){
		ResponseEntity<String> responseEntity=null;
		try {
			responseEntity=new ResponseEntity<String>("Maximum Satisfaction value is  ---  "+String.valueOf(restaurantService.findMaxSatisfactionValue("data.txt")), HttpStatus.OK);
		} catch (Exception e) {
			responseEntity=new ResponseEntity<String>("Exception occured ", HttpStatus.INTERNAL_SERVER_ERROR); 
		}
		return responseEntity;
	}
}
