package brainfunk;

public class BrainFunk {
	private String code;
	private String input;
	
	private int[] tape;
	
	
	public BrainFunk(String code, String input) {
		if (code == null) throw new NullPointerException();
		else this.code = code;
	}
	
	public static Action getAction(String action) {
		if (action.equals(",")) return Action.INPUT;
		else if (action.equals(".")) return Action.OUTPUT;
		else if (action.equals("+")) return Action.INCREMENT;
		else if (action.equals("-")) return Action.DECREMENT;
		else if (action.equals(">")) return Action.RIGHT;
		else if (action.equals("<")) return Action.LEFT;
		else if (action.equals("[")) return Action.LOOP_START;
		else if (action.equals("]")) return Action.LOOP_END;
		else throw new IllegalArgumentException("No associated action found.");
	}
	
	private void perform(Action action) {
	}
	
	/**
	 * Calling this method resets the tape and runs the program
	 */
	public void run() {
		tape = new int[30_000];
		
		String[] characters = Parser.getCharacters(code);
		
		for (int i = 0; i < characters.length; ++i) {
			Action action = getAction(characters[i]);
			perform(action);
		}
	}
	
	public static void main(String[] args) {
	}
}
