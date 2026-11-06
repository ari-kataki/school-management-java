package com.its.umbria.academy.exceptions;

public class ITSException extends Exception{

    @Override
    public String getMessage() {
        return "ITS error occurred at: " + java.time.LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "ITS error code [007] - " + getMessage();
    }

    public ITSException(String message) {
            super(message);
        }
        public ITSException(String message, Throwable cause) {
            super(message, cause);
        }
    }




