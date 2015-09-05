package brainfunk;

public class CodeCharacter {
	private char character;
	private int line;
	private int col;
	
	public CodeCharacter(char character, int line, int col) {
		this.character = character;
		this.line = line;
		this.col = col;
	}

	public char character() {
		return character;
	}

	public int line() {
		return line;
	}

	public int col() {
		return col;
	}

	
}
