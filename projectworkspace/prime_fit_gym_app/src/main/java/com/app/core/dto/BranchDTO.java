package com.app.core.dto;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BranchDTO<T> {
	private HttpStatus status;
	private String mesg;
	private T response;

}
