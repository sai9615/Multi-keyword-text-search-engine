# Multi-keyword Text Search Engine

-----------------------------------------------------------------------
-----------------------------------------------------------------------


Following are the commands and the instructions to run ANT on your project.
#### Note: build.xml is present in textSearch/src folder.

-----------------------------------------------------------------------
## Instruction to clean:

#### Command: ant -buildfile textSearch/src/build.xml clean

Description: It cleans up all the .class files that were generated when you
compiled your code.

-----------------------------------------------------------------------
## Instruction to compile:

#### Command: ant -buildfile textSearch/src/build.xml all

Description: Compiles your code and generates .class files inside the BUILD folder.

-----------------------------------------------------------------------
## Instruction to run:

#### Command: ant -buildfile textSearch/src/build.xml run -Darg0=userInput.txt -Darg1=synonyms.txt -Darg2=output.txt -Darg3=1

* DEBUG_VALUE=4 [Print to stdout everytime a constructor is called]
* DEBUG_VALUE=3 [Print to stdout operations related to file processor]
* DEBUG_VALUE=2 [Print to stdout whenever we encounter an error]
* DEBUG_VALUE=1 [Print to stdout every time results are being written to file]
* DEBUG_VALUE=0 [No output should be printed from the applicatio to stdout. It is ok to write to the output file though" ]

-----------------------------------------------------------------------
## Description:
The search engine performs the following task:

* accept keywords from an input file named, userInputs.txt.
* performs the following matches:

	* Exact match: Finds and prints in output.txt all technical sentences that have an exact match for the entered keywords. 
		     So, if the user enters "problem detecting", a technical sentence that matches could be the following: "If Debian has a problem detecting 
		     the drive, it could be that the portable drive is not receiving enough power."

	* Naive Stemming match: Finds and prints in output.txt all technical sentences that have a word, whose substring is an exact match 
	                        for the first entered keyword. So, if the user enters "detect error", the technical sentence that matches 
				could be the following: "If Debian has a problem detecting the drive, it could be that the portable drive 
				is not receiving enough power."

	* Semantic match: Finds the synonym of the last entered keyword by the user and employees "Exact match." Uses an input file synonym.txt 
			  that contains key-value pairs of synonyms. Reads the synonyms from the file, during startup, and stores them in an appropriate 
			  data structure. So, if the user enters "comptabile CPU", the technical sentence that matches could be the following: "All
			  products from AMD have a compatible processor as far as dSeaGate is concerned." The file synonym.txt should have the the
			  following using a format of your choosing. Search Engine is designed to be bi-directional. So, in the above example "CPU" can substitute 
			  "processor" and "processor" can substitute "CPU".


-----------------------------------------------------------------------



