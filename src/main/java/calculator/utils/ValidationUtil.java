package calculator.utils;

import calculator.exceptions.InputStringNotBeEndedByNumberException;
import calculator.exceptions.InputStringNotBeStartedByNumberException;
import calculator.exceptions.SpecialCharacterAppearedTwiceException;

public class ValidationUtil {
	public static void checkInputValidate(String input) throws IllegalArgumentException {
		checkIsInputNotBeStartedWithNumber(input);
		checkIsInputNotBeEndedWithNumber(input);
		checkIsSpecialCharacterAppearEach(input);
	}

	private static void checkIsSpecialCharacterAppearEach(String input) {
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

	private static void checkIsInputNotBeStartedWithNumber(String input) {
		char character = input.charAt(0);
		if (isCharacterNumber(character)) return;
		throw new InputStringNotBeStartedByNumberException();
	}

	private static void checkIsInputNotBeEndedWithNumber(String input) {
		char character = input.charAt(input.length()-1);
		if (isCharacterNumber(character)) return;
		throw new InputStringNotBeEndedByNumberException();
	}

	private static boolean isCharacterNumber(char character) {
		return character >= '0' && character <= '9';
	}
}
