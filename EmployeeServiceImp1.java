package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeServiceImp1 implements EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee saveUser(Employee employee) {
		Employee savedUser = employeeRepository.save(employee);
		return savedUser;
	}

	@Override
	public List<Employee> getAllUser() {
		List<Employee> allUsers = employeeRepository.findAll();
		return allUsers;
	}

	@Override
	public Employee updateUser(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public void deleteUser(Integer userId) {
		Optional<Employee> findByIdUser = employeeRepository.findById(userId);

		if (findByIdUser.isPresent()) {
			Employee employee = findByIdUser.get();
			employeeRepository.delete(employee);
		}
	}

	@Override
	public Employee getUserById(Integer userId) {
		Optional<Employee> findByIdUser = employeeRepository.findById(userId);
		if (findByIdUser.isPresent()) {
			return findByIdUser.get();
		}
		return null;
	}

}

