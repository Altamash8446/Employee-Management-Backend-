package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;

@Service
public interface EmployeeService {
	public Employee saveUser(Employee employee);

	public List<Employee> getAllUser();

	public Employee updateUser(Employee employee);

	public void deleteUser(Integer userId);

	public Employee getUserById(Integer userId);

}
