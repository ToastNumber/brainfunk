package brainfunk;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class BrainFunk {

	public static void main(String[] args) {
		boolean trace = false;
		String code = "";
		
		if (args.length < 2) {
			System.err.println("More arguments expected - (true|false) FILENAME [INPUT]");
		} else {
			if (args[0].toLowerCase().equals("true")) trace = true;
			else if (args[0].toLowerCase().equals("false")) trace = false;
			else System.err.println("TRACE should be either \"true\" or \"false\".");
			
			try {
				FileReader reader = new FileReader(args[1]);
				BufferedReader bf = new BufferedReader(reader);

				int c;
				while ((c = bf.read()) != -1) {
					code += (char) c;
				}
				
				bf.close();
				reader.close();
				
				code = Parser.removeUnneededCharacters(code);

				Interpreter interpreter;
				if (args.length == 3) {
					interpreter = new Interpreter(code, args[2]);
				} else {
					interpreter = new Interpreter(code);
				}
				
				interpreter.run(trace);
			} catch (IOException e) {
				System.err.println(e.getMessage());
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}
	}
}
