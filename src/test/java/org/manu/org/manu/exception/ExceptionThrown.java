package org.manu.org.manu.exception;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;

/**
 * Created by Manu on 22-Nov-14.
 */
public class ExceptionThrown {
    private MyCustomException exception;

    public ExceptionThrown(MyCustomException e) {
        exception = e;
    }

    public static ExceptionThrown catchException(Actor actor) {
        try {
            actor.act();
        } catch (MyCustomException e) {
            return new ExceptionThrown(e);
        }
        return new ExceptionThrown(null);
    }

    public ExceptionThrown isInstanceOf(Class<? extends Throwable> exceptionClass) {
        Assert.assertThat(exception, CoreMatchers.isA((Class<Throwable>) exceptionClass));
        return this;
    }

    public ExceptionThrown hasErrorCode(String errorCode) {
        Assert.assertThat(exception.getErrorCode(), CoreMatchers.is(errorCode));
        return this;
    }
}
