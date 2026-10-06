package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FirstTaskTest {

    @Test
    void testZeroAndOne() {
        assertEquals(0, FirstTask.fibonacci(0));
        assertEquals(1, FirstTask.fibonacci(1));
    }

    @ParameterizedTest
    @CsvSource({
            "2, 1",
            "3, 2",
            "4, 3",
            "6, 8",
            "10, 55"
    })
    void testFibonacci(int n, long expected) {
        assertEquals(expected, FirstTask.fibonacci(n));
    }

    @Test
    void testNegativeInput() {
        assertThrows(IllegalArgumentException.class, () -> FirstTask.fibonacci(-1));
    }
}