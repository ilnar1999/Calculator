package service;

import java.util.Scanner;

public class ConsoleService {
    public String getExpression() {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите выражение: ");
        return in.nextLine();
    }

    public void writeAnswer(String expression, double answer) {
        answer = (Math.round(answer * 100000000)) / 100000000.0;
        if (answer % 1 == 0) {
            System.out.println(expression + " = " + (int)answer);
        } else {
            System.out.println(expression + " = " + answer);
        }
    }
}
