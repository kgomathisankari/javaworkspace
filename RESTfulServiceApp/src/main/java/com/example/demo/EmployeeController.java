package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeRepo repo ;
	
	@PostMapping("/employee")
	public Employee addEmployee(Employee e) {
		repo.save(e);
		return e;
	}
	
	@PostMapping("/employees")
	public List<Employee> addEmployee(List<Employee> e) {
		repo.saveAll(e);
		return e;
	}
	
	@GetMapping("/employees")
	public List<Employee> getEmployees(){
		System.out.println("Get All Employeee Details...");
		return repo.findAll();
	}
	
	@GetMapping("/employee/{id}")
	public Employee getDetails(@PathVariable int id){
		return findEmployee(id);
	}
	
	@DeleteMapping("/employee/{id}")
	public void deleteDetails(@PathVariable int id) {
		System.out.println("Deleting Record of "+id);
		repo.deleteById(id);
	}
	
	@PutMapping("/employee/{id}")
	public Employee updateDetails(@PathVariable int id, Employee e) {
		repo.save(e);
		return e;
	}
	
	private Employee findEmployee(int id) {
		Employee emp = repo.findById(id).orElse(new Employee());
		System.out.println("Finding Details..."+emp.toString());
		return emp;
	}
}
