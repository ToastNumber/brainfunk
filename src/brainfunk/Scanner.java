package brainfunk;

public class Scanner {
	private char[] data;
	private int index;
	
	public Scanner(String data) {
		this.data = data.toCharArray();
		this.index = -1;
	}
	
	public char nextLetter() {
		++index;
		return data[index];
	}
	
	public void jump(int index) {
		this.index = index;
	}
	
	public int index() {
		return this.index;
	}
	
	public boolean hasNext() {
		return index < data.length - 1;
	}
	
	public String toString() {
		String svaret = "";
		for (int i = 0; i < index; ++i) {
			svaret += " ";
		}
		
		svaret += "*\n";
		for (int i = 0; i < data.length; ++i) {
			svaret += data[i];
		}
		
		return svaret;
	}
}
