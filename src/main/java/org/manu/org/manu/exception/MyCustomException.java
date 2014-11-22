package org.manu.org.manu.exception;

/**
 * Created by Manu on 22-Nov-14.
 */
public class MyCustomException extends RuntimeException{
    private String errorCode;

    public MyCustomException(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
