package calculator.exceptions;

import static calculator.constants.ExceptionMessage.*;

public class DetectionStringNotBeEndedByNumberException extends IllegalArgumentException {
	public DetectionStringNotBeEndedByNumberException() {
		super(DETECTING_STRING_MUST_BE_ENDED_BY_NUMBER);
	}

	public DetectionStringNotBeEndedByNumberException(String message) {
		super(message);
	}
}
