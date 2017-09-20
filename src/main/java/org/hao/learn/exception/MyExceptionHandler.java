package org.hao.learn.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class MyExceptionHandler {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(VtorException.class)
    @ResponseBody
    public VtorExceptionResponse vtorExceptionHandler(VtorException vtorException) {
        VtorExceptionResponse<String> vtorExceptionResponse = new VtorExceptionResponse<>();
        vtorExceptionResponse.setMessages(vtorException.getMessages());
        return vtorExceptionResponse;
    }

    @ResponseStatus(HttpStatus.NOT_IMPLEMENTED)
    @ExceptionHandler(MyException.class)
    @ResponseBody
    public ExceptionResponse myExceptionHandler(MyException vtorException) {
        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setMessage(vtorException.getMessage());
        return exceptionResponse;
    }
}
