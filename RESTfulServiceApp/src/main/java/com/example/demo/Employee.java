package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Entity
public class Employee { 
	
	@Id
	private int id;
	private String name;
	private String tech;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTech() {
		return tech;
	}
	public void setTech(String tech) {
		this.tech = tech;
	}
	
	public void validate() {
		
		System.out.println("The Employee class is working...");
	}
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", tech=" + tech + "]";
	}
}
