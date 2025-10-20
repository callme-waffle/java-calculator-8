package calculator;

import calculator.functions.CalculatorFunctionAdapter;
import calculator.functions.CalculatorFunctionPort;
import calculator.io.CalculatorIOAdapter;
import calculator.io.CalculatorIOPort;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        CalculatorIOPort calcIo = new CalculatorIOAdapter();
        CalculatorFunctionPort calcFunction = new CalculatorFunctionAdapter();
        calcIo.printNoticeMsg();

        String input = calcIo.getInputString();
        calcFunction.mountString(input);

        calcIo.printResult(calcFunction.getResults());
    }
}
