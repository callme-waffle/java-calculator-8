package calculator.utils;

public class FunctionUtil {
	public static boolean isCustomSplitterDefinitionFormatDetected(String input) {
		return input.contains("\\n");
	}

	public static Integer extractNumberFromRange(String str, int si) {
		return extractNumberFromRange(str, si, str.length());
	}

	public static Integer extractNumberFromRange(String str, int si, int i) {
		String numberStr = str.substring(si, i);
		return Integer.parseInt(numberStr);
	}
}
