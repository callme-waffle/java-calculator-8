package calculator.functions;

import java.util.List;

public interface CalculatorFunctionPort {
	void mountString(String input);

	List<Integer> getNumbers();

	int getResults();
}
