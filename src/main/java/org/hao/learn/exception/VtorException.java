package org.hao.learn.exception;

import java.util.ArrayList;
import java.util.List;

public class VtorException extends MyException {
    List<String> messages = new ArrayList<>();

    public VtorException() {
    }

    public VtorException(String message) {
        super(message);
    }

    public VtorException(List<String> messages) {
        if (messages != null) {
            this.messages = messages;
        }
    }

    public VtorException(String message, Throwable cause) {
        super(message, cause);
    }

    public VtorException(Throwable cause) {
        super(cause);
    }

    public VtorException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public List<String> getMessages() {
        return messages;
    }
}
