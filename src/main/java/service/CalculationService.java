package service;

import java.util.Stack;

public class CalculationService {
    public double getAnswer(String[] elementsAsArray) {
        Stack<Double> elementsAsStack = new Stack<>();
        String currentElement;
        double firstOperand;
        double secondOperand;

        for (String element: elementsAsArray){
            currentElement = element;
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
