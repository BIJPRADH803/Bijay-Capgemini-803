package com.cg.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entities.Trainee;
import com.cg.repositories.TraineeRepository;

@Service
public class TraineeServiceImpl implements TraineeService {
	
	@Autowired
	private TraineeRepository traineeRepo;

	@Override
	public List<Trainee> getAllTrainee() {
		return traineeRepo.findAll();
	}

	@Override
	public Trainee findTrainee(Integer traineeId) {
		// TODO Auto-generated method stub
		return traineeRepo.getById(traineeId);
	}

	@Override
	public boolean deleteTrainee(Integer traineeId) {
		 traineeRepo.deleteById(traineeId);
		 
		 Trainee t1= traineeRepo.getById(traineeId);
		 if(t1==null) {
			 return true;
		 }
		 return false;
	}

	@Override
	public List<Trainee> saveTrainee(List<Trainee> trainee) {
		return traineeRepo.saveAll(trainee);
	}

	@Override
	public Trainee updateTrainee(Trainee trainee) {
		// TODO Auto-generated method stub
		return traineeRepo.save(trainee);
	}

//	@Override
//	public Trainee saveAll() {
//		// TODO Auto-generated method stub
//		return traineeRepo.save(null);
//	}
	
	

}
