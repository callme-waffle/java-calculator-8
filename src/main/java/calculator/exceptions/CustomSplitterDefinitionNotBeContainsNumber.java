package calculator.exceptions;

import static calculator.constants.ExceptionMessage.*;

public class CustomSplitterDefinitionNotBeContainsNumber extends IllegalArgumentException {
	public CustomSplitterDefinitionNotBeContainsNumber() {
		super(CUSTOM_SPLITTER_DEFINITION_MUST_NOT_BE_CONTAINED_NUMBER);
	}

	public CustomSplitterDefinitionNotBeContainsNumber(String message) {
		super(message);
	}
}
