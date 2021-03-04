package com.georgeciachir.nebula;

public class Nebula {

    private static final int MINIMUM_EXPONENT = 0;
    private static final int MAXIMUM_EXPONENT = 30;
    private static final String ERROR_MESSAGE = String.format("The exponent should be between: %s and %s", MINIMUM_EXPONENT, MAXIMUM_EXPONENT);

    public static void main(String[] args) {
        int power = 30;

        Nebula nebula = new Nebula();
        String stars = nebula.starString(power);

        System.out.println(stars.length());
    }

    public String starString(int exponent) {
        if (exponent < MINIMUM_EXPONENT || exponent > MAXIMUM_EXPONENT) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }

        if (exponent == 0) {
            return "*";
        }

        return create("**", exponent);
    }

    private String create(String seed, int exponent) {
        if (exponent == 1) {
            return seed;
        }

        String squaredSeed = square(seed);
        if (isEven(exponent)) {
            return create(squaredSeed, exponent / 2);
        } else {
            String raisedToPower = create(squaredSeed, (exponent - 1) / 2);
            return multiply(raisedToPower, seed);
        }
    }

    private String square(String accumulator) {
        return multiply(accumulator, accumulator);
    }

    private String multiply(String first, String second) {
        int limit = second.length() - 1;

        StringBuilder toReturn = new StringBuilder(first);
        for (int i = 0; i < limit; i++) {
            toReturn.append(first);
        }
        return toReturn.toString();
    }

    private boolean isEven(int value) {
        return value % 2 == 0;
    }
}

