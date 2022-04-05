package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entities.Trainee;
import com.cg.service.TraineeService;

@RestController
@RequestMapping("/trncntrlr")
public class TraineeController {
	@Autowired
	private TraineeService traineeService;
	
	@PutMapping("/trainee")
	public ResponseEntity<Trainee> updateTrainee(
			@RequestBody Trainee trainee1){
		Trainee trainee= traineeService.updateTrainee(trainee1);
		if(trainee==null)
		{
			return new ResponseEntity("Sorry! Trainee not available!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Trainee>(trainee, HttpStatus.OK);
	}
	
	
	
	@PostMapping("/trainee")
	public ResponseEntity<List<Trainee>> insertTrainee(
			@RequestBody List<Trainee> trainee1){
		List<Trainee> trainee= traineeService.saveTrainee(trainee1);
		if(trainee==null)
		{
			return new ResponseEntity("Sorry! Trainee not available!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<Trainee>>(trainee, HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	@DeleteMapping("/trainee/{traineeId}")
	public ResponseEntity<String> deleteTrainee(
			@PathVariable("traineeId")Integer traineeId){
		Boolean trainee= traineeService.deleteTrainee(traineeId);
		if(trainee==false) {
			return new ResponseEntity("Sorry! TraineeId not available!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<String>("Trainee deleted successfully", HttpStatus.OK);
	}
	
	
	@GetMapping("/trainee/{traineeId}")
	public ResponseEntity<Trainee> findTrainee(
			@PathVariable("traineeId")Integer traineeId){
		Trainee trainee= traineeService.findTrainee(traineeId);
		if(trainee==null) {
			return new ResponseEntity("Sorry! Trainee not found!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Trainee>(trainee, HttpStatus.OK);
	}

	@GetMapping("/trainee")
	public ResponseEntity<List<Trainee>> getAllTrainee(){
		List<Trainee> trainee= traineeService.getAllTrainee();
		if(trainee.isEmpty()) {
			return new ResponseEntity("Sorry! Trainee not available!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<Trainee>>(trainee, HttpStatus.OK);
	}


	
	
}
