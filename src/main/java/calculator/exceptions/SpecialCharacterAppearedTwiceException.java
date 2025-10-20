package calculator.exceptions;

import static calculator.constants.ExceptionMessage.*;

public class SpecialCharacterAppearedTwiceException extends IllegalArgumentException {
	public SpecialCharacterAppearedTwiceException() {
		super(SPECIAL_CHARACTER_APPEARED_TWICE);
	}

	public SpecialCharacterAppearedTwiceException(String message) {
		super(message);
	}
}
