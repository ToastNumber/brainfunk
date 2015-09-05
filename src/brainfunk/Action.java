package brainfunk;

public enum Action {
	INPUT, OUTPUT, INCREMENT, DECREMENT, RIGHT, LEFT, LOOP_START, LOOP_END;
	
	public String toString() {
		if (this == INPUT) return "INPUT";
		else if (this == OUTPUT) return "OUTPUT";
		else if (this == INCREMENT) return "INCREMENT";
		else if (this == DECREMENT) return "DECREMENT";
		else if (this == RIGHT) return "RIGHT";
		else if (this == LEFT) return "LEFT";
		else if (this == LOOP_START) return "LOOP_START";
		else return "LOOP_END";
	}
}
