package com.example.PaymentService.exception;
import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ExceptionHandler 
{
	//To handle specific exception
	@org.springframework.web.bind.annotation.ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException exception,
			WebRequest request)
	{
		ErrorDetails errorDetails=new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND);
	}
	
	//To handle global exception
	@org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleGlobalException(Exception exception,
			WebRequest request)
	{
		ErrorDetails errorDetails=new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	//To handling validation related  exceptions
	@org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> customValidation(MethodArgumentNotValidException exception)
	{
		ErrorDetails errorDetails=new ErrorDetails(new Date(),"Validation Error..!! Please recheck the data that you need to added..",
				exception.getBindingResult().getFieldError().getDefaultMessage());
		return new ResponseEntity<>(errorDetails,HttpStatus.BAD_REQUEST);
	}
}
