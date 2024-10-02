package com.practice.crud.handler;

import com.practice.crud.entity.ExceptionResponse;
import com.practice.crud.exceptions.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleStudentNotFoundException(StudentNotFoundException ex){
        ExceptionResponse res= new ExceptionResponse();
        res.setMsg(ex.getMessage());
        res.setStatus(HttpStatus.NOT_FOUND);
        res.setDate(new Date());
        return  ResponseEntity.ok(res);
    }
}
