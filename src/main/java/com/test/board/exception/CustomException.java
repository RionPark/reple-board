package com.test.board.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.Data;
import lombok.EqualsAndHashCode;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
@EqualsAndHashCode(callSuper=false)
@Data
public class CustomException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	private String errCode;
	public CustomException(String errMsg) {
		super(errMsg);
	}
	public CustomException(String errMsg, String errCode) {
		super(errMsg);
		this.errCode = errCode;
	}
}
