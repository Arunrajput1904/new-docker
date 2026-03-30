package com.SchoolManagementSystem.SchoolManagementSystem.advice;

import com.SchoolManagementSystem.SchoolManagementSystem.Exceptions.InvalidArgument;

import com.SchoolManagementSystem.SchoolManagementSystem.Exceptions.ResourceNotFoundException;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionhandler {




    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiError> ResourceNotFoundException(ResourceNotFoundException exception){

        ApiError apiError=ApiError.builder().status(HttpStatus.NOT_FOUND).ErrorMessage(exception.getMessage()).build();

        return new ResponseEntity<>(apiError,HttpStatus.NOT_FOUND);

    }


    @ExceptionHandler(InvalidArgument.class)
    public ResponseEntity<ApiError> InvalidArgument(InvalidArgument exception){

        ApiError apiError=ApiError.builder().status(HttpStatus.BAD_REQUEST).ErrorMessage(exception.getMessage()).build();

        return new ResponseEntity<>(apiError,HttpStatus.BAD_REQUEST);

    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> Exception(Exception exception){

        ApiError apiError=ApiError.builder().status(HttpStatus.INTERNAL_SERVER_ERROR).ErrorMessage(exception.getMessage()).build();

        return new ResponseEntity<>(apiError,HttpStatus.INSUFFICIENT_STORAGE);

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> MethodArgumentNotValidException(MethodArgumentNotValidException exception){

        List<String>errors=exception.getBindingResult().getAllErrors().stream().map(error->error.getDefaultMessage()).toList();



        ApiError apiError=ApiError.builder().status(HttpStatus.BAD_REQUEST).ErrorMessage("Invalid method").SubErrorMessage(errors).build();

        return new ResponseEntity<>(apiError,HttpStatus.BAD_REQUEST);

    }



}
