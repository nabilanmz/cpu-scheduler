import java.util.ArrayList;

public class SchedulerView {
	public void printProcessDetails(ArrayList<Process> processes) {
		// Display the table of processes and their details
		System.out.println("\nProcess | Arrival Time | Burst Time | Completion Time | Turnaround Time | Waiting Time");
		for (Process process : processes) {
			System.out.println("P" + process.processId + "      | " + process.arrivalTime + "           | " +
					process.burstTime + "        | " + process.completionTime + "             | " +
					process.turnaroundTime + "            | " + process.waitingTime);
		}
	}

	public void printAverageTimes(double averageTurnaroundTime, double averageWaitingTime) {
		System.out.println("Average Turnaround Time: " + averageTurnaroundTime);
		System.out.println("Average Waiting Time: " + averageWaitingTime);
	}

	public void printGanttChart(ArrayList<Process> processes) {
		// Implement Gantt chart representation if needed
	}
}
