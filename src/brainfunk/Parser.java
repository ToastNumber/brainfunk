package brainfunk;

import java.util.Stack;

public class Parser {
	public static void validate(String code) throws Exception {
		// Find invalid characters
		CodeCharacter[] codeCharacters = Labeller.label(code);
		for (int i = 0; i < codeCharacters.length; ++i) {
			if (!",.+-><[] \n\t\r".contains("" + codeCharacters[i].character())) { throw new Exception(String.format(
					"Invalid character found - line:%d, col:%d", codeCharacters[i].line(), codeCharacters[i].col())); }
		}

		// Check for mismatched brackets
		Stack<CodeCharacter> bracketStack = new Stack<>();
		for (int i = 0; i < codeCharacters.length; ++i) {
			if (codeCharacters[i].character() == '[') bracketStack.add(codeCharacters[i]);
			else if (codeCharacters[i].character() == ']') {
				if (bracketStack.isEmpty()) {
					throw new Exception(String.format("No matching opening bracket found - line:%d, col:%d",
							codeCharacters[i].line(), codeCharacters[i].col()));
				} else {
					bracketStack.pop();
				}
			}
		}

		if (bracketStack.size() > 0) {
			CodeCharacter c = bracketStack.pop();
			int line = c.line();
			int col = c.col();
			throw new Exception(String.format("Bracket not closed - line:%d, col %d", line, col));
		}
	}

	public static String removeUnneededCharacters(String data) {
		String svaret = data;
		svaret = svaret.replace(" ", "");
		svaret = svaret.replace("\n", "");
		svaret = svaret.replace("\t", "");
		svaret = svaret.replace("\r", "");
		
		return svaret;
	}
}
