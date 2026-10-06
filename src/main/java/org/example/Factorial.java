package org.example;

import java.math.BigInteger;

public class Factorial {

    public static long factorialLong(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n must be non-negative");
        }
        if (n <= 1) {
            return 1L;
        }
        return n * factorialLong(n - 1);
    }

    public static BigInteger factorialBigInteger(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n must be non-negative");
        }
        if (n <= 1) {
            return BigInteger.ONE;
        }
        return BigInteger.valueOf(n).multiply(factorialBigInteger(n - 1));
    }
}