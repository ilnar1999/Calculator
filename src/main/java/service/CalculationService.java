package service;

import java.util.Queue;
import java.util.Stack;

public class CalculationService {
    public double getAnswer(Queue<String> elementsAsQueue) {
        Stack<Double> elementsAsStack = new Stack<Double>();
        String currentElement;
        double firstOperand;
        double secondOperand;

        while (!elementsAsQueue.isEmpty()) {
            currentElement = elementsAsQueue.poll();
            try {
                Double.parseDouble(currentElement);
                elementsAsStack.push(Double.parseDouble(currentElement));
            } catch (NumberFormatException e) {
                secondOperand = elementsAsStack.pop();
                firstOperand = elementsAsStack.pop();
                if (currentElement.equals("+")) {
                    elementsAsStack.push(firstOperand + secondOperand);
                } else if (currentElement.equals("-")) {
                    elementsAsStack.push(firstOperand - secondOperand);
                } else if (currentElement.equals("*")) {
                    elementsAsStack.push(firstOperand * secondOperand);
                } else {
                    if (secondOperand == 0) {
                        throw new IllegalArgumentException("\n\nНа ноль делить нельзя!\n");
                    }
                    elementsAsStack.push(firstOperand / secondOperand);
                }
            }
        }
        return elementsAsStack.pop();
    }
}
