package com.example.coursework2.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionApiHandler {
    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Количество запрашиваемых вопросов превышает общее количество")
    @ExceptionHandler(NotExistException.class)
    public String handelExceptionAdd(NotExistException exception) {
        return exception.getMessage();
    }
    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Такого вопроса нет")
    @ExceptionHandler(NotFoundException.class)
    public String handelExceptionAdd(NotFoundException exception) {
        return exception.getMessage();
    }
}
