package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.demo.entity.MobilePlan;
import com.example.demo.repo.PlanRepository;
import com.training.exceptions.ElementNotFoundException;

@Service
public class MobilePlanService {
	
	private  PlanRepository repo;

	@Autowired
	public MobilePlanService(PlanRepository repo) {
		super();
		this.repo = repo;
	}
	
	public List<MobilePlan> findAll(){
		return this.repo.findAll();
	}
	

	public MobilePlan add(MobilePlan entity) {
		// TODO Auto-generated method stub
		return this.repo.save(entity);
	}
	
	public MobilePlan findById(int id) {
		
		String message=new StringBuilder("Element With Given Id")
				.append(id).append("Not Found").toString();
		return this.repo.findById(id)
		      .orElseThrow( ()-> new RuntimeException(message));
	}

	public MobilePlan update(MobilePlan entity) {
		// TODO Auto-generated method stub
		return this.repo.save(entity);
	}

	public void delete(Integer id) {
		this.repo.deleteById(id);
	}

	
    
	
	public List <MobilePlan> findByPlanName(String planName){
		 return this.repo.findByPlanName(planName);
	}
	
	public List <MobilePlan> findByCostGrtThan(double amount){
		return this.repo.findByCostGrtThan(amount);
	}
	
	public int updateValidity(String updatedValue,String planName) {
		return this.repo.updateValidity(updatedValue, planName);
	}
	
	
	
	
	

}
