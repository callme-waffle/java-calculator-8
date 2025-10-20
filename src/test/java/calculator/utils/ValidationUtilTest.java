package calculator.utils;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import calculator.exceptions.CustomSplitterDefinitionBeStartedWithDoubleSlash;
import calculator.exceptions.CustomSplitterDefinitionNotBeContainsNumber;
import calculator.exceptions.DetectionStringNotBeEndedByNumberException;
import calculator.exceptions.DetectionStringNotBeStartedByNumberException;
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
			.isInstanceOf(DetectionStringNotBeStartedByNumberException.class);
	}

	@Test
	void checkInputEndValidate() {
		assertThatThrownBy(() -> ValidationUtil.checkInputValidate("1,2,3,4,"))
			.isInstanceOf(DetectionStringNotBeEndedByNumberException.class);
	}

	@Test
	void checkCustomSplitterDefinitionStartsWithDoubleSlashValidate() {
		assertThatThrownBy(() -> ValidationUtil.checkInputValidate(";'\\n1,2,3,4,"))
			.isInstanceOf(CustomSplitterDefinitionBeStartedWithDoubleSlash.class);
	}

	@Test
	void checkCustomSplitterDefinitionNotContainsNumberValidate() {
		assertThatThrownBy(() -> ValidationUtil.checkInputValidate("//123\\n1,2,3,4"))
			.isInstanceOf(CustomSplitterDefinitionNotBeContainsNumber.class);
	}

}
