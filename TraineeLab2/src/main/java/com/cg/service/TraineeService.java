package com.cg.service;

import java.util.List;

import com.cg.entities.Trainee;



public interface TraineeService {
	

	public List<Trainee> getAllTrainee();

	public Trainee findTrainee(Integer traineeId);

	public boolean deleteTrainee(Integer traineeId);

	public  List<Trainee> saveTrainee(List<Trainee> trainee1);

	public Trainee updateTrainee(Trainee trainee);
//	public Trainee saveAll();
}
