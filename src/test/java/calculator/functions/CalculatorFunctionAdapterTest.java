package calculator.functions;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorFunctionAdapterTest {

	CalculatorFunctionPort calc;

	@BeforeEach
	void setUp() {
		this.calc = new CalculatorFunctionAdapter();
	}

	@Test
	void detectNumbersFromRangeTrueCase1() {
		calc.detectNumbers("1,2,3,4,5");
		assertThat(calc.getNumbers()).isEqualTo(List.of(1, 2, 3, 4, 5));
	}

	@Test
	void detectNumbersFromRangeTrueCase2() {
		calc.detectNumbers("1:2:3:4:5");
		assertThat(calc.getNumbers()).isEqualTo(List.of(1, 2, 3, 4, 5));
	}

	@Test
	void detectNumbersFromRangeTrueCase3() {
		calc.detectNumbers("1:2,3:4,5");
		assertThat(calc.getNumbers()).isEqualTo(List.of(1, 2, 3, 4, 5));
	}

	@Test
	void detectNumbersFromRangeFalseCase1() {
		assertThatThrownBy(() -> calc.detectNumbers("1,2,3,4,"))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void detectNumbersFromRangeFalseCase2() {
		assertThatThrownBy(() -> calc.detectNumbers("1,2,3,4,,5"))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void detectNumbersFromRangeFalseCase3() {
		assertThatThrownBy(() -> calc.detectNumbers(",,1,2,3,4,5"))
			.isInstanceOf(IllegalArgumentException.class);
	}
}
