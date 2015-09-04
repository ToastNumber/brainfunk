package brainfunk;

public class Tape {
	private int[] tape = new int[30_000];
	private int pointer = 0;
	
	private void throwIndexException() throws IndexOutOfBoundsException {
		throw new IndexOutOfBoundsException("Tape value at " + pointer + " is negative.");
	}
	
	public void perform(Action action) {
		if (action == Action.INCREMENT) {
			++tape[pointer];
		} else if (action == Action.DECREMENT) {
			if (tape[pointer] < 1) throwIndexException();
			else --tape[pointer];
		} else if (action == Action.LEFT) --pointer;
		else if (action == Action.RIGHT) ++pointer;
		else throw new IllegalArgumentException("This argument cannot be performed.");
	}
}
