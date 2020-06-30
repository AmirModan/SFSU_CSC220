// DO NOT ADD NEW METHODS OR NEW DATA FIELDS!
// DO NOT MODIFY METHODS OR DATA FIELDS!

// Implement methods with "add statements"

package PJ3;

class Advisor {

   // advisor id and current student which is advised by this advisor 
   private int advisorID;
   private Student serveStudent;

   // start time and end time of current interval
   private int startFreeTime;
   private int endFreeTime;
   private int startBusyTime;
   private int endBusyTime;

   // for keeping statistical data
   private int totalFreeTime;
   private int totalBusyTime;
   private int totalStudents;

   // Constructor
   Advisor()
   {
	this(-1);
   }


   // Constructor with an advisor id
   Advisor(int advisorId)
   {
	// add statements
	   this.advisorID = advisorId;
	   this.setStartFreeTime(0);
   }

   // accessor methods

   int getAdvisorID() 
   {
	return advisorID;
   }

   Student getCurrentStudent() 
   {
	return serveStudent;
   }

   // Return end busy clock time, use in priority queue
   int getEndBusyTime() 
   {
	return endBusyTime; 
   }


   // mutator methods

   void setStartFreeTime (int time)
   {
        startFreeTime=time;
   }

   void setStartBusyTime (int time)
   {

        startBusyTime=time;
   }

   void setEndFreeTime (int time)
   {
  	endFreeTime   = time;
   }

   void setEndBusyTime (int time)
   {
  	endBusyTime   = time;
   }
 
   void setCurrentStudent(Student aStudent) 
   {
	serveStudent=aStudent;
   }


   //-----------------------------------------------------------
   // Update totalBusyTime and totalFreeTime 
   //-----------------------------------------------------------


   // statistical methods
   void updateTotalFreeTime()
   {
	// add statements
	   this.totalFreeTime += (this.endFreeTime - this.startFreeTime);
   }

   void updateTotalBusyTime()
   {
	// add statements
	   this.totalBusyTime += (this.endBusyTime - this.startBusyTime);
   }

   void updateTotalStudents()
   {
	totalStudents++;
   }


   //---------------------------------
   // Advisor State Transition methods
   //---------------------------------

   // Start advising a student
   void startAdvisingSession(Student aStudent, int currentTime)
   {
	// Start advising session at currentTime
  	// task  : switch from free interval to busy interval
        //
	// steps : set endFreeTime, update TotalFreeTime
	//         set startBusyTime, endBusyTime, currentStudent
  	//         set aStudent waitTime, finsihTime 
	//         update totalStudents

	// add statements
	   this.setEndFreeTime(currentTime);
	   this.updateTotalFreeTime();
	   this.setStartBusyTime(currentTime);
	   this.setCurrentStudent(aStudent);
	   this.setEndBusyTime(aStudent.getAdvisingTime() + currentTime);
	   aStudent.setWaitTime(currentTime - aStudent.getArrivalTime());
	   aStudent.setFinishTime(this.getEndBusyTime());
	   this.totalStudents++;
	   
   }



   // End advising a student
   Student endAdvisingSession()
   {
	// End advising session at currentTime
  	// task  : switch from busy interval to free interval
        //
	// steps : update TotalBusyTime, set startFreeTime
  	//         return serveStudent 
	
	// add statements
	   this.setStartFreeTime(this.getEndBusyTime());
	   this.updateTotalBusyTime();
       return this.getCurrentStudent();
	
   }


   // functions for printing statistics :
   void printStatistics () 
   {
  	// print advisor statistics, see project statement

  	System.out.println("\t\tAdvisor ID             : "+advisorID);
  	System.out.println("\t\tTotal free time        : "+totalFreeTime);
  	System.out.println("\t\tTotal busy time        : "+totalBusyTime);
  	System.out.println("\t\tTotal # of students    : "+totalStudents);
  	if (totalStudents > 0)
  	    System.out.format("\t\tAverage advising time  : %.2f%n\n",(totalBusyTime*1.0)/totalStudents);
   }

   public String toString()
   {
	return "AdvisorID="+advisorID+
	       "\n:startFreeTime="+startFreeTime+":endFreeTime="+endFreeTime+":totalFreeTime="+totalFreeTime+
	       "\n:startBusyTime="+startBusyTime+":endBusyTime="+endBusyTime+":totalBusyTime="+totalBusyTime+ 
	       "\n:totalStudent="+totalStudents+"\n-->currentStudent:"+serveStudent+"\n";
   }

   public static void main(String[] args) {
        // quick check
        Student mystudent = new Student(1,8,15);
	Advisor myadvisor = new Advisor(5);
	myadvisor.setStartFreeTime(0);
        System.out.println(myadvisor);
        myadvisor.startAdvisingSession(mystudent, 25);
        System.out.println("\n"+myadvisor);
	myadvisor.endAdvisingSession();
        System.out.println("\n"+myadvisor);
        System.out.println("\n\n");
	myadvisor.printStatistics();

   }

};

