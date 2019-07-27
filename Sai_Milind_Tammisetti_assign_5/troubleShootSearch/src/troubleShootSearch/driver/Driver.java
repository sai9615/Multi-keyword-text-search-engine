
package multiThreadedHS.driver;

import  multiThreadedHS.util.Results;
import  multiThreadedHS.util.MyLogger;
import  multiThreadedHS.util.FileProcessor;
import  multiThreadedHS.util.MergeSort;
import  multiThreadedHS.threads.ThreadWorker;

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

		String inputf1;
		String inputf2;
		String inputf3;
		String output;
		String Debug;


		int n = Integer.parseInt(args[0]);
		if(n > 3 || n < 1){
			System.out.println("The value of N can only be between 1 and 3");
			System.exit(0);
		}

		if( n == 1){
			if ( (args.length != 4) || args[0].equals("${arg0}") || args[1].equals("${arg1}") || args[2].equals("${arg2}")|| args[3].equals("${arg3}")) {

				System.err.println("Error: Incorrect number of arguments. Program accepts "+ (n+3) +" argumnets.");
				System.exit(0);
			}
			inputf1 = args[1];
			output = args[2];
			Debug = args[3];
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
			Results res = new Results(output);

			ThreadWorker threadWorker = new  ThreadWorker(inputf1, res);
			threadWorker.start();
			MergeSort ms = new MergeSort(res);
			res.writeResults();
			res.closeMyFile();

		}	else if (n==2){
				if ( (args.length != 5) || args[0].equals("${arg0}") || args[1].equals("${arg1}") || args[2].equals("${arg2}")|| args[3].equals("${arg3}") || args[4].equals("${arg4}")) {

					System.err.println("Error: Incorrect number of arguments. Program accepts"+ (n+3) +" argumnets.");
					System.exit(0);
			}
			inputf1 = args[1];
			inputf2 = args[2];
			output = args[3];
			Debug = args[4];
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

			Results res = new Results(output);

			ThreadWorker threadWorker1 = new  ThreadWorker(inputf1, res);
			ThreadWorker threadWorker2 = new  ThreadWorker(inputf2, res);
			threadWorker1.start();
			threadWorker2.start();
			try{
				threadWorker1.join();
				threadWorker2.join();
			}
			catch (Exception e){
				System.out.println("Multithreading not working");
			}
			MyLogger.writeMessage("Thread " + threadWorker1.getId() + " is alive: " +threadWorker1.isAlive(), MyLogger.DebugLevel.TID);
			MyLogger.writeMessage("Thread " + threadWorker2.getId() + " is alive: " +threadWorker1.isAlive(), MyLogger.DebugLevel.TID);
			MergeSort ms = new MergeSort(res);
			res.writeResults();
			res.closeMyFile();

		} else if (n==3){
			if ( (args.length !=6) || args[0].equals("${arg0}") || args[1].equals("${arg1}") || args[2].equals("${arg2}")|| args[3].equals("${arg3}") || args[4].equals("${arg4}")|| args[5].equals("${arg5}")) {

				System.err.println("Error: Incorrect number of arguments. Program accepts"+ (n+3) +" argumnets.");
				System.exit(0);
			}
			inputf1 = args[1];
			inputf2 = args[2];
			inputf3 = args[3];
			output = args[4];
			Debug = args[5];
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
			Results res = new Results(output);
			ThreadWorker threadWorker1 = new  ThreadWorker(inputf1, res);
			ThreadWorker threadWorker2 = new  ThreadWorker(inputf2, res);
			ThreadWorker threadWorker3 = new  ThreadWorker(inputf3 , res);
			threadWorker1.start();
			threadWorker2.start();
			threadWorker3.start();
			try{
				threadWorker1.join();
				threadWorker2.join();
				threadWorker3.join();
			}
			catch (Exception e){
				System.out.println("Multithreading not working");
			}
			MyLogger.writeMessage("Thread " + threadWorker1.getId() + " is alive: " +threadWorker1.isAlive(), MyLogger.DebugLevel.TID);
			MyLogger.writeMessage("Thread " + threadWorker2.getId() + " is alive: " +threadWorker1.isAlive(), MyLogger.DebugLevel.TID);
			MyLogger.writeMessage("Thread " + threadWorker3.getId() + " is alive: " +threadWorker1.isAlive(), MyLogger.DebugLevel.TID);
			MergeSort ms = new MergeSort(res);
			res.writeResults();
			res.closeMyFile();
		}
	     // end of if
	}  // end public static void main
    }  // end public class Driver
