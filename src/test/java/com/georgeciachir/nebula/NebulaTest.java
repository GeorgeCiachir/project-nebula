package com.georgeciachir.nebula;//import org.junit.Test;

import java.math.BigInteger;

import static com.georgeciachir.nebula.Assert.assertEquals;
import static com.georgeciachir.nebula.Assert.fail;

public class NebulaTest {

    private static final int MINIMUM_EXPONENT = 0;
    private static final int MAXIMUM_EXPONENT = 30;
    private static final String EXPECTED_ERROR_MESSAGE =
            String.format("The exponent should be between: %s and %s", MINIMUM_EXPONENT, MAXIMUM_EXPONENT);

    public static void main(String[] args) {
        testTheCreationOfTheCorrectNumberOfStars();
        testExponentValueCannotExceedLowerBoundary();
        testExponentValueCannotExceedHigherBoundary();
    }

    private static void testTheCreationOfTheCorrectNumberOfStars() {
        //given
        Nebula nebula = new Nebula();

        for (int exponent = 0; exponent < 30; exponent++) {
            int expected = BigInteger.valueOf(2).pow(exponent).intValue();

            //when
            int createdStars = nebula.starString(exponent).length();

            //then
            assertEquals(expected, createdStars);
        }
    }

    private static void testExponentValueCannotExceedLowerBoundary() {
        //given
        Nebula nebula = new Nebula();

        try {
            //when
            nebula.starString(MINIMUM_EXPONENT - 1);
            fail("Should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            //then
            assertEquals(EXPECTED_ERROR_MESSAGE, e.getMessage());
        }
    }

    private static void testExponentValueCannotExceedHigherBoundary() {
        //given
        Nebula nebula = new Nebula();

        try {
            //when
            nebula.starString(MAXIMUM_EXPONENT + 1);
            fail("Should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            //then
            assertEquals(EXPECTED_ERROR_MESSAGE, e.getMessage());
        }
    }
}