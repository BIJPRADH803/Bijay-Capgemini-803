package com.cg.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)

public class QuestionException extends Exception{

private static final long serialVersionUID = 1L;

	public QuestionException(final String str) {
		 super(str);
	 }
}
