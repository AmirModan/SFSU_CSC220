package PJ3;

import java.util.*;
import java.io.*;

// You may add new functions or data fields in this class 
// You may modify any functions or data members here
// You must use Student, Advisor and AdvisingArea classes
// to implement AdvisingCenter simulator

// The outline is given below, add statements to complete 
// the simulator

class AdvisingCenter {

	// input parameters
	private int numAdvisors, studentQLimit;
	private int chancesOfArrival, maxAdvisingTime;
	private int simulationTime, dataSource;

	// statistical data
	private int numGoaway, numServed, totalWaitingTime;

	// internal data
	private int counter; // student ID counter
	private AdvisingArea advisingarea; // advising area object
	private Scanner dataFile; // get student data from file
	private String fileName;
	private int[][] dataArray;
	private Random dataRandom; // get student data using random function

	// most recent student arrival info, see getStudentData()
	private boolean anyNewArrival;
	private int advisingTime;

	// initialize data fields
	private AdvisingCenter() {
		// add statements
		dataRandom = new Random();
		counter = 1;
	}

	private void setupParameters() {
		// read input parameters
		// setup dataFile or dataRandom
		// add statements
		dataFile = new Scanner(System.in);
		System.out.print("Enter simulation time (positive integer)      : ");
		simulationTime = dataFile.nextInt();
		System.out.print("Enter the number of advisors                  : ");
		numAdvisors = dataFile.nextInt();
		System.out.print("Enter chances (0% < & <= 100%) of new student : ");
		chancesOfArrival = dataFile.nextInt();
		System.out.print("Enter maximum advising time of students       : ");
		maxAdvisingTime = dataFile.nextInt();
		System.out.print("Enter student queue limit                     : ");
		studentQLimit = dataFile.nextInt();
		System.out.print("Enter 0/1 to get data from random/file        : ");
		dataSource = dataFile.nextInt();
		if (dataSource == 1) {
			System.out.print("Enter filename                                : ");
			fileName = dataFile.next();
			File file = new File("./pj3-f2019-stud/" + fileName);
			try {
				dataFile = new Scanner(file);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			dataArray = new int[simulationTime][2];
			for (int i = 0; i < simulationTime; i++) {
				dataArray[i][0] = dataFile.nextInt();
				dataArray[i][1] = dataFile.nextInt();
			}
		}
	}

	// Refer to step 1 in doSimulation()
	// this method is called for each unit simulation time
	private void getStudentData(int currentTime) {
		// get next student data : from file or random number generator
		// set anyNewArrival and advisingTime
		// add statements
		if (dataSource == 1) {

			anyNewArrival = (((dataArray[currentTime][0] % 100) + 1) <= chancesOfArrival);
			advisingTime = (dataArray[currentTime][1] % maxAdvisingTime) + 1;

		} else {
			anyNewArrival = ((dataRandom.nextInt(100) + 1) <= chancesOfArrival);
			advisingTime = dataRandom.nextInt(maxAdvisingTime) + 1;
		}
	}

	private void doSimulation() {
		// add statements
		System.out.println("\n\n\t***  Start Simulation  ***\n\n");
		System.out.println("Advisor #1 to #" + numAdvisors + " are ready...\n\n");
		// Initialize AdvisingArea
		advisingarea = new AdvisingArea(this.numAdvisors, this.studentQLimit);
		// Time driver simulation loop
		for (int currentTime = 0; currentTime < simulationTime; currentTime++) {
			System.out.println("---------------------------------------------");
			System.out.println("Time : " + currentTime);
			// Step 1: any new student enters the advising area?
			getStudentData(currentTime);

			if (anyNewArrival) {

				// Step 1.1: setup student data
				Student s = new Student(counter, advisingTime, currentTime);
				// Step 1.2: check student waiting queue too long?
				// if Q too long, update numGoaway
				if (advisingarea.isStudentQTooLong()) {
					numGoaway++;
				} else {
					advisingarea.insertStudentQ(s);
					System.out
							.println("student #" + counter + " arrives with advising time " + advisingTime + " units");
					System.out.println("student #" + counter + " waits in the student queue");
				}
				counter++;

			} else {
				System.out.println("\tNo new student!");
			}

			// Step 2: free busy advisors, add to free advisorQ
			Queue<Advisor> temp = new ArrayDeque<Advisor>();
			while (!advisingarea.emptyBusyAdvisorQ()) {
				Advisor b = advisingarea.peekBusyAdvisorQ();
				if (b.getEndBusyTime() == currentTime) {
					System.out.println("student #" + b.getCurrentStudent().getStudentID() + " is done");
					System.out.println("advisor #" + b.getAdvisorID() + " is free");
					b.endAdvisingSession();
					advisingarea.insertFreeAdvisorQ(advisingarea.removeBusyAdvisorQ());
				} else {
					temp.add(advisingarea.removeBusyAdvisorQ());
				}

			}
			while (!temp.isEmpty()) {
				advisingarea.insertBusyAdvisorQ(temp.remove());
			}

			// Step 3: get free advisors to serve waiting students
			// update TotalWaitingTime and numServed

			while (!advisingarea.emptyFreeAdvisorQ() && !advisingarea.emptyStudentQ()) {
				Advisor a = advisingarea.removeFreeAdvisorQ();
				advisingarea.insertBusyAdvisorQ(a);
				a.startAdvisingSession(advisingarea.removeStudentQ(), currentTime);
				System.out.println("student #" + a.getCurrentStudent().getStudentID() + " gets an advisor");
				System.out.println("advisor #" + a.getAdvisorID() + " starts advising student #"
						+ a.getCurrentStudent().getStudentID() + " for " + a.getCurrentStudent().getAdvisingTime()
						+ " units");
				numServed++;
				totalWaitingTime += a.getCurrentStudent().getWaitTime();
			}
			if (!advisingarea.emptyStudentQ()) {
				// totalWaitingTime++;
			}
		} // end simulation loop

		// clean-up - close scanner
	}

	private void printStatistics() {
		// add statements into this method!
		// print out simulation results
		// see the given example in project statement
		// you need to display all free and busy advisors

		// need to free up all students in queue to get extra waiting time.
		// need to free up all advisors in free/busy queues to get extra free & busy
		// time
		int waitingStudents = advisingarea.sizeStudentQ();
		while(advisingarea.sizeStudentQ() > 0) {
			totalWaitingTime += (simulationTime - advisingarea.removeStudentQ().getArrivalTime());
		}
		System.out.println("\n\n============================================\n\n");
		System.out.println("End of simulation report");
		System.out.println("\t# total arrival students  : " + (numServed + numGoaway));
		System.out.println("\t# students gone-away      : " + numGoaway);
		System.out.println("\t# students served         : " + numServed + "\n");
		System.out.println("*** Current Advisors Info. ***\n\n");
		System.out.println("\t# waiting students   : " + waitingStudents);
		System.out.println("\t# busy advisors      : " + advisingarea.sizeBusyAdvisorQ());
		System.out.println("\t# free advisors      : " + advisingarea.sizeFreeAdvisorQ() + "\n");
		System.out.println("\tTotal waiting time         : " + totalWaitingTime);
		System.out.println("\tAverage waiting time       : " + (((100 * totalWaitingTime) / numServed)) / 100.0);
		System.out.println("\n\n\tBusy Advisors Info. :");
		while (advisingarea.sizeBusyAdvisorQ() > 0) {
			System.out.println("\n\n");
			Advisor a = advisingarea.removeBusyAdvisorQ();
			a.setEndBusyTime(simulationTime);
			a.endAdvisingSession();
			a.printStatistics();
		}

		System.out.println("\n\n\tFree Advisors Info. :");
		while (advisingarea.sizeFreeAdvisorQ() > 0) {
			System.out.println("\n\n");
			Advisor a = advisingarea.removeFreeAdvisorQ();
			a.setEndFreeTime(simulationTime);
			a.updateTotalFreeTime();
			a.printStatistics();
		}
	}

	// *** main method to run simulation ****

	public static void main(String[] args) {
		AdvisingCenter runAdvisingCenter = new AdvisingCenter();
		runAdvisingCenter.setupParameters();
		runAdvisingCenter.doSimulation();
		runAdvisingCenter.printStatistics();
	}

}
