package com.goutam.example.productserv_nov.Advice;

import com.goutam.example.productserv_nov.DTO.ErrorDTO;
import com.goutam.example.productserv_nov.Exception.Productnotfound;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class Controller_Advice {
    @ExceptionHandler(Productnotfound.class)
    public ResponseEntity Exceptionmessage(){
        ErrorDTO errorDTO = new ErrorDTO("Product not found");
        ResponseEntity<ErrorDTO> responseEntity = new ResponseEntity<>(errorDTO, HttpStatusCode.valueOf(500));
        return responseEntity;
    }
}
