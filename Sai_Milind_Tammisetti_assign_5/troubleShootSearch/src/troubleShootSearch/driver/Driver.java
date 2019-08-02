
package multiThreadedHS.driver;

import  troubleShootSearch.util.Results;
import  troubleShootSearch.util.MyLogger;
import  troubleShootSearch.util.FileProcessor;
import  troubleShootSearch.visitors.dSeaGate;
import  troubleShootSearch.visitors.exact_match;
import  troubleShootSearch.visitors.naive_stemming_match;
import  troubleShootSearch.visitors.semantic_match;

import java.util.ArrayList;

/**
 * @author AuthorName
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
public class Driver {
	
	public static void main(String[] args) {
	    
	    /*
	     * As the build.xml specifies the arguments as argX, in case the
	     * argument value is not given java takes the default value specified in
	     * build.xml. To avoid that, below condition is used
	     */

	    // FIXME: update this if statement for this assignment

		if ( (args.length != 5) || args[0].equals("${arg0}") || args[1].equals("${arg1}") || args[2].equals("${arg2}")|| args[3].equals("${arg3}") || args[4].equals("${arg4}")) {

			System.err.println("Error: Incorrect number of arguments. Program accepts 5 argumnets.");
			System.exit(0);
		} // end of if

		String inputf1 = args[0];
		String inputf2 = args[1];
		String inputf3 = args[2];
		String outputf = args[3];
		String Debug = args[4];

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
		FileProcessor fps = new FileProcessor(inputf2);
		while ((input2 = fps.readLine()) != null) {
			{
				dsg.insertTech(input2);
			}
		}

		String input3;
		FileProcessor fpp = new FileProcessor(inputf3);
		while ((input3 = fpp.readLine()) != null) {
			{
				dsg.insertSyn(input3);
			}
		}
		
	}  // end public static void main
    }  // end public class Driver
