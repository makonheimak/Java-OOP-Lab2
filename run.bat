@echo off
chcp 65001 > nul
cd /d "%~dp0"
title Lab 2 (Variant 5) - Yurash Maksim

if exist "Lab2_Main.class" goto run
echo [INFO] Compiling Java source files...
javac -encoding UTF-8 Car.java Student.java University.java Lab2_Main.java
if errorlevel 1 goto error

:run
java -Dfile.encoding=UTF-8 -cp . Lab2_Main
goto end

:error
echo [ERROR] Compilation failed. Ensure JDK is installed.

:end
pause
