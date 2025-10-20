package calculator.exceptions;

import static calculator.constants.ExceptionMessage.*;

public class CustomSplitterDefinitionBeStartedWithDoubleSlash extends IllegalArgumentException {
	public CustomSplitterDefinitionBeStartedWithDoubleSlash() {
		super(CUSTOM_SPLITTER_DEFINITION_MUST_BE_STARTED_DOUBLE_SLASH);
	}

	public CustomSplitterDefinitionBeStartedWithDoubleSlash(String message) {
		super(message);
	}
}
