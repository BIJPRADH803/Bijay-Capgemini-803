package com.cg.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="trainne_table")
public class Trainee {
	@Id
	@Column(name="traine_Id")
	private int traineeId;
	private String traineeName;
	private String traineeDomain;
	private String traineeLocation;
	private String traineeCourse;
	public String getTraineeCourse() {
		return traineeCourse;
	}
	public void setTraineeCourse(String traineeCourse) {
		this.traineeCourse = traineeCourse;
	}
	public int getTraineeId() {
		return traineeId;
	}
	public void setTraineeId(int traineeId) {
		this.traineeId = traineeId;
	}
	public String getTraineeName() {
		return traineeName;
	}
	public void setTraineeName(String traineeName) {
		this.traineeName = traineeName;
	}
	public String getTraineeDomain() {
		return traineeDomain;
	}
	public void setTraineeDomain(String traineeDomain) {
		this.traineeDomain = traineeDomain;
	}
	public String getTraineeLocation() {
		return traineeLocation;
	}
	public void setTraineeLocation(String traineeLocation) {
		this.traineeLocation = traineeLocation;
	}
	public Trainee(int traineeId, String traineeName, String traineeDomain, String traineeLocation, String traineeCourse) {
		super();
		this.traineeId = traineeId;
		this.traineeName = traineeName;
		this.traineeDomain = traineeDomain;
		this.traineeLocation = traineeLocation;
		this.traineeCourse=traineeCourse;
	}
	public Trainee() {
		
	}
	@Override
	public String toString() {
		return "Trainee [traineeId=" + traineeId + ", traineeName=" + traineeName + ", traineeDomain=" + traineeDomain
				+ ", traineeLocation=" + traineeLocation + "traineeCourse=" + traineeCourse+"]";
	}
	
	

}
