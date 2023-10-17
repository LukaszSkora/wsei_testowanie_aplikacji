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


}