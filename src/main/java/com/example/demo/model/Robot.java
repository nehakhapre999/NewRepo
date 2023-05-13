package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Robot {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int robot_id;
	
	private static final int maxweight= 15;
    private static final double dischargeinKG= 0.03;
    private static final double maxdistance = 7;
    private static final int lowbattery = 20;

    private double remainingBattery = 100;
    private double totalDistance = 0;
    private double currentWeight = 0;
    
    
    
	public int getRobot_id() {
		return robot_id;
	}
	public void setRobot_id(int robot_id) {
		this.robot_id = robot_id;
	}
	public double getRemainingBattery() {
		return remainingBattery;
	}
	public void setRemainingBattery(double remainingBattery) {
		this.remainingBattery = remainingBattery;
	}
	public double getTotalDistance() {
		return totalDistance;
	}
	public void setTotalDistance(double totalDistance) {
		this.totalDistance = totalDistance;
	}
	public double getCurrentWeight() {
		return currentWeight;
	}
	public void setCurrentWeight(double currentWeight) {
		this.currentWeight = currentWeight;
	}
	public static int getMaxweight() {
		return maxweight;
	}
	public static double getDischargeinkg() {
		return dischargeinKG;
	}
	public static double getMaxdistance() {
		return maxdistance;
	}
	public static int getLowbattery() {
		return lowbattery;
	}
	
    
    
	
	

}
