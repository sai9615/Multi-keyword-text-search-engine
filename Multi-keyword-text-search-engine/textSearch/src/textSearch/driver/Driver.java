package textSearch.driver;

import  textSearch.util.Results;
import  textSearch.util.MyLogger;
import  textSearch.util.FileProcessor;
import  textSearch.visitors.dSeaGate;
import  textSearch.visitors.exact_match;
import  textSearch.visitors.naive_stemming_match;
import  textSearch.visitors.semantic_match;

import java.util.ArrayList;

/**
 * @author Sai Milind Tammisetti
 *
 */
    
    public class Driver {
	
	public static void main(String[] args) {
	    
	    /*
	     * As the build.xml specifies the arguments as argX, in case the
	     * argument value is not given java takes the default value specified in
	     * build.xml. To avoid that, below condition is used
	     */

	    // FIXME: update this if statement for this assignment

		if ( (args.length != 4) || args[0].equals("${arg0}") || args[1].equals("${arg1}") || args[2].equals("${arg2}")|| args[3].equals("${arg3}")) {

			System.err.println("Error: Incorrect number of arguments. Program accepts 5 argumnets.");
			System.exit(0);
		} // end of if

		String inputf1 = args[0];
		String inputf2 = args[1];
		String outputf = args[2];
		String Debug = args[3];

		MyLogger obj = new MyLogger();


		int dbglvl = Integer.parseInt(Debug);
		if(dbglvl <0 || dbglvl > 4){
			System.out.println("Enter proper dbg option from 1 to 4 \n");
			System.out.println("0:RELEASE, 1:SHOW ERROR IF ENCOUNTERED, 2:SHOW RESULT TO STDOUT 3:PRINT WHEN CHANGE IN STATE 4:PRINT WHENEVER CONSTRUCTOR IS CALLED \n");
			System.exit(0);
		}
		else {

			obj.setDebugValue(dbglvl);
			System.out.println("debug level set to "+dbglvl);
		}

		Results results = new Results(outputf);
		dSeaGate dsg = new dSeaGate(results);

		//Read the input.txt

		String input1;
		FileProcessor fp = new FileProcessor(inputf1);
		while ((input1 = fp.readLine()) != null) {
			{
				dsg.insertUI(input1);
			}
		}

		String input2;
		FileProcessor fps = new FileProcessor("tech1.txt");
		while ((input2 = fps.readLine()) != null) {
			{
				dsg.insertTech(input2);
			}
		}

		String input3;
		FileProcessor fps3 = new FileProcessor("tech2.txt");
		while ((input3 = fps3.readLine()) != null) {
			{
				dsg.insertTech2(input3);
			}
		}

		String input4;
		FileProcessor fps4 = new FileProcessor("tech3.txt");
		while ((input4 = fps4.readLine()) != null) {
			{
				dsg.insertTech3(input4);
			}
		}

		String input5;
		FileProcessor fpp = new FileProcessor(inputf2);
		while ((input5 = fpp.readLine()) != null) {
				dsg.insertSyn(input5);
			}
		

		exact_match exm = new exact_match();
		naive_stemming_match nsm = new naive_stemming_match();
		semantic_match sm = new semantic_match();
		exm.accept(dsg);
		nsm.accept(dsg);
		sm.accept(dsg);
		
		results.writeResults();
		results.closeMyFile();

	}  // end public static void main
    }  // end public class Driver
