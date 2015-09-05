package brainfunk;

public class BrainFunk {

	public static void main(String[] args) throws Exception {
		Interpreter printABCD = new Interpreter(""
				+ "+++++++++++++++++++++["
				+ ">+++>+++>+++>+++>+++<<<<<-"
				+ "]>++.>+++.>++++.>+++++."
				);
		printABCD.run(false, false);
		
		
	}
}
