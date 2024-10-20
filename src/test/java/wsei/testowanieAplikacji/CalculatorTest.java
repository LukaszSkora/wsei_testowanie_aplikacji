package wsei.testowanieAplikacji;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @BeforeAll
    static void cos() {
        System.out.println("coś BeforeAll");
    }

    @Test
    @DisplayName("Odejmowanie")
    void deductTest() {
        assertEquals(2, calculator.deduct(4, 2));
        assertEquals(5, calculator.deduct(10, 5));
        assertEquals(2, calculator.deduct(14, 12));
    }

    @Test
    @DisplayName("Dzielenie")
    void divideTest() {
        assertEquals(10, calculator.divide(30,3));
        assertEquals(0, calculator.divide(0,3));
        assertEquals(2.5, calculator.divide(50,20));

        assertThrows(IllegalArgumentException.class, () -> calculator.divide(4, 0));
    }

    @Test
    @DisplayName("Dodawanie")
//    @Disabled
//    void add() {
//        assertEquals(10, calculator.add(1, 9));
//        assertEquals(-10, calculator.add(0.1, -10.1));
//        assertEquals(-0.1, calculator.add(0, -0.1));
//    }
    void addTest() {
        assertAll(
                () -> {
                    assertEquals(10, calculator.add(1, 9));
                },
                () -> {
                    assertEquals(-10, calculator.add(0.1, -10.1));
                },
                () -> {
                    assertEquals(-0.1, calculator.add(0, -0.1));
                }
        );
    }

    @Test
    @DisplayName("Mnożenie")
    void multiplyTest() {
        assertEquals(0.05, calculator.multiply(0.5, 0.1));
        assertEquals(-0.0, calculator.multiply(0, -10.1));
        assertEquals(0.2, calculator.multiply(-2, -0.1));
    }

    @Test
    @DisplayName("Pierwiastek kwadratowy")
    void squareRootTest() {
        assertEquals(0, calculator.squareRoot(0));
        assertEquals(2, calculator.squareRoot(4));
        assertEquals(0.5, calculator.squareRoot(0.25));
    }

    @Test
    @DisplayName("Pierwiastek sześcienny")
    void cubeRootTest() {
        assertEquals(-0.0, calculator.cubeRoot(-0.0));
        assertEquals(4, calculator.cubeRoot(64));
        assertEquals(-3, calculator.cubeRoot(-27));
    }
}