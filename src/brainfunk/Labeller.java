package brainfunk;

import java.util.List;
import java.util.ArrayList;

public class Labeller {

	public static CodeCharacter[] label(String data) {
		char[] chars = data.toCharArray();
		List<CodeCharacter> svaret = new ArrayList<>();
		
		for (int i = 0, line = 1, col = 1; i < chars.length; ++i, ++col) {
			if (chars[i] == '\n') {
				++line;
				col = 1;
			} else {
				svaret.add(new CodeCharacter(chars[i], line, col));
			}
		}

		CodeCharacter[] result = new CodeCharacter[svaret.size()];
		int index = 0;
		for (CodeCharacter c : svaret) {
			result[index] = c;
			++index;
		}
		
		return result;
	}
	
}
