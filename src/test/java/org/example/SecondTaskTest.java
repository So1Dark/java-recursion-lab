package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SecondTaskTest {

    @Test
    void testSingleDigits() {
        assertEquals(0, SecondTask.sumOfDigits(0));
        assertEquals(7, SecondTask.sumOfDigits(7));
    }

    @ParameterizedTest
    @CsvSource({
            "12, 3",
            "505, 10",
            "12345, 15",
            "-456, 15"
    })
    void testSumOfDigits(int n, int expected) {
        assertEquals(expected, SecondTask.sumOfDigits(n));
    }
}