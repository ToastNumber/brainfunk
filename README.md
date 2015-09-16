#BrainFunk
A command line interface for interpreting the esoteric language BrainF%$k.

##Usage
Run your program using the command `java brainfunk.BrainFunk (true|false) FILENAME [INPUT]`
	- `(true|false)` indicates whether or not the execution of the program should be traced. If `true`, then the tape and the current symbol will be indicated at each stage.
	- `FILENAME` is the path of the file to be interpreted - it must be valid BrainF%$k code.
	- `[INPUT]` is an optional argument which indicates the path of a file containing the input for the BrainF%$k program.

##Automated Usage
- `compile.bat` automatically compiles the source files into a bin folder.
- `run.bat` automatically runs the program, and asks for the path for the file to interpret, and the path for the input. It does not show the trace. The input can be left blank by pressing `ENTER`.