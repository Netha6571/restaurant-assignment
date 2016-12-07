package com.restaurant.exception;

/**
 * @author Ravindranathnetha_Rapolu
 *
 */
public class RestaurantServiceException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6372940199645935566L;

	public RestaurantServiceException(String msg) {
		super(msg);
	}
	public RestaurantServiceException(Throwable th) {
		super(th);
	}
}
