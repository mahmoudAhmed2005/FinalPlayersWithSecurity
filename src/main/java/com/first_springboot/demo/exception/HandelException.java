package com.first_springboot.demo.exception;

import com.first_springboot.demo.helper.MessageResponse;
import com.first_springboot.demo.service.bandleMessageService.BandleMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class HandelException {

@Autowired
    private BandleMessageService bandleMessageService;



@ExceptionHandler(Throwable.class)
    public ResponseEntity <MessageResponse> exception(Throwable throwable){




return ResponseEntity.badRequest().body( bandleMessageService.getMessage(throwable.getMessage()));

    }





    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<MessageResponse>> exception( MethodArgumentNotValidException exception) {


        List<MessageResponse> messageResponses = exception.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(fieldError ->bandleMessageService.getMessage(fieldError.getDefaultMessage()))

                .toList();

        return ResponseEntity.badRequest().body(messageResponses);
    }






//    @ExceptionHandler(MethodArgumentNotValidException.class)
//
//    public ResponseEntity <List<MessageResponse>> exception (MethodArgumentNotValidException exception){
//
//        List<FieldError> fieldErrors =   exception.getBindingResult().getFieldErrors();
//
//
//    List<MessageResponse> messageResponses = new ArrayList<>();
//    for (FieldError fieldError : fieldErrors) {
//
//        String errorMessage = fieldError.getDefaultMessage();
//
//        messageResponses.add(new MessageResponse(null,errorMessage));
//    }

//return ResponseEntity.badRequest().body(messageResponses);
   // }


}
