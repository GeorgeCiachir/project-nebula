package com.georgeciachir.nebula;

import java.util.Objects;

public class Assert {

    public static void assertEquals(Object actual, Object expected) {
        Objects.requireNonNull(actual);
        Objects.requireNonNull(expected);
        if (!actual.equals(expected)) {
            throw new AssertionError("The objects are not equal");
        }
    }

    public static void fail(String message) {
        throw new AssertionError(message);
    }
}
