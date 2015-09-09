#BrainFunk
A command line interface for interpreting the esoteric language BrainF%$k.

##Usage
1. Compile the source files into a `bin` folder.
2. Navigate into the bin folder.
3. Run your program using the command `java brainfunk (true|false) FILENAME [INPUT]`
	- `(true|false)` indicates whether or not the execution of the program should be traced. If `true`, then the tape and the current symbol will be indicated at each stage.
	- `FILENAME` is the path of the file to be interpreted - it must be valid BrainF%$k code.
	- `[INPUT]` is an optional argument which indicates the path of a file containing the input for the BrainF%$k program.

##Folder Structure
The resulting folder structure should be:
```
brainfunk/
	bin/
		brainfunk/
			BrainFunk.class
			*.class
	src/
		brainfunk/
			*.java
	.gitignore
	README.md
```