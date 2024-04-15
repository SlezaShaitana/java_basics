package com.skillbox.fibonacci;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class FibonacciServiceTest {
    private final FibonacciRepository repository = Mockito.mock(FibonacciRepository.class);
    private final FibonacciCalculator calculator = Mockito.mock(FibonacciCalculator.class);
    private final FibonacciService service = new FibonacciService(repository, calculator);

    @Test
    @DisplayName("Число Фибоначчи берется из базы данных")
    public void givenExistingIndex_whenFibonacciNumber_thenNumberFromDatabase() {
        int index = 10;
        int value = 55;
        FibonacciNumber fibonacciNumber = new FibonacciNumber(index, value);
        fibonacciNumber.setId(1);
        when(repository.findByIndex(index)).thenReturn(Optional.of(fibonacciNumber));
        Optional<FibonacciNumber> optional = repository.findByIndex(index);
        assertEquals(optional, Optional.of(fibonacciNumber));
        verify(repository, times(1)).findByIndex(index);
        verify(repository, never()).save(any(FibonacciNumber.class));
        verify(calculator, never()).getFibonacciNumber(index);
    }

    @Test
    @DisplayName("Новые числа Фибоначчи рассчитываются и сохраняются")
    public void givenNewIndex_whenFibonacciNumber_thenNumberCalculatedAndSaved() {
        int index = 10;
        FibonacciNumber fibonacciNumber = new FibonacciNumber(index, 55);
        fibonacciNumber.setId(1);
        when(repository.findByIndex(index)).thenReturn(Optional.empty());
        when(calculator.getFibonacciNumber(index)).thenReturn(55);
        int value = service.fibonacciNumber(10).getValue();
        assertEquals(55, value);
        verify(calculator, times(1)).getFibonacciNumber(index);
        verify(repository, times(1)).save(any(FibonacciNumber.class));
    }

    @Test
    @DisplayName("Возвращается исключение, если переданный индекс меньше 1")
    public void givenIndexLessThanOne_whenFibonacciNumber_thenIllegalArgumentException() {
        int index = -1;
        boolean exceptionThrow = false;

        try {
            service.fibonacciNumber(index);
        } catch (IllegalArgumentException e) {
            exceptionThrow = true;
        }
        assertTrue(exceptionThrow);
    }
}
