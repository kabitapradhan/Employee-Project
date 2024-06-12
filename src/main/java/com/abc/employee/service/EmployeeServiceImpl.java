package com.abc.employee.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.employee.entity.Employee;
import com.abc.employee.exception.EmpNotFoundException;
import com.abc.employee.payload.EmployeeDto;
import com.abc.employee.repository.EmployeeRepository;

import ch.qos.logback.core.joran.util.beans.BeanUtil;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	private EmployeeRepository repo;

	@Override
	public EmployeeDto createEmp(EmployeeDto dto) {
		Employee emp = new Employee();
		BeanUtils.copyProperties(dto, emp);
		Employee save = this.repo.save(emp);
		return dto;
	}

	@Override
	public List<EmployeeDto> getAllDto() {
		List<Employee> list = this.repo.findAll();
		List<EmployeeDto> dtolist = new ArrayList<>();
		BeanUtils.copyProperties(list, dtolist);
		return dtolist;
	}

	@Override
	public EmployeeDto getEmpById(int id) {
		Employee employee = this.repo.findById(id)
		.orElseThrow(()-> new EmpNotFoundException("Employee not found with id :" + id));
		EmployeeDto dto = new EmployeeDto();
		BeanUtils.copyProperties(employee, dto);
		return dto;
	}

	@Override
	public EmployeeDto updateEmp(EmployeeDto dto, int id) {
		Employee emp = this.repo.findById(id)
				.orElseThrow(()-> new EmpNotFoundException("Employee not found with id :" + id));
		emp.setEmail(dto.getEmail());
		emp.setName(dto.getName());
		emp.setPassword(dto.getPassword());
		
		Employee save = this.repo.save(emp);
		
		return dto;
	}

	@Override
	public void deleteEmp(int id) {
		Employee employee = this.repo.findById(id)
				.orElseThrow(()-> new EmpNotFoundException("Employee not found with id :" + id));
				EmployeeDto dto = new EmployeeDto();
		this.repo.delete(employee);
	}

}
