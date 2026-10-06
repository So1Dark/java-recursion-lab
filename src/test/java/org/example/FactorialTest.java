package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FactorialTest {

    @ParameterizedTest
    @CsvSource({
            "0, 1",
            "1, 1",
            "2, 2",
            "3, 6",
            "5, 120",
            "10, 3628800",
            "20, 2432902008176640000"
    })
    void testFactorial(int n, String expected) {
        long expectedLong = Long.parseLong(expected);
        BigInteger expectedBigInt = new BigInteger(expected);

        assertEquals(expectedLong, Factorial.factorialLong(n));
        assertEquals(expectedBigInt, Factorial.factorialBigInteger(n));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -5, -10})
    void testNegativeNumbers(int n) {
        assertThrows(IllegalArgumentException.class, () -> Factorial.factorialLong(n));
        assertThrows(IllegalArgumentException.class, () -> Factorial.factorialBigInteger(n));
    }

    @Test
    void testLongOverflow() {
        int overflowN = -1;

        for (int n = 1; n <= 30; n++) {
            long longResult = Factorial.factorialLong(n);
            BigInteger bigIntResult = Factorial.factorialBigInteger(n);

            if (!BigInteger.valueOf(longResult).equals(bigIntResult)) {
                overflowN = n;
                break;
            }
        }

        assertEquals(21, overflowN);
    }
}