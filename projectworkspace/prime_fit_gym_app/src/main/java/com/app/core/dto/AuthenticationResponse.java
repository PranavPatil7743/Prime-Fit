package com.app.core.dto;

public class AuthenticationResponse {
	private final String mesg;

	public AuthenticationResponse(String mesg) {
		super();
		this.mesg = mesg;
	}

	public String getMesg() {
		return mesg;
	}
	
	
}
