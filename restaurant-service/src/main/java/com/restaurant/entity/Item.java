package com.restaurant.entity;

/**
 * @author Ravindranathnetha_Rapolu
 */
public class Item {

	private int label;

	public int getLabel() {
		return label;
	}

	public void setLabel(int label) {
		this.label = label;
	}

	public double getSatisfactionValue() {
		return satisfactionValue;
	}

	public void setSatisfactionValue(double satisfactionValue) {
		this.satisfactionValue = satisfactionValue;
	}

	public double getTime() {
		return time;
	}

	public void setTime(double time) {
		this.time = time;
	}

	private double satisfactionValue;

	private double time;
	
	public double getRatio() {
		return satisfactionValue / time;
	}
}
