package org.manu.org.manu.exception;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.manu.org.manu.exception.ExceptionThrown.catchException;

/**
 * Created by Manu on 22-Nov-14.
 */
public class ExceptionThrowerTest {
    private ExceptionThrower exceptionThrower = new ExceptionThrower();

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void should_throw_exception_and_handle_with_try_catch() {
        try {
            exceptionThrower.doSomeOperatoin();
            fail("The method failed to throw exception.");
        } catch (MyCustomException e) {
            assertThat(e.getErrorCode(), is("Hello"));
        }
    }

    @Test
    public void should_throw_exception_and_handle_with_ExpectedException() {
        // Given
        thrown.expect(new MyCustomExceptionMatcher());

        // When
        exceptionThrower.doSomeOperatoin();
    }

    @Test
    public void should_throw_exception_and_handle_with_lambda() {

        // When
        ExceptionThrown exceptionThrown = catchException(() -> exceptionThrower.doSomeOperatoin());

        // Then
        exceptionThrown.hasErrorCode("Hello");
    }


}

class MyCustomExceptionMatcher extends TypeSafeMatcher<MyCustomException> {


    @Override
    protected boolean matchesSafely(MyCustomException item) {
        assertThat(item.getErrorCode(), is("Hello"));
        return true;
    }

    @Override
    public void describeTo(Description description) {

    }
}
