package service;

import java.util.Stack;

public class ParseService {
    public String[] parseExpression(String[] elements) {
        int position = 0;
        Stack<String> arithmeticOperations = new Stack<>();
        String[] elementsInReversPolishNotation = new String[elements.length];
        for (String element: elements) {
            try {
                Double.parseDouble(element);
                elementsInReversPolishNotation[position++] = element;
            } catch (NumberFormatException e) {
                if (arithmeticOperations.isEmpty()) {
                    arithmeticOperations.push(element);
                } else if (hasHigherPriority(arithmeticOperations.peek(),element)){
                    arithmeticOperations.push(element);
                } else {
                    elementsInReversPolishNotation[position++] = (arithmeticOperations.pop());
                    arithmeticOperations.push(element);
                }
            }
        }
        while (!arithmeticOperations.isEmpty()) {
            elementsInReversPolishNotation[position++] = arithmeticOperations.pop();
        }
        return elementsInReversPolishNotation;
    }

    private boolean hasHigherPriority(String elementInStack, String currentElement) {
        if (elementInStack.equals("*") || elementInStack.equals("/")) {
            return false;
        } else {
            return currentElement.equals("*") || currentElement.equals("/");
        }
    }
}
