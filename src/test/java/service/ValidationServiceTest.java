package service;

import exception.EmptyExpressionException;
import exception.NotCorrectSymbolException;
import exception.UnknownExpressionException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidationServiceTest {
    ValidationService validationService = new ValidationService();

    @Test
    @DisplayName("Ввод корректного выражения")
    void enterCorrectExpression() {
        assertDoesNotThrow(() -> validationService.useAllValidations("10 + 3 - 12 / 4"));
    }

    @Test
    @DisplayName("Ввод пустой строки")
    void enterEmptyString() {
        assertThrows(EmptyExpressionException.class, () -> validationService.useAllValidations(""));
    }

    @Test
    @DisplayName("Ввод строки из пробелов")
    void enterStringWithSpaces() {
        assertThrows(EmptyExpressionException.class, () -> validationService.useAllValidations("       "));
    }

    @Test
    @DisplayName("Ввод выражения с посторонними символами")
    void enterNotCorrectSymbols() {
        assertThrows(NotCorrectSymbolException.class, () -> validationService.useAllValidations("22,8 - 10,3"));
    }

    @Test
    @DisplayName("Ввод выражения с двумя числами подряд")
    void enterTwoNumbersConsecutively() throws NotCorrectSymbolException, EmptyExpressionException {
        try {
            validationService.useAllValidations("10 11 + 3");
        } catch (UnknownExpressionException e) {
            assertEquals(e.getMessage(),"\n\nВ выражении не должно быть подряд идущих чисел " +
                    "или арифметических операций!\n");
        }
    }

    @Test
    @DisplayName("Ввод выражения без разделения элементов")
    void enterExpressionWithoutDelimiters123() throws NotCorrectSymbolException, EmptyExpressionException {
        try {
            validationService.useAllValidations("18-13 + 6");
        } catch (UnknownExpressionException e) {
            assertEquals(e.getMessage(),"\n\nВыражение содержит некорректные числа или арифметические операции! " +
                    "Убедитесь, что числа и арифметические операции разделены пробелами!\n");
        }

    }

    @Test
    @DisplayName("Ввод выражения с арифметической операцией вначале")
    void enterExpressionWithArithmeticOperationAtBeginning() throws NotCorrectSymbolException, EmptyExpressionException {
        try {
            validationService.useAllValidations("- 3 + 0");
        } catch (UnknownExpressionException e) {
            assertEquals(e.getMessage(),"\n\nАрифметические операции не могут быть расположены в начале " +
                    "или в конце выражения!\n");
        }
    }

    @Test
    @DisplayName("Ввод выражения с арифметической операцией вначале")
    void enterExpressionWithArithmeticOperationAtEnd() throws NotCorrectSymbolException, EmptyExpressionException {
        try {
            validationService.useAllValidations("3 + 0 +");
        } catch (UnknownExpressionException e) {
            assertEquals(e.getMessage(),"\n\nАрифметические операции не могут быть расположены в начале " +
                    "или в конце выражения!\n");
        }
    }
}