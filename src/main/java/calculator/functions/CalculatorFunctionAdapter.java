package calculator.functions;

import java.util.ArrayList;
import java.util.List;

public class CalculatorFunctionAdapter implements CalculatorFunctionPort {

	private final List<Integer> numbers;

	public CalculatorFunctionAdapter() {
		this.numbers = new ArrayList<>();
	}

	@Override
	public void detectNumbers(String str) {
		int si = 0;
		for (int i = 0; i < str.length(); i++) {
			if (!isCharSplitter(str, i)) continue;

			Integer number = extractNumberFromRange(str, si, i);
			numbers.add(number);
			
			si = i+1;
		}

		Integer number = extractNumberFromRange(str, si);
		numbers.add(number);
	}

	@Override
	public List<Integer> getNumbers() {
		return this.numbers;
	}

	private static Integer extractNumberFromRange(String str, int si) {
		return extractNumberFromRange(str, si, str.length());
	}

	private static Integer extractNumberFromRange(String str, int si, int i) {
		String numberStr = str.substring(si, i);
		return Integer.parseInt(numberStr);
	}

	private static boolean isCharSplitter(String checkString, int location) {
		char checkChar = checkString.charAt(location);
		return checkChar == ',' || checkChar == ':';
	}
}
