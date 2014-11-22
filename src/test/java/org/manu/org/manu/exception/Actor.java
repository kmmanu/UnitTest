package org.manu.org.manu.exception;

/**
 * Created by Manu on 22-Nov-14.
 */
@FunctionalInterface
public interface Actor {
    void act() throws MyCustomException;
}
