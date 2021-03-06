package com.cg.exception;

import java.util.Date;

import javax.persistence.EntityNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice

public class EducationSystemExceptionsHandler extends ResponseEntityExceptionHandler {
		@ExceptionHandler(value = { Exception.class })
	public ResponseEntity<Object> handleAnyException(final Exception exception, final WebRequest request) {
		return new ResponseEntity<Object>(exception, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	

	@Override
	  protected ResponseEntity<Object> handleMethodArgumentNotValid(final MethodArgumentNotValidException exception,
			  final HttpHeaders headers, final HttpStatus status, final WebRequest request) {
	    final ErrorMessage errorMessage = new ErrorMessage();
	    errorMessage.setErrorCode(HttpStatus.BAD_REQUEST.value());
		errorMessage.setMessage(exception.getBindingResult().getAllErrors().get(0).getDefaultMessage());
	    return new ResponseEntity<>(errorMessage, HttpStatus.OK);
	  } 
	
	
	
	
	@ExceptionHandler(value = {EmailAlreadyExistsException.class})
	public ResponseEntity<ErrorMessage> handleEmailAlreadyExistsException(final EmailAlreadyExistsException exception){
		final ErrorMessage errorMessage = new ErrorMessage();
		errorMessage.setErrorCode(HttpStatus.BAD_REQUEST.value());
		errorMessage.setMessage(exception.getMessage());
		return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.OK);
	}
	
	
	
	
	@ExceptionHandler(value = {UserNameExistException.class})
	public ResponseEntity<ErrorMessage> handleUserNameAlreadyExistsException(final UserNameExistException exception){
		final ErrorMessage errorMessage = new ErrorMessage();
		errorMessage.setErrorCode(HttpStatus.BAD_REQUEST.value());
		errorMessage.setMessage(exception.getMessage());
		return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.OK);
	}
	

	@ExceptionHandler(value = {PasswordAndConfirmPasswordNotMatchException.class})
	public ResponseEntity<ErrorMessage> handlePasswordAndConfirmPassword(final PasswordAndConfirmPasswordNotMatchException exception){
		final ErrorMessage errorMessage = new ErrorMessage();
		errorMessage.setErrorCode(HttpStatus.BAD_REQUEST.value());
		errorMessage.setMessage(exception.getMessage());
		return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.OK);
	}
	
	
	
	@ExceptionHandler(value = {StudentNotFoundException.class})
	public ResponseEntity<ErrorMessage> handleStudentNotFoundException(final StudentNotFoundException exception){
		final ErrorMessage errorMessage = new ErrorMessage();
		errorMessage.setErrorCode(HttpStatus.BAD_REQUEST.value());
		errorMessage.setMessage(exception.getMessage());
		return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.OK);
	}
	
	
	
	@ExceptionHandler(value = {EntityNotFoundException.class})
	public ResponseEntity<String> handleEntityNotFoundException(final EntityNotFoundException exception){		
		return new ResponseEntity<String>("Student With given Id is not available", HttpStatus.OK);
	}

	
	
	@ExceptionHandler(value = {RegistrationRequestNotApprovedException.class})
	public ResponseEntity<ErrorMessage> handleRegistrationNotApprovedException(final RegistrationRequestNotApprovedException exception){
		final ErrorMessage errorMessage = new ErrorMessage();
		errorMessage.setErrorCode(HttpStatus.FORBIDDEN.value());
		errorMessage.setMessage(exception.getMessage());
		return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.OK);
	}
	
	@ExceptionHandler(value = {CourseNotFoundException.class})
	public ResponseEntity<ErrorMessage> handleCourseNotFoundException(final CourseNotFoundException exception){
		final ErrorMessage errorMessage = new ErrorMessage();
		errorMessage.setErrorCode(HttpStatus.NOT_FOUND.value());
		errorMessage.setMessage(exception.getMessage());
		return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.OK);
	}
	
	
	@ExceptionHandler(value = {AlreadyEnrolledInCourseException.class})
	public ResponseEntity<ErrorMessage> handleAlreadyEnrolledInCourseException(final AlreadyEnrolledInCourseException exception){
		final ErrorMessage errorMessage = new ErrorMessage();
		errorMessage.setErrorCode(HttpStatus.BAD_REQUEST.value());
		errorMessage.setMessage(exception.getMessage());
		return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.OK);
	}
	
	// specific exception handler for id not found
		@ResponseBody
		@ResponseStatus(HttpStatus.BAD_REQUEST)
		@ExceptionHandler(InvalidInputException.class)
		
		ErrorMessageDetails validationExceptionHandler(final InvalidInputException exception,final WebRequest request) {
			return new ErrorMessageDetails(new Date(), "400", exception.getMessage(), request.getDescription(false));
		}

		// database exception handler for object not found
		@ResponseBody
		@ResponseStatus(HttpStatus.NOT_FOUND)
		@ExceptionHandler(InvalidAdminException.class)
		
		ErrorMessageDetails exceptionHandler(final InvalidAdminException e,final WebRequest request) {
			return new ErrorMessageDetails(new Date(), "404", e.getMessage(), request.getDescription(false));
		}

		// database exception handler for object not found
		@ResponseBody
		@ResponseStatus(HttpStatus.NOT_FOUND)
		@ExceptionHandler(InvalidMessageException.class)
		
		ErrorMessageDetails exceptionHandler(final InvalidMessageException exception, final  WebRequest request) {
			return new ErrorMessageDetails(new Date(), "404", exception.getMessage(), request.getDescription(false));
		}

		// database exception handler for object not found
		@ResponseBody
		@ResponseStatus(HttpStatus.NOT_FOUND)
		@ExceptionHandler(InvalidProgressException.class)
		
		ErrorMessageDetails exceptionHandler(final InvalidProgressException exception,final WebRequest request) {
			return new ErrorMessageDetails(new Date(), "404", exception.getMessage(), request.getDescription(false));
		}
}
