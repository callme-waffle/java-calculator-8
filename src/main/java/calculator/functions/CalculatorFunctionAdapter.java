package calculator.functions;

import static calculator.utils.FunctionUtil.*;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CalculatorFunctionAdapter implements CalculatorFunctionPort {

	private final Set<Character> splitters;
	private final List<Integer> numbers;

	public CalculatorFunctionAdapter() {
		this.numbers = new ArrayList<>();
		this.splitters = new HashSet<>();
		splitters.add(',');
		splitters.add(':');
	}

	@Override
	public void mountString(String input) {
		String[] splittedInputString = splitInputSections(input);
		if (splittedInputString[0] != null) applyCustomSplitter(splittedInputString[0]);
		detectNumbers(splittedInputString[1]);
	}

	private String[] splitInputSections(String input) {
		String customSplitterSection = null;
		if (isCustomSplitterDefinitionFormatDetected(input)) {
			String[] splittedInput = input.split("\\\\n", 2);
			customSplitterSection = splittedInput[0].substring(2);
			input = splittedInput[1];
		}

		return new String[] {customSplitterSection, input};
	}

	protected void applyCustomSplitter(String customSplitters) {
		for (int i = 0; i < customSplitters.length(); i++) {
			this.splitters.add(customSplitters.charAt(i));
		}
	}

	protected void detectNumbers(String checkString) {
		int si = 0;
		for (int i = 0; i < checkString.length(); i++) {
			if (!isCharSplitter(checkString, i)) continue;

			Integer number = extractNumberFromRange(checkString, si, i);
			numbers.add(number);
			
			si = i+1;
		}

		Integer number = extractNumberFromRange(checkString, si);
		numbers.add(number);
	}

	@Override
	public List<Integer> getNumbers() {
		return this.numbers;
	}

	private boolean isCharSplitter(String checkString, int location) {
		char checkChar = checkString.charAt(location);
		return this.splitters.contains(checkChar);
	}
}
