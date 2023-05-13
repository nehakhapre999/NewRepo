package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Robot;
import com.example.demo.repository.RobotRepository;

@Service
public class RobotService implements RobotServiceInf {
	
	@Autowired
	RobotRepository repo;

	@Override
	public Robot savedata(Robot r) {
		
		Robot s = repo.save(r);
		
		return s;
	}

	@Override
	public Iterable<Robot> getRobot() {
		Iterable<Robot> getall = repo.findAll();
		return getall;
	}

	

}
