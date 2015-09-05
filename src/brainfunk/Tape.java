package brainfunk;

public class Tape {
	private int[] tape = new int[30_000];
	private int pointer = 0;

	public void perform(Action action) throws Exception {
		if (action == Action.INCREMENT) {
			++tape[pointer];
		} else if (action == Action.DECREMENT) {
			if (tape[pointer] - 1 < 0) throw new Exception("Cannot decrement a cell with value 0.");
			else --tape[pointer];
		} else if (action == Action.LEFT) {
			if (pointer - 1 < 0) throw new Exception("Pointer is at left of tape.");
			else --pointer;
		} else if (action == Action.RIGHT) {
			if (pointer + 1 >= tape.length) throw new Exception("Pointer is at right of tape.");
			else ++pointer;
		} else {
			throw new IllegalArgumentException(String.format("\"%s\" cannot be performed.", action.toString()));
		}
	}

	public int getValue() {
		return tape[pointer];
	}

	public void assign(int value) {
		tape[pointer] = value;
	}

	public int index() {
		return pointer;
	}

	public String toString() {
		String svaret = "";

		for (int i = 0; i < 2 + 4 * pointer; ++i) {
			svaret += " ";
		}

		svaret += "*";

		svaret += "\n|";
		// Find the end of the content
		int index = 0;
		for (int i = 0; i < tape.length; ++i) {
			if (tape[i] != 0) index = i + 1;
		}

		index = (int) Math.max(index, 10);

		for (int i = 0; i < index; ++i) {
			svaret += String.format(" %d |", tape[i]);
		}

		return svaret;
	}
}
