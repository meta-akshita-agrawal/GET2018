import java.util.Scanner;

public class JobScheduler {

	// Returns turn around time of a process.
	public int turnAroundTime(int completionTime, int arrivalTime) {
		int turnAroundTime = Math.abs(completionTime - arrivalTime);
		return turnAroundTime;
	}

	//Returns completion time of a process.
	public int completionTime(int index, int[][] processArray) {
		int completionTime = 0;
		for (int i = 0; i <= index; i++) {
			completionTime += processArray[i][1];
		}
		return completionTime;
	}

	//Returns waiting time of a process
	public int waitingTime(int turnAroundTime, int burstTime) {
		int waitingTime = Math.abs(turnAroundTime - burstTime);
		return waitingTime;
	}

	//Returns maximum waiting time of processes
	public int maxWaitingTime(int[] waitingTime) {
		int maximum = waitingTime[0];
		for (int i = 0; i < waitingTime.length; i++) {
			if (waitingTime[i] > maximum) {
				maximum = waitingTime[i];
			}
		}
		return maximum;
	}

	//Returns average time of processes.
	public double averageWait(int[] waitingTime) {
		double average = 0;
		for (int i = 0; i < waitingTime.length; i++) {
			average += waitingTime[i];
		}
		average = average / waitingTime.length;
		return average;
	}

	
	
	public void main(String args[]) {
		int[][] processArray;

		JobScheduler jsobj = new JobScheduler();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of processes you have.");

		int size = sc.nextInt();
		
		
		//Initializing array
		processArray = new int[size][2];

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < 2; j++) {
				processArray[i][j] = sc.nextInt();
			}
		}

		//Initializing each array for turn around, waiting, completion time
		int[] turnAroundTime = new int[size];
		int[] completionTime = new int[size];
		int[] waitingTime = new int[size];
		completionTime[0] = 0;

		for (int i = 0; i < size; i++) {
			completionTime[i] += jsobj.completionTime(i, processArray);
			turnAroundTime[i] = jsobj.turnAroundTime(completionTime[i],
					processArray[i][0]);
			waitingTime[i] = jsobj.waitingTime(turnAroundTime[i], processArray[i][1]);
		}

		//Printing out.
		
		System.out.println("PID\tAT\tBT\tCT\tTAT\tWT");
		System.out.println("-------------------------------------");

		for (int i = 0; i < size; i++) {
			System.out.println(i + "\t" + processArray[i][0] + "\t"
					+ processArray[i][1] + "\t" + completionTime[i] + "\t"
					+ turnAroundTime[i] + "\t" + waitingTime[i]);
		}

		System.out.println("-------------------------------------");

		System.out.println("AVERAGE WAITING TIME: " + jsobj.averageWait(waitingTime));
		System.out.println("MAXIMUM WAITING TIME: "
				+ jsobj.maxWaitingTime(waitingTime));
		sc.close();

	}
}
