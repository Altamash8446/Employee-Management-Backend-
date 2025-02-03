package com.example.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/save")
	public ResponseEntity<?> saveUser(@RequestBody Employee employee) {
		Employee saveUser = employeeService.saveUser(employee);

		if (ObjectUtils.isEmpty(saveUser)) {
			return new ResponseEntity<>("Employee not saved", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(saveUser, HttpStatus.CREATED);
	}

	@GetMapping("/getUsers")
	public ResponseEntity<?> getAllUser() {
		List<Employee> allUsers = employeeService.getAllUser();
		return new ResponseEntity<>(allUsers, HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<?> updateUser(@RequestBody Employee employee) {
		Employee saveUser = employeeService.saveUser(employee);

		if (ObjectUtils.isEmpty(saveUser)) {
			return new ResponseEntity<>("Employee not updated", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(saveUser, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable Integer id) {
		employeeService.deleteUser(id);
		return new ResponseEntity<>("Delete Successfully", HttpStatus.OK);
	}

	@GetMapping("/user/{id}")
	public ResponseEntity<?> getUserById(@PathVariable Integer id) {
		Employee userById = employeeService.getUserById(id);
		if (ObjectUtils.isEmpty(userById)) {
			return new ResponseEntity<>("Employee not found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(userById, HttpStatus.OK);
	}

}
