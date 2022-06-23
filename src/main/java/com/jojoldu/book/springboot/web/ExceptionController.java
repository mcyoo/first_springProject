package com.jojoldu.book.springboot.web;

import com.jojoldu.book.springboot.web.response.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

//에러 JSON 응답
@Slf4j
@ControllerAdvice
public class ExceptionController {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ErrorResponse invalidRequestHandler(MethodArgumentNotValidException e){
        ErrorResponse response = new ErrorResponse("400","잘못된 요청입니다.");

        for(FieldError fieldError : e.getBindingResult().getFieldErrors()){
            response.addValidation(fieldError.getField(),fieldError.getDefaultMessage());
        }
        return response;
    }
}

