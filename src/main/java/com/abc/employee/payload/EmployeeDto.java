package com.abc.employee.payload;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
	
	@NotNull(message = "Name must not be empty!!!!")
	@NotBlank(message = "Name must not be empty!!!!")
	private String name;
	
	@NotNull(message = "Email must not be empty!!!!")
	@Email(message = "Email must be valid!!!!")
	private String email;
	
	@NotNull(message = "Password must not be empty!!!!")
	@Size(min = 3,max = 10,message = "Password shoild min size 3 and max 10!!!!!")
	private String password;
}
