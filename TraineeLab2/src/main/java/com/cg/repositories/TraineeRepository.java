package com.cg.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.entities.Trainee;

@Repository
public interface TraineeRepository extends JpaRepository<Trainee, Integer> {
	
//	public List<Trainee> getAllTrainee();
//
//	public Trainee findTrainee(Integer traineeId);
//
//	public List<Trainee> deleteTrainee(Integer traineeId);
//
//	public List<Trainee> saveTrainee(Trainee trainee);
//
//	public List<Trainee> updateTrainee(Trainee trainee);
//	public List<Trainee> saveAll();



}
