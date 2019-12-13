package service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConsoleServiceTest {
    ConsoleService consoleService = new ConsoleService();

    @Test
    @DisplayName("Округление целого числа")
    void printInteger() {
        assertDoesNotThrow(() -> consoleService.writeAnswer("1.3 + 1.7",3.0));
    }

    @Test
    @DisplayName("Не точный ответ")
    void printNotAccurateAnswer() {
        assertDoesNotThrow(() -> consoleService.writeAnswer("0.1 + 0.2",0.3000000000004));
    }

    @Test
    @DisplayName("Число в периоде")
    void printNumberInPeriod() {
        assertDoesNotThrow(() -> consoleService.writeAnswer("10 / 1.5",6.66666666666666666666666666));
    }
}