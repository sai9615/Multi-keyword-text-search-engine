# CSX42: Assignment 5
## Name: Sai Milind Tammisetti

-----------------------------------------------------------------------
-----------------------------------------------------------------------


Following are the commands and the instructions to run ANT on your project.
#### Note: build.xml is present in troubleShootSearch/src folder.

-----------------------------------------------------------------------
## Instruction to clean:

####Command: 
ant -buildfile troubleShootSearch/src/build.xml clean

Description: It cleans up all the .class files that were generated when you
compiled your code.

-----------------------------------------------------------------------
## Instruction to compile:

####Command: ant -buildfile troubleShootSearch/src/build.xml all

Description: Compiles your code and generates .class files inside the BUILD folder.

-----------------------------------------------------------------------
## Instruction to run:

####Command: 
ant -buildfile troubleShootSearch/src/build.xml run -Darg0=<userInput.txt> -Darg1=<synonyms.txt> -Darg1=<outputFile.txt> -Darg2=<Logger-Value> 

Example:

The last argument is the Logger value. 
ant -buildfile troubleShootSearch/src/build.xml run -Darg0=userInput.txt -Darg1=synonyms.txt -Darg2=output.txt -Darg3=1

DEBUG_VALUE=4 [Print to stdout everytime a constructor is called]
DEBUG_VALUE=3 [Print to stdout operations related to file processor]
DEBUG_VALUE=2 [Print to stdout whenever we encounter an error]
DEBUG_VALUE=1 [Print to stdout every time results are being written to file]
DEBUG_VALUE=0 [No output should be printed from the applicatio to stdout. It is ok to write to the output file though" ]

-----------------------------------------------------------------------
## Description:
Implemented visitor pattern where in a single userInput is being passed to all the three different types of search methods along with the three different technical text each for a search type. There are total 27 enteries in the userInput 8 that give exact match, 8 that give naive stemming match and 8 that give semantic match and 3 that don't match with any of the technical sentences. There are 8 technical sentences in each technical file so a total of 24 technical sentences.


-----------------------------------------------------------------------
### Academic Honesty statement:
-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating I will have to sign an
official form that I have cheated and that this form will be stored in
my official university record. I also understand that I will receive a
grade of 0 for the involved assignment for my first offense and that I
will receive a grade of F for the course for any additional
offense."

Date: 08/05/2019 


