package com.example.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationExceptionHandler {

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleInvalidArguments(MethodArgumentNotValidException ex) {
		HashMap<String, String> errorsMap = new HashMap<>();
		ex.getBindingResult().getFieldErrors().forEach(error -> {
			errorsMap.put(error.getField(), error.getDefaultMessage());
		});
		return errorsMap;
	}

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<Map<String, String>> handleUserNotFoundException(UserNotFoundException ex) {
		HashMap<String, String> errorsMap = new HashMap<>();
		errorsMap.put("errorMessage", ex.getMessage());
		return new ResponseEntity<Map<String, String>>(errorsMap, HttpStatus.NOT_FOUND);
	}
}
