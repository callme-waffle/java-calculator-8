package calculator.io;

import camp.nextstep.edu.missionutils.Console;

public class CalculatorIOAdapter implements CalculatorIOPort {
	public void printNoticeMsg() {
		System.out.println("덧셈할 문자열을 입력해 주세요.");
	}

	public String getInputString() {
		return Console.readLine();
	}

	@Override
	public void printResult(int result) {
		System.out.printf("결과 : %d\n", result);
	}
}
