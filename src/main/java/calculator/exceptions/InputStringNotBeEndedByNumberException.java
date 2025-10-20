package calculator.exceptions;

import static calculator.constants.ExceptionMessage.*;

public class InputStringNotBeEndedByNumberException extends RuntimeException {
	public InputStringNotBeEndedByNumberException() {
		super(INPUT_MUST_BE_ENDED_BY_NUMBER);
	}

	public InputStringNotBeEndedByNumberException(String message) {
		super(message);
	}
}
