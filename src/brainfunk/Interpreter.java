package brainfunk;

import java.util.Stack;

public class Interpreter {
	private String code;
	private Scanner codeScanner;
	
	private String input;
	private Scanner inputScanner;
	
	private String output;
	
	private Stack<Integer> loopStack = new Stack<>();

	public Interpreter(String code) {
		this(code, "");
	}

	public Interpreter(String code, String input) {
		if (code == null || input == null) throw new NullPointerException();
		else {
			this.code = code;
			this.input = input;
		}
	}

	private static Action getAction(char action) {
		String stringAction = "" + action;

		if (stringAction.equals(",")) return Action.INPUT;
		else if (stringAction.equals(".")) return Action.OUTPUT;
		else if (stringAction.equals("+")) return Action.INCREMENT;
		else if (stringAction.equals("-")) return Action.DECREMENT;
		else if (stringAction.equals(">")) return Action.RIGHT;
		else if (stringAction.equals("<")) return Action.LEFT;
		else if (stringAction.equals("[")) return Action.LOOP_START;
		else if (stringAction.equals("]")) return Action.LOOP_END;
		else
			throw new IllegalArgumentException("No associated action found.");
	}

	private void perform(Action action, Tape tape) throws Exception {
		if (action == Action.INPUT) {
			try {
			tape.assign(inputScanner.nextLetter());
			} catch (ArrayIndexOutOfBoundsException e) {
				throw new Exception("Invalid input.");
			}
		}
		else if (action == Action.OUTPUT) this.output += (char) tape.getValue();
		else if (action == Action.LOOP_START) this.loopStack.add(codeScanner.index());
		else if (action == Action.LOOP_END) {
			if (tape.getValue() == 0) loopStack.pop();
			else codeScanner.jump(loopStack.peek());
		} else
			tape.perform(action);
	}

	/**
	 * Calling this method resets the tape and runs the program
	 * @throws Exception 
	 */
	public void run(boolean showTape, boolean showCode) throws Exception {
		Tape tape = new Tape();
		output = "";
		inputScanner = new Scanner(input);
		codeScanner = new Scanner(code);
		loopStack.clear();

		if (showTape) System.out.println(tape + "\n---------------------------------------------------------\n");
		while (codeScanner.hasNext()) {
			Action action = getAction(codeScanner.nextLetter());
			perform(action, tape);
			
			if (showCode) System.out.println(codeScanner + "\n");
			if (showTape) System.out.println(tape + "\n");
		}

		System.out.println("OUTPUT: " + this.output);
	}
}
