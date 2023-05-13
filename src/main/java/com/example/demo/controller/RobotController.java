package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Robot;
import com.example.demo.service.RobotService;
import com.example.demo.service.RobotServiceInf;

@RestController
public class RobotController {
	
	
   
    
    private double remainingBattery = 100;
    private double totalDistance = 0;
    private double currentWeight = 0;
	

	
	@Autowired
	
	RobotServiceInf rsi;
	
	
	@PostMapping("/walk/{distance}")
    public String walk(@PathVariable("distance")int distance ) {
        double requiredBattery = ( distance/Robot.getMaxdistance()) * 100;
        
        if (requiredBattery > remainingBattery) {
        	
        	System.out.println("sufficient to walk");
        	
        	

            return "Sufficient Battery to walk";
        }
        remainingBattery -= requiredBattery;
        totalDistance += distance;
        
        if (remainingBattery <= Robot.getLowbattery()) {
        	
        	System.out.println("LOW BATTERY");
        	
        	
        }

        return "Battery usage";
    }	
	
	

	@GetMapping("/getrobotdata")
    public Iterable<Robot> Home() {
		
		Iterable<Robot> robot=rsi.getRobot();
               
		return robot;
    }
	

    @PostMapping("/carry/{weight}")
    public String carry(@PathVariable("weight")int weight,@RequestBody Robot robot) {
       
    	if (weight > Robot.getMaxweight()) {
            
            System.out.println("Overweight");
            
            return "Overweight";
        }
        
    	double requiredBattery = weight * Robot.getDischargeinkg();
        if (requiredBattery > remainingBattery) {
        	
        	System.out.println("Under weight");
                      
        	return "Under weight";
        }
        remainingBattery -= requiredBattery;
        currentWeight += weight;
        if (remainingBattery <=Robot.getLowbattery()) {
            System.out.println("Low battery");
            }
        
        return "Weight";
    }

	
	
	
}
