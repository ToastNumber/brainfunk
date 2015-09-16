@ECHO off
ECHO ---BrainFunk---
ECHO.
@IF NOT EXIST "bin" GOTO setup

:make
	ECHO Compiling files.
	javac -d bin src/brainfunk/*.java
	ECHO Compilation complete.
	pause
	exit

:setup
	ECHO Creating bin directory.
	MKDIR "bin"
	GOTO make