package com.test.board.aop;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.test.board.exception.CustomException;

@ControllerAdvice
@RestController
public class ExceptionHandlerAdvice {

	@ExceptionHandler(CustomException.class)
	public ResponseEntity<Map<String,String>> handleCustomException(CustomException ce,WebRequest wreq){
		Map<String,String> errMap  = new HashMap<>();
		errMap.put("errCode", ce.getErrCode());
		errMap.put("errMsg", ce.getMessage());
		return new ResponseEntity<>(errMap,HttpStatus.UNAUTHORIZED);
	}
}
