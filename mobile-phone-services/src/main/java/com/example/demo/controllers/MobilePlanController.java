package com.example.demo.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

import com.example.demo.entity.MobilePlan;
import com.example.demo.service.MobilePlanService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path="/api/v1/mobileplans")
@AllArgsConstructor
public class MobilePlanController {
	
	private MobilePlanService service;
	
	
	
	@GetMapping
	public List <MobilePlan> findAll(){
		return this.service.findAll();
	}
	
	@GetMapping("/srch/{id}")
	public MobilePlan findById(@PathVariable("id") int id){
		return this.service.findById(id);
	}
	
	
	@PostMapping
    public ResponseEntity<MobilePlan> add(@RequestBody MobilePlan entity){
        MobilePlan addedObj = this.service.add(entity);
        
        URI location = ServletUriComponentsBuilder
                          .fromCurrentRequest()
                          .path("/{id}")
                          .buildAndExpand(entity.getPlanId())
                          .toUri();
                          
                
                          
        return ResponseEntity.created(location).body(addedObj);
        
    }
	@PutMapping
    public ResponseEntity<MobilePlan> update(@RequestBody MobilePlan entity){
        MobilePlan updatedObj = this.service.update(entity);
        return ResponseEntity.ok().body(updatedObj);
	}
	
	@DeleteMapping(path="/{id}")
    public ResponseEntity<String> delete(@PathVariable("id")int id){
        this.service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Deleted One Record");
	}
	
	@GetMapping("/srch/plan")
    public ResponseEntity<MobilePlan> findByplanName(@PathVariable("planName") String planName){
        return this.findByplanName(planName);
	}
	
	@PatchMapping("/{planName}/{updatedValue}")
	public ResponseEntity<String> updateValidity(@PathVariable("updatedValue") String updatedValue,@PathVariable("planName")String planName){
        int rowsUpdated=this.service.updateValidity(updatedValue,planName);
        return ResponseEntity.ok().body(rowsUpdated+"rows are Updated");
	}
	@GetMapping("/cost/{amount}")
    public ResponseEntity<MobilePlan> findByCostGrtThan(@PathVariable("amount") double amount){
        return this.findByCostGrtThan(amount);
	}
	
        
	
}
