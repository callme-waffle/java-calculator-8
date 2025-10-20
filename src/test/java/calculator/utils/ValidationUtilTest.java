package calculator.utils;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import calculator.exceptions.InputStringNotBeEndedByNumberException;
import calculator.exceptions.InputStringNotBeStartedByNumberException;
import calculator.exceptions.SpecialCharacterAppearedTwiceException;

class ValidationUtilTest {

	@Test
	void checkSpecialCharacterLocateTwiceValidate() {
		assertThatThrownBy(() -> ValidationUtil.checkInputValidate("1,,2,3,4"))
			.isInstanceOf(SpecialCharacterAppearedTwiceException.class);
	}

	@Test
	void checkInputStartValidate() {
		assertThatThrownBy(() -> ValidationUtil.checkInputValidate(",1,2,3,4"))
			.isInstanceOf(InputStringNotBeStartedByNumberException.class);
	}

	@Test
	void checkInputEndValidate() {
		assertThatThrownBy(() -> ValidationUtil.checkInputValidate("1,2,3,4,"))
			.isInstanceOf(InputStringNotBeEndedByNumberException.class);
	}
}
