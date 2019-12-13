package service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculationServiceTest {
    CalculationService calculationService = new CalculationService();

    @Test
    @DisplayName("Целые числа")
    void calculateResultWithIntegers() {
        assertEquals(-16 ,calculationService.getAnswer(new String[]{"3", "8", "*", "4", "2", "/",
                                                                             "7", "6", "*", "1", "/", "-", "+"}));
    }

    @Test
    @DisplayName("Дробные числа")
    void calculateResultWithDoubles() {
        assertEquals(2.7 ,calculationService.getAnswer(new String[]{"3.6", "3", "/", "1.5", "+"}));
    }

    @Test
    @DisplayName("Деление на 0")
    void divideByZero() {
        try {
            calculationService.getAnswer(new String[]{"5", "0", "/",});
        } catch (Exception e) {
            assertEquals(e.getMessage(),"\n\nНа ноль делить нельзя!\n");
        }
    }
}