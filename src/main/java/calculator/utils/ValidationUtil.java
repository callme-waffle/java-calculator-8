package calculator.utils;

import calculator.exceptions.CustomSplitterDefinitionBeStartedWithDoubleSlash;
import calculator.exceptions.CustomSplitterDefinitionNotBeContainsNumber;
import calculator.exceptions.DetectionStringNotBeEndedByNumberException;
import calculator.exceptions.DetectionStringNotBeStartedByNumberException;
import calculator.exceptions.SpecialCharacterAppearedTwiceException;

public class ValidationUtil {
	public static void checkInputValidate(String input) throws IllegalArgumentException {
		String customSplitterDefinition = null;
		if (FunctionUtil.isCustomSplitterDefinitionFormatDetected(input)) {
			String[] splittedInput = input.split("\\\\n", 2);
			customSplitterDefinition = splittedInput[0];
			input = splittedInput[1];
		}

		checkCustomSplitterDefinitionValidate(customSplitterDefinition);
		checkDetectionStringSectionValidate(input);
	}

	private static void checkCustomSplitterDefinitionValidate(String customSplitterDefinition) {
		if (customSplitterDefinition == null) return;

		checkCustomSplitterDefinitionStartsWithDoubleSlash(customSplitterDefinition);
		checkCustomSplitterDefinitionNotContainsNumber(customSplitterDefinition);
	}

	private static void checkCustomSplitterDefinitionNotContainsNumber(String customSplitterDefinition) {
		if (customSplitterDefinition.chars().anyMatch(Character::isDigit)) {
			throw new CustomSplitterDefinitionNotBeContainsNumber();
		}
	}

	private static void checkCustomSplitterDefinitionStartsWithDoubleSlash(String customSplitterDefinition) {
		if (!customSplitterDefinition.startsWith("//")) {
			throw new CustomSplitterDefinitionBeStartedWithDoubleSlash();
		}
	}

	private static void checkDetectionStringSectionValidate(String input) {
		checkDetectingStringStartsWithNumber(input);
		checkDetectingStringEndedWithNumber(input);
		checkSpecialCharacterAppearEach(input);
	}

	private static void checkSpecialCharacterAppearEach(String input) {
		int recentIndex = -1;
		for (int i = 0; i < input.length(); i++) {
			char character = input.charAt(i);
			if (isCharacterNumber(character)) continue;

			if (i-recentIndex == 1) {
				throw new SpecialCharacterAppearedTwiceException();
			}
			recentIndex = i;
		}
	}

	private static void checkDetectingStringStartsWithNumber(String input) {
		char character = input.charAt(0);
		if (isCharacterNumber(character)) return;
		throw new DetectionStringNotBeStartedByNumberException();
	}

	private static void checkDetectingStringEndedWithNumber(String input) {
		char character = input.charAt(input.length()-1);
		if (isCharacterNumber(character)) return;
		throw new DetectionStringNotBeEndedByNumberException();
	}

	private static boolean isCharacterNumber(char character) {
		return character >= '0' && character <= '9';
	}
}
