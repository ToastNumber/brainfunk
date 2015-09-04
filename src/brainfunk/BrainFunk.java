package brainfunk;

public class BrainFunk {
	private int[] tape = new int[30_000];
	private String code;
	
	public BrainFunk(String code) {
		if (code == null) throw new NullPointerException();
		else this.code = code;
	}
	
	/**
	 * Calling this method runs the program
	 */
	public void run() {
		
	}
	
	public static void main(String[] args) {
	}
}
