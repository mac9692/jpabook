package com.ex.junitbook;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.TestInstance.*;

@TestInstance(Lifecycle.PER_METHOD)
class CalculatorTest {

    @Test
    void testAdd() {
        Calculator calculator = new Calculator();
        double result = calculator.add(10, 50);

        assertEquals(60, result, 0);
    }
}