@ECHO off

:main
	ECHO BrainF%$k Interpreter
	ECHO.
	SET filepath=""
	SET inputpath=""
	
	SET /p filepath="Enter file path: "
	SET /p inputpath="Enter path of input: "

	java -cp bin brainfunk.BrainFunk false %filepath% %inputpath%

	SET /p dummy="Press ENTER to continue ..."
	CLS
	GOTO main