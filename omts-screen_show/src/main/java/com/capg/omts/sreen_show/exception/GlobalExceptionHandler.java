package com.capg.omts.sreen_show.exception;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capg.omts.sreen_show.exception.IdAlreadyExistsException;
import com.capg.omts.sreen_show.exception.IdNotExistsException;
import com.capg.omts.sreen_show.exception.InValidIdException;

/**
 * GlobalExceptionHandler class
 *
 * @author :Devu Om SriDatta Sai Swaroop
 * @version :1.0
 * @since :2020-09-19
 **/
@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value = {IdAlreadyExistsException.class})
	public @ResponseBody ResponseEntity<ErrorResponseInfo>  handleIdAlreadyExistsException(IdAlreadyExistsException exception,HttpServletRequest request)
	{
		ErrorResponseInfo errorInfo=new ErrorResponseInfo( LocalDateTime.now(), exception.getMessage(), 
	    HttpStatus.BAD_REQUEST.getReasonPhrase(), HttpStatus.BAD_REQUEST.value(), request.getRequestURI());
		
		ResponseEntity<ErrorResponseInfo> response=new ResponseEntity<ErrorResponseInfo>(errorInfo, HttpStatus.BAD_REQUEST);
		
		return response;
		
	}
	
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	@ExceptionHandler(value = {IdNotExistsException.class})
	public @ResponseBody ResponseEntity<ErrorResponseInfo>  handleIdNoExistsException(IdNotExistsException exception,HttpServletRequest request)
	{
		ErrorResponseInfo errorInfo=new ErrorResponseInfo( LocalDateTime.now(), exception.getMessage(), request.getRequestURI());
		
		ResponseEntity<ErrorResponseInfo> response=new ResponseEntity<ErrorResponseInfo>(errorInfo, HttpStatus.NOT_FOUND);
		
		return response;
		
	}

	@ResponseStatus(code = HttpStatus.NOT_ACCEPTABLE)
	@ExceptionHandler(value = {InValidIdException.class})
	public @ResponseBody ResponseEntity<ErrorResponseInfo>  handleInvalidIdException(InValidIdException exception,HttpServletRequest request)
	{
		ErrorResponseInfo errorInfo=new ErrorResponseInfo( LocalDateTime.now(), exception.getMessage(), 
	      HttpStatus.NOT_ACCEPTABLE.getReasonPhrase(), HttpStatus.NOT_ACCEPTABLE.value(), request.getRequestURI());
		
		ResponseEntity<ErrorResponseInfo> response=new ResponseEntity<ErrorResponseInfo>(errorInfo, HttpStatus.NOT_ACCEPTABLE);
		
		return response;
		
	}
	@ResponseStatus(code = HttpStatus.NOT_ACCEPTABLE)
	@ExceptionHandler(value = {InValidNameException.class})
	public @ResponseBody ResponseEntity<ErrorResponseInfo>  handleInValidNameException(InValidNameException exception,HttpServletRequest request)
	{
		ErrorResponseInfo errorInfo=new ErrorResponseInfo( LocalDateTime.now(), exception.getMessage(), request.getRequestURI());
		
		ResponseEntity<ErrorResponseInfo> response=new ResponseEntity<ErrorResponseInfo>(errorInfo, HttpStatus.NOT_ACCEPTABLE);
		
		return response;
		
	}
	@ResponseStatus(code = HttpStatus.NOT_ACCEPTABLE)
	@ExceptionHandler(value = {InValidTimeException.class})
	public @ResponseBody ResponseEntity<ErrorResponseInfo>  handleInValidTimeException(InValidTimeException exception,HttpServletRequest request)
	{
		ErrorResponseInfo errorInfo=new ErrorResponseInfo( LocalDateTime.now(), exception.getMessage(), request.getRequestURI());
		
		ResponseEntity<ErrorResponseInfo> response=new ResponseEntity<ErrorResponseInfo>(errorInfo, HttpStatus.NOT_ACCEPTABLE);
		
		return response;
		
	}

}

