package org.hao.learn.exception;

import java.util.List;

public class VtorExceptionResponse<T> {
    private List<T> messages;

    public VtorExceptionResponse() {
    }

    public VtorExceptionResponse(String message, List<T> messages) {
        this.messages = messages;
    }

    public List<T> getMessages() {
        return messages;
    }

    public void setMessages(List<T> messages) {
        this.messages = messages;
    }
}
