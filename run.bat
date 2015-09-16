@ECHO off

:main
	ECHO ---BrainFunk---
	ECHO.
	IF NOT EXIST bin/brainfunk/BrainFunk.class GOTO fail
	
	SET filepath=""
	SET inputpath=""
	
	SET /p filepath="Enter file path: "
	SET /p inputpath="Enter path of input: "

	IF %inputpath%=="" java -cp bin brainfunk.BrainFunk false %filepath%
	IF NOT %inputpath%=="" java -cp bin brainfunk.BrainFunk false %filepath% %inputpath%

	SET /p dummy="Press ENTER to continue ..."
	CLS
	GOTO main
	
:fail
	ECHO Error: Could not find or load main class brainfunk.BrainFunk
	ECHO Hint: Try compiling the source files using `compile.bat`
	ECHO.
	PAUSE
	EXIT