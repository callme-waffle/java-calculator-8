package calculator.functions;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorFunctionAdapterTest {

	CalculatorFunctionAdapter calc;

	@BeforeEach
	void setUp() {
		this.calc = new CalculatorFunctionAdapter();
	}

	@Test
	void detectNumbersTrueCase1() {
		calc.detectNumbers("1,2,3,4,5");
		assertThat(calc.getNumbers()).isEqualTo(List.of(1, 2, 3, 4, 5));
	}

	@Test
	void detectNumbersTrueCase2() {
		calc.detectNumbers("1:2:3:4:5");
		assertThat(calc.getNumbers()).isEqualTo(List.of(1, 2, 3, 4, 5));
	}

	@Test
	void detectNumbersTrueCase3() {
		calc.detectNumbers("1:2,3:4,5");
		assertThat(calc.getNumbers()).isEqualTo(List.of(1, 2, 3, 4, 5));
	}

	@Test
	void detectNumbersFalseCase1() {
		assertThatThrownBy(() -> calc.detectNumbers("1,2,3,4,"))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void detectNumbersFalseCase2() {
		assertThatThrownBy(() -> calc.detectNumbers("1,2,3,4,,5"))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void detectNumbersFalseCase3() {
		assertThatThrownBy(() -> calc.detectNumbers(",,1,2,3,4,5"))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void applyCustomSplitterTrueCase1() {
		calc.applyCustomSplitter(";");
		calc.detectNumbers("1;2:3;4:5");
		assertThat(calc.getNumbers()).isEqualTo(List.of(1, 2, 3, 4, 5));
	}

	@Test
	void applyCustomSplitterTrueCase2() {
		calc.applyCustomSplitter("_");
		calc.detectNumbers("1_2_3_4_5");
		assertThat(calc.getNumbers()).isEqualTo(List.of(1, 2, 3, 4, 5));
	}

	@Test
	void applyCustomSplitterTrueCase3() {
		calc.applyCustomSplitter("'");
		calc.detectNumbers("1'2:3,4:5");
		assertThat(calc.getNumbers()).isEqualTo(List.of(1, 2, 3, 4, 5));
	}

	@Test
	void applyCustomSplitterFalseCase1() {
		assertThatThrownBy(() -> calc.detectNumbers("1_2,3,4,"))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void mountStringTrueCase1() {
		calc.mountString("1,2,3,4,5");
		assertThat(calc.getNumbers()).isEqualTo(List.of(1, 2, 3, 4, 5));
	}

	@Test
	void mountStringTrueCase2() {
		calc.mountString("//;\\n1;2:3:4:5");
		assertThat(calc.getNumbers()).isEqualTo(List.of(1, 2, 3, 4, 5));
	}

	@Test
	void mountStringFalseCase1() {
		assertThatThrownBy(() -> calc.mountString("1,2,3,4,"))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void mountStringFalseCase2() {
		assertThatThrownBy(() -> calc.mountString("1,2,3,4,,5"))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void mountStringFalseCase3() {
		assertThatThrownBy(() -> calc.mountString(",,1,2,3,4,5"))
			.isInstanceOf(IllegalArgumentException.class);
	}
}
