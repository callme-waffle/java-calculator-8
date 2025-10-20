package calculator.functions;

import java.util.List;

public interface CalculatorFunctionPort {
	void detectNumbers(String str);

	List<Integer> getNumbers();
}
