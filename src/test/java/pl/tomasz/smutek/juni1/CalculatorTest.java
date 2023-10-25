package pl.tomasz.smutek.juni1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("Odejmowanie")
    void deduct() {
        assertEquals(2, calculator.deduct(4, 2));
        assertEquals(5, calculator.deduct(10, 5));
        assertEquals(2, calculator.deduct(14, 12));
    }

    @Test
    @DisplayName("Dzielenie")
    void divide() {
        assertEquals(10, calculator.divide(30,3));
        assertEquals(0, calculator.divide(0,3));
        assertEquals(2.5, calculator.divide(50,20));

        assertThrows(IllegalArgumentException.class, () -> calculator.divide(4, 0));
    }
}