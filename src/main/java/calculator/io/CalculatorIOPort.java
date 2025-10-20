package calculator.io;

public interface CalculatorIOPort {
	void printNoticeMsg();

	String getInputString();

	void printResult(int result);
}
