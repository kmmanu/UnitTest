package org.manu.org.manu.exception;

/**
 * Created by Manu on 22-Nov-14.
 */
public class ExceptionThrower {

    public void doSomeOperatoin() {
        throw new MyCustomException("Hello");
    }
}
