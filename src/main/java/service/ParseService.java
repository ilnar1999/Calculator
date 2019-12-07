package service;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ParseService {
    public Queue<String> parseExpression(String[] elements) {
        Stack<String> arithmeticOperations = new Stack<String>();
        Queue<String> elementsInReversPolishNotation = new LinkedList<String>();
        for (String element: elements) {
            try {
                Double.parseDouble(element);
                elementsInReversPolishNotation.offer(element);
            } catch (NumberFormatException e) {
                if (arithmeticOperations.isEmpty()) {
                    arithmeticOperations.push(element);
                } else if (hasHigherPriority(arithmeticOperations.peek(),element)){
                    arithmeticOperations.push(element);
                } else {
                    elementsInReversPolishNotation.offer(arithmeticOperations.pop());
                    arithmeticOperations.push(element);
                }
            }
        }
        while (!arithmeticOperations.isEmpty()) {
            elementsInReversPolishNotation.offer(arithmeticOperations.pop());
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
