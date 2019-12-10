import exception.EmptyExpressionException;
import exception.NotCorrectSymbolException;
import exception.UnknownExpressionException;
import service.CalculationService;
import service.ConsoleService;
import service.ParseService;
import service.ValidationService;

public class Main {
    public static void main(String[] args) throws NotCorrectSymbolException, UnknownExpressionException, EmptyExpressionException {
        ConsoleService consoleService = new ConsoleService();
        ValidationService validationService = new ValidationService();
        ParseService parseService = new ParseService();
        CalculationService calculationService = new CalculationService();
        String expression;
        String[] expressionElements;

        expression = consoleService.getExpression();
        expressionElements = validationService.useAllValidations(expression);
        consoleService.writeAnswer(expression,
                                   calculationService.getAnswer(parseService.parseExpression(expressionElements)));
    }
}
