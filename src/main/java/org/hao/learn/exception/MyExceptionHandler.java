package org.hao.learn.exception;

import org.apache.commons.lang3.StringUtils;
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
    public ExceptionResponse myExceptionHandler(MyException myException) {
        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setMessage(myException.getMessage());
        return exceptionResponse;
    }

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(AuthenticationException.class)
    @ResponseBody
    public ExceptionResponse authenticationExceptionHandler(AuthenticationException authenticationException) {
        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setMessage(authenticationException.getMessage());
        return exceptionResponse;
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(NotLoginException.class)
    @ResponseBody
    public ExceptionResponse authenticationExceptionHandler(NotLoginException notLoginException) {
        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setMessage(notLoginException.getMessage());
        return exceptionResponse;
    }

}
