/* Name: PhuongLinh Tran
 * File: Main.java
 * Main: Main driver of the program. Reads in file from command lines, process
 * data and print data of each file in specified format
 */
import java.util.*;
import java.io.*;
import java.text.*;

public class Main {
    public static final int LAST_NAME = 0;// index of last name in line
    public static final int FULL_NAME = 1;// index of full name in line
    public static final int PERCENTAGE = 2;// index of polling percentage
    
    public static void main(String[] args) throws FileNotFoundException {
	//creates empty binary tree of Candidate objects
	LinkedBinaryTree<Candidate> candidates
	    = new LinkedBinaryTree<Candidate>();

	if (args.length > 0) {
	    try {
		for (int i=0; i<args.length; i++) {
		    //read each file from command line and scan
		    FileReader file = new FileReader(args[i]);
		    Scanner data = new Scanner(file);
		    data.nextLine();//skips first line
		    
		    while (data.hasNext()) {
			String line = data.nextLine();
			Object[] tokens = line.split(",");
			String lastName = tokens[LAST_NAME].toString();
			String fullName = tokens[FULL_NAME].toString();
			double percentage
		           = Double.parseDouble(tokens[PERCENTAGE].toString());
			
			// creates a new Candidate object
			Candidate c = new
			    Candidate(lastName, fullName, percentage);
			candidates.insert(c);// inserts object into tree
		    }
		    System.out.println("\n"+candidates.toStringInOrder()+"\n");
		}
	    }catch (FileNotFoundException e) {
		System.out.println("\nInvalid filenames!\n");
		return;
	    }
	}
	else { System.out.println("\nNo filenames found!\n");}
    }
}
