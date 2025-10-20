package calculator.exceptions;

import static calculator.constants.ExceptionMessage.*;

public class InputStringNotBeStartedByNumberException extends RuntimeException {
	public InputStringNotBeStartedByNumberException() {
		super(INPUT_MUST_BE_STARTED_BY_NUMBER);
	}

	public InputStringNotBeStartedByNumberException(String message) {
		super(message);
	}
}
