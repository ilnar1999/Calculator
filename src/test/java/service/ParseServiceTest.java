package service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParseServiceTest {
    ParseService parseService = new ParseService();

    @Test
    @DisplayName("Разбор выражения со сложением и вычитанием")
    void parseExpressionWithAdditionAndSubtraction() {
        assertArrayEquals(new String[]{"1","7","+","2","-"},
                parseService.parseExpression(new String[]{"1", "+", "7", "-", "2"}));
    }

    @Test
    @DisplayName("Разбор выражения с умножением и делением")
    void parseExpressionWithMultiplicationAndDivision() {
        assertArrayEquals(new String[]{"4","5","*","0","/"},
                parseService.parseExpression(new String[]{"4", "*", "5", "/", "0"}));
    }

    @Test
    @DisplayName("Разбор сложного выражения")
    void parseComplexExpression() {
        assertArrayEquals(new String[]{"3", "8", "*", "4", "2", "/", "7", "6", "*", "1", "/", "-", "+"},
                parseService.parseExpression(new String[]{"3", "*", "8", "+", "4", "/", "2", "-", "7", "*", "6",
                                                          "/", "1"}));
    }
}