// DO NOT ADD NEW METHODS OR NEW DATA FIELDS!
// DO NOT MOFIFY METHODS OR NEW DATA FIELDS!

// This Student class is done! 
// No implementation is needed.

package PJ3;

class Student
{
    private int studentID;
    private int advisingTime;
    private int arrivalTime;
    private int finishTime;
    private int waitTime;

    // default constructor
    Student()
    {
    }

    // constructor to set studentID, advisingTime and arrivalTime
    Student(int studentid, int advisingtime, int arrivaltime)
    {
  	studentID  = studentid;
  	advisingTime = advisingtime;
  	arrivalTime = arrivaltime;
    }

    int getAdvisingTime() 
    {
  	return advisingTime; 
    }

    int getArrivalTime() 
    {
  	return arrivalTime; 
    }

    int getStudentID() 
    {
  	return studentID; 
    }

    int getFinishTime() 
    {
  	return finishTime; 
    }

    int getWaitTime() 
    {
  	return waitTime; 
    }

    void setWaitTime(int time) 
    {
  	waitTime=time; 
    }

    void setFinishTime(int time) 
    {
  	finishTime=time; 
    }

    public String toString()
    {
    	return "studentID="+studentID+":advisingTime="+
               advisingTime+":arrivalTime="+arrivalTime+
	       ":watiTime="+waitTime+":finishTime="+finishTime;

    }

    public static void main(String[] args) {
        // quick check!
	Student mystudent = new Student(1,5,35);
        mystudent.setWaitTime(10);	
        mystudent.setFinishTime(50);	
	System.out.println("Student Info --> "+mystudent);

    }
}
