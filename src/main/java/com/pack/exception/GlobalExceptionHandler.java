package com.pack.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest req) {
		List<String> details = new ArrayList<String>();

		details.add(ex.getLocalizedMessage());
		ErrorResponse error = new ErrorResponse(500L, details);

		return new ResponseEntity<Object>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(DuplicateEntryException.class)
	public final ResponseEntity<Object> handleDuplicateEntryException(DuplicateEntryException ex, WebRequest req) {
		List<String> details = new ArrayList<String>();

		details.add(ex.getLocalizedMessage());
		ErrorResponse error = new ErrorResponse(400L, details);

		return new ResponseEntity<Object>(error, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(BeneficiaryNotFoundException.class)
	public final ResponseEntity<Object> handleBeneficiaryNotFoundException(BeneficiaryNotFoundException ex,
			WebRequest req) {
		List<String> details = new ArrayList<>();

		details.add(ex.getLocalizedMessage());
		ErrorResponse error = new ErrorResponse(404L, details);

		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(BeneficiaryExistsException.class)
	public final ResponseEntity<Object> handleBeneficiaryExistsException(BeneficiaryExistsException ex,
			WebRequest req) {
		List<String> details = new ArrayList<>();

		details.add(ex.getLocalizedMessage());
		ErrorResponse error = new ErrorResponse(400L, details);

		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException ex, WebRequest req) {
		List<String> details = new ArrayList<String>();

		details.add(ex.getLocalizedMessage());

		ErrorResponse error = new ErrorResponse(404L, details);

		return new ResponseEntity<Object>(error, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(NoSufficientBalanceException.class)
	public final ResponseEntity<Object> handleNoSufficientBalanceException(NoSufficientBalanceException ex,
			WebRequest req) {
		List<String> details = new ArrayList<String>();

		details.add(ex.getLocalizedMessage());
		ErrorResponse error = new ErrorResponse(400L, details);

		return new ResponseEntity<Object>(error, HttpStatus.BAD_REQUEST);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest req) {
		List<String> details = new ArrayList<String>();

		for (ObjectError error : ex.getBindingResult().getAllErrors()) {
			details.add(error.getDefaultMessage());
		}

		ErrorResponse error = new ErrorResponse(410L, details);

		return new ResponseEntity<Object>(error, HttpStatus.BAD_REQUEST);
	}

}
