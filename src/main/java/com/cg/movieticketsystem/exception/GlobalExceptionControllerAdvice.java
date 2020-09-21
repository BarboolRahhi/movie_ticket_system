package com.cg.movieticketsystem.exception;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionControllerAdvice {
    @ExceptionHandler
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorResponse handleNotValidException(MethodArgumentNotValidException e) {
        List<String> collect = e.getBindingResult().getAllErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());
        return new ErrorResponse("Validation Error", collect);
    }

    @ExceptionHandler
    @ResponseStatus(code = HttpStatus.CONFLICT)
    @ResponseBody
    public ErrorResponse handleAlreadyExistsException(AlreadyExistsException e) {
        return new ErrorResponse(e.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorResponse handleNotFoundException(NotFoundException e) {
        return new ErrorResponse(e.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorResponse handleAllException(Exception e) {
        return new ErrorResponse(e.getMessage());
    }
}
