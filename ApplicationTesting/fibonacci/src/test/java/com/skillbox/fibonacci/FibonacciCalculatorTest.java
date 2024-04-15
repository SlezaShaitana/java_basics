package com.skillbox.fibonacci;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FibonacciCalculatorTest {

    private FibonacciCalculator calculator;

    @BeforeEach
    public void setUpp() {
        calculator = new FibonacciCalculator();
    }

    @ParameterizedTest
    @ValueSource(ints = {10})
    @DisplayName("По индексу возвращается число соответсвующее ожидаемому")
    public void givenIndex_whenGetFibonacciNumber_thenCorrespondingValue(int index) {
        int fibonachi = calculator.getFibonacciNumber(index);
        assertEquals(55, fibonachi);
    }

    @Test
    @DisplayName("Если передан индекс меньше 1, выбрасывается исключение")
    public void givenIndexLessThanOne_whenGetFibonacciNumber_thenIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> calculator.getFibonacciNumber(-1));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2})
    @DisplayName("Для порядковых номеров 1 и 2 калькулятор возвращает значение 1")
    public void givenIndexOneOrTwo_whenGetFibonacci_thenValueOne(int index) {
        int fibonachi = calculator.getFibonacciNumber(index);
        assertEquals(1, fibonachi);
    }
}