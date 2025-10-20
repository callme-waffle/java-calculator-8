package calculator;

import calculator.io.CalculatorIOAdapter;
import calculator.io.CalculatorIOPort;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        CalculatorIOPort io = new CalculatorIOAdapter();
        io.printNoticeMsg();

        String input = io.getInputString();
    }
}
