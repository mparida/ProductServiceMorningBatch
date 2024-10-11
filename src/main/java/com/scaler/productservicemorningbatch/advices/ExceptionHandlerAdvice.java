package com.scaler.productservicemorningbatch.advices;

import com.scaler.productservicemorningbatch.dtos.ArithmeticExceptionDto;
import com.scaler.productservicemorningbatch.dtos.ArrayIndexOutOfBoundsExceptionDto;
import com.scaler.productservicemorningbatch.dtos.ExceptionDto;
import com.scaler.productservicemorningbatch.excepptions.InvalidProductIdException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ArithmeticExceptionDto> handleArithmeticException(Exception ex) {
        ArithmeticExceptionDto dto = new ArithmeticExceptionDto();
        dto.setMessage("Exception happened - Arithmetic Exception");
        dto.setDetail("Some random Detail");
        return new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<ArrayIndexOutOfBoundsExceptionDto> handlerArrayIndexOutOfBoundsException(Exception ex) {
        return null;
    }
    @ExceptionHandler(InvalidProductIdException.class)
    public ResponseEntity<ExceptionDto> invalidProductIDException(Exception ex) {
        ExceptionDto dto = new ExceptionDto();
        dto.setMessage("Invalid Product Id Passed, Please retry with a valid Product Id");
        return new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
    }
}
