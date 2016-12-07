package com.epam.restaurant.service;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.restaurant.exception.RestaurantServiceException;
import com.restaurant.service.RestaurantServiceImpl;

/**
 * Created by Ravindranathnetha_rapolu.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RestaurantServiceImplTest {

    @Autowired
    RestaurantServiceImpl restaurantService;
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
	public void testWithInvalidFileLocation() throws Exception {

		thrown.expect(RestaurantServiceException.class);
		thrown.expectMessage("File not found in the specified location");

		restaurantService.findMaxSatisfactionValue("nofile.txt");
	}
    @Test
    public void testWithEmptyfile() throws Exception {
    	
    	thrown.expect(RestaurantServiceException.class);
		thrown.expectMessage("Input file is empty");
		restaurantService.findMaxSatisfactionValue("testwithemptyfile.txt");

    }
    
    @Test
    public void testWithInvalidContent() throws Exception {
    	
    	thrown.expect(RestaurantServiceException.class);
		thrown.expectMessage("Invalid time/satisfactionValue");
        double satisfaction = restaurantService.findMaxSatisfactionValue("test3.txt");
        assertEquals(397,satisfaction,0);

    }
    
    @Test
    public void testWithInvalidMaxTime() throws Exception {
    	
    	thrown.expect(RestaurantServiceException.class);
		thrown.expectMessage("Invalid maximum time");
         restaurantService.findMaxSatisfactionValue("test4.txt");

    }
    @Test
    public void testMaximumSatisfaction_with_6Dishes() throws Exception {

        double satisfaction = restaurantService.findMaxSatisfactionValue("test1.txt");
        assertEquals(155,satisfaction,0);

    }
    @Test
    public void testLeaseMaximumTime() throws Exception {
    	thrown.expect(RestaurantServiceException.class);
		thrown.expectMessage("Invalid maximum time ");
        restaurantService.findMaxSatisfactionValue("test6.txt");

    }
    @Test
    public void testMaximumSatisfaction_with_3Dishes() throws Exception {

        double satisfaction = restaurantService.findMaxSatisfactionValue("test2.txt");
        assertEquals(63,satisfaction,0);

    }


}