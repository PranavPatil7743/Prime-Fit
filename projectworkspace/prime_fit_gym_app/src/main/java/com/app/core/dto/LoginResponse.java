package com.app.core.dto;

import org.springframework.http.HttpStatus;

import com.app.core.pojos.UserRole;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class LoginResponse<T> {
	private HttpStatus status;
	private String mesg;
	private T response;
	private UserRole role;
}
