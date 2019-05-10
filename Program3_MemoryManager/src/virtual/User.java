package virtual;

//Displays the messages for User interactions
public class User {
	
	public void promptMemorySize(){
		System.out.println("Enter the size of Memory:");
	}
	public void promptPolicy(){
		System.out.println("Memory management policy (1- VSP, 2- PAG, 3- SEG): ");
	}
	public void promptFitAlgorithm(){
		System.out.println("Fit algorithm (1- first-fit, 2- best-fit, 3- worst-fit):");
	}
	//when process arrives
	public void printArrival(int processID){
		System.out.println("Process:" + processID + " Arrived" );
	}
	//when process completes
	public void printCompletion(int processID){
		System.out.println("Process: " +processID + " Completed" );
	}
	//when process is admitted to main memory
	public void printAdmission(int processID){
		System.out.println("Process: "+processID + " Entered Main Memory" );
	}
	public int returnValue(int value){
		System.out.println("The value is: "+value);
		return value;
	}


}
