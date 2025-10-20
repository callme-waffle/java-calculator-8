package calculator.exceptions;

import static calculator.constants.ExceptionMessage.*;

public class DetectionStringNotBeStartedByNumberException extends IllegalArgumentException {
	public DetectionStringNotBeStartedByNumberException() {
		super(DETECTING_STRING_MUST_BE_STARTED_BY_NUMBER);
	}

	public DetectionStringNotBeStartedByNumberException(String message) {
		super(message);
	}
}
