package service;

import exception.EmptyExpressionException;
import exception.NotCorrectSymbolException;
import exception.UnknownExpressionException;

public class ValidationService {
    public String[] useAllValidations(String expression) throws NotCorrectSymbolException, UnknownExpressionException, EmptyExpressionException {
        if (expression.trim().equals("")) {
            throw new EmptyExpressionException("\n\nВведена пустая строка!\n");
        }
        String[] elements = splitString(expression.trim());
        if (hasUnknownSymbol(expression)) {
            System.out.println(elements.length);
            throw new NotCorrectSymbolException("\n\nВыражение содержит недопустимые символы!\n");
        } else if (!hasOnlyNumbersAndArithmeticOperations(elements)) {
            throw new UnknownExpressionException("\n\nВыражение содержит некорректные числа или арифметические операции! " +
                    "Убедитесь, что числа и арифметические операции разделены пробелами!\n");
        } else if (hasArithmeticOperationInFirstOrLastPosition(elements)) {
            throw new UnknownExpressionException("\n\nАрифметические операции не могут быть расположены в начале " +
                    "или в конце выражения!\n");
        } else if (hasSeveralNumbersOrArithmeticOperationsConsecutively(elements)) {
            throw new UnknownExpressionException("\n\nВ выражении не должно быть подряд идущих чисел " +
                    "или арифметических операций!\n");
        }
        return elements;
    }

    private boolean hasUnknownSymbol(String expression) {
        return !expression.matches("[\\d\\s\\Q-+/*.\\E]+") ? true : false;
    }

    private String[] splitString(String expression) {
        String[] elements = expression.split(" +");
        return elements;
    }

    private boolean hasOnlyNumbersAndArithmeticOperations(String[] elements) {
        for (String element: elements) {
            if (!element.equals("+") && !element.equals("-") && !element.equals("*") && !element.equals("/") ) {
                try {
                    Double.parseDouble(element);
                } catch (NumberFormatException e) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean hasArithmeticOperationInFirstOrLastPosition(String[] elements) {
        try {
            Double.parseDouble(elements[0]);
            Double.parseDouble(elements[elements.length - 1]);
            return false;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    private boolean hasSeveralNumbersOrArithmeticOperationsConsecutively(String[] elements) {
        boolean previousIsNumber = false;
        for (String element : elements) {
            if ((element.equals("+") || element.equals("-") || element.equals("*") || element.equals("/"))
                                                                                   && !previousIsNumber) {
                return true;
            }
            if ((!element.equals("+") && !element.equals("-") && !element.equals("*") && !element.equals("/"))
                                                                                      && previousIsNumber) {
                return true;
            }
            previousIsNumber = !previousIsNumber;
        }
        return false;
    }
}