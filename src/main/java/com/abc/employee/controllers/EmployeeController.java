package com.abc.employee.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.employee.entity.Employee;
import com.abc.employee.payload.EmployeeDto;
import com.abc.employee.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/emps")
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;
	
	@PostMapping("/")
	public ResponseEntity<EmployeeDto> createEmp(@Valid @RequestBody EmployeeDto dto){
		EmployeeDto emp = this.empService.createEmp(dto);
		return new ResponseEntity<EmployeeDto>(emp,HttpStatus.CREATED);
	}
	public ResponseEntity<List<EmployeeDto>> getAllEmp(){
		List<EmployeeDto> list = this.empService.getAllDto();
		return new ResponseEntity<List<EmployeeDto>>(list , HttpStatus.OK);
	}

}
