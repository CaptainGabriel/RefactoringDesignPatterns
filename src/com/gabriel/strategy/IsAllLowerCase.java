package com.gabriel.strategy;

/**
 * Validation strategy to check if a string has every
 * letter in lower case.
 */
public class IsAllLowerCase implements ValidationStrategy {

    @Override
    public boolean execute(String toEval) {
        return toEval.matches("[a-z ]+");
    }
}
