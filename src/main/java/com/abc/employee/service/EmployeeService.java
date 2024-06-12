package com.abc.employee.service;

import java.util.List;

import com.abc.employee.payload.EmployeeDto;

public interface EmployeeService {
	
	public EmployeeDto createEmp(EmployeeDto dto);
	public List<EmployeeDto> getAllDto();
	public EmployeeDto getEmpById(int id);
	public EmployeeDto updateEmp(EmployeeDto dto , int id);
	public void deleteEmp(int id);

}
