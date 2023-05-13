package com.example.demo.service;

import com.example.demo.model.Robot;

public interface RobotServiceInf {

	public Robot savedata(Robot r);

	public Iterable<Robot> getRobot();

}
