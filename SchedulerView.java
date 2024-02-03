import java.util.ArrayList;

public class SchedulerView {
	public void printProcessDetails(ArrayList<Process> processes) {
		// Display the table of processes and their details
		System.out.println(
				"\nProcess\t| Arrival Time\t| Burst Time\t| Finishing Time\t| Turnaround Time\t| Waiting Time");
		for (Process process : processes) {
			System.out.println("P" + process.processId + "\t| " + process.arrivalTime + "\t\t| " +
					process.burstTime + "\t\t| " + process.completionTime + "\t\t\t| " +
					process.turnaroundTime + "\t\t\t| " + process.waitingTime);
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
