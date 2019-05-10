package virtual;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.io.*;
import java.util.Arrays;
/*
 * This class holds the values of the process to be read from files being parsed.
 */
public class Process {
	public Process() {
		
	}
	User ui = new User(); //allows use of ui messages
	public int givenMemory; //size of memory from the user
	public int managerPolicy; //the policy for the memory manager
	
	//For the input files values
	public int numberOfProcess; //how many processes found in file
	public int processID; //ID number of process
	public int arrivalTime; //time process enters memory. May not enter right away.
	public int completionTime; //time to complete the process
	public int segmentNumber; //number of segments
	public int memorySize; //size of each segment for SEG, VSP and PAG is just a sum from 
	//For the process and queue
	public int virtualClock = 0; //timer 
	public int endProcessTime = 0; //timer for the end of a process

	public Process[] process; //array of objects did not declare size
	public boolean notSEG = true; //flag if managment policy is not segment
	public int[] segment;
	
	//Constructor for each process
	public Process(int processId, int arrivalTim, int completion, int segemntCount, int memory){
		processID = processId;
		arrivalTime = arrivalTim;
		completionTime = completion;
		segmentNumber = segemntCount;
		memorySize = memory;
	}
	/*
	 * Begins the code and executes the functions
	 */
	public void start(){
		ui.promptMemorySize();
		ui.promptPolicy();
		ui.promptFitAlgorithm();
	}
	/*
	 * Method getFileInfo reads the file and assigns the value to the outer variables to be used in constructing process. 
	 */
	public void getFileInfo(){
		int id;
		int arrival;
		int completion;
		int segmentCount;
		int memory;
		int count = 0;
		try{
			Scanner input = new Scanner(new File("C:/Users/chupp/Java workspace/Program3_MemoryManager/src/virtual/in1.dat"));
			do{
				if(count ==0){
					id = input.nextInt();
					System.out.println("Number of process" + id);
					numberOfProcess = id;
					System.out.println("The number of process is: " + numberOfProcess);
				}
				id = input.nextInt();
				System.out.println("The process ID: "+ id);
				processID = id;
				System.out.println("Process Id value is: " + processID);
		
				arrival = input.nextInt();
				System.out.println("Arrival Time: "+ arrival);
				arrivalTime = arrival;
				System.out.println("Value of ArrivalTime "+ arrivalTime);
				
				completion = input.nextInt();
				System.out.println("The completion time: "+ completion);
				completionTime = completion;
				System.out.println("completionTime value is: " + completionTime);
				
				segmentCount = input.nextInt();
				System.out.println("The next  value: "+ segmentCount);
				segmentNumber = segmentCount;
				System.out.println("The segmentNumber value is: " +segmentNumber);
				memory = 0;
				for(int i = 0; i< segmentCount; i++){
					System.out.println("Memory: " + memory);
					if(notSEG == true){
						memory = memory + input.nextInt();
					}
					//else the policy is segemented.
					else{
						segment = new int[10]; //sets the size to 10
						for(i  = 0; i < segmentCount; i++){
							segment[i] = input.nextInt(); //will get the segements into seperate sections
							System.out.println("index: " + i);
							System.out.println("The segment" + segment[i]);// gets each individual segment
					}
				}
					System.out.println("One memory segment size: "+ memory);
				}
				System.out.println("Memory size: "+ memory);
				memorySize = memory;
				System.out.println("Value of Memory Size is: "+ memorySize);
				count++;
			}while (input.hasNext());
			input.close();
		}catch (FileNotFoundException e){
			e.printStackTrace();
		}catch(NoSuchElementException d){
			d.printStackTrace();
		}
	}
	
}