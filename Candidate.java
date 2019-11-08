/* Name: PhuongLinh Tran
 * File: Candidate.java
 * Desc: Defines a Candidate object for each candidate and holds its relevant
 * information including last name, full name and polling percentage of each
 * candidate.
 *
 */

import java.util.*;
import java.io.*;

public class Candidate implements Comparable<Candidate> {
    private String lastName;// candidate's last name
    private String fullName;// candidate's full name
    private double percentage;// candidate's polling percentage

    /* constructs a Candidate object
     * @param lastName Candidate's last name
     * @param fullName Candidate's full name
     * @param percentage Candidate's percentage
     */
    public Candidate(String lastName, String fullName, double percentage) {
	this.lastName = lastName;
	this.fullName = fullName;
	this.percentage = percentage;
    }

    /* returns last name of candidate
     * @return Candidate's last name
     */
    public String getLastName() {
	return lastName;
    }

    /* returns full name of candidate
     * @return Candidate's full name
     */
    public String getFullName() {
	return fullName;
    }

    /* returns polling percentage of candidate
     * @return Candidate's polling percentage
     */
    public double getPercentage() {
	return percentage;
    }

    /* returns 0 if the two candidates being compared have the same last 
     * name, -1 if if this candidate's last name is lexicographically 
     * less than and 1 otherwise.
     * @param c Candidate being compared to this candidate
     * @return An integer indicating coparision result of two candidates
     */
    public int compareTo(Candidate c) {
	int comp = this.lastName.compareTo(c.getLastName());
	if (comp == 0) {//candidates have same last name
	    return this.fullName.compareTo(c.getFullName());
	}
	return comp;
    }

    /* return a String representation of the object
     * @return String of candidate's full name and polling percentage
     */
    public String toString() {
	return fullName + ":" + percentage;
    }
}
	
