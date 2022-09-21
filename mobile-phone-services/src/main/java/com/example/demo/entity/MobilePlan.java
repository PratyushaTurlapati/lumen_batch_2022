package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level=AccessLevel.PRIVATE)
@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="lumen_mobile_plans")

public class MobilePlan {
	
	
	@Id
	@Column(name="plan_Id")
	int planId;
	@Column(name="plan_Name")
	String planName;
	@Column(name="plan_Cost")
	double cost;
	@Column(name="plan_Validity")
	String validity;

}
