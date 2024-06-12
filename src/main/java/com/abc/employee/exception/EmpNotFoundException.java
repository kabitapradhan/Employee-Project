package com.abc.employee.exception;

public class EmpNotFoundException extends RuntimeException{
	public EmpNotFoundException(String msg) {
		super(msg);
	}
}
