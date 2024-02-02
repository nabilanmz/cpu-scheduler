import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class SchedulerController {
	private ArrayList<Process> processes;
	private int quantumTime;
	private SchedulerView view;

	public SchedulerController(ArrayList<Process> processes, int quantumTime, SchedulerView view) {
		this.processes = processes;
		this.quantumTime = quantumTime;
		this.view = view;
	}

	public void schedule() {
		Queue<Process> queue = new LinkedList<>();
		ArrayList<Process> processesInQueue = new ArrayList<>();

		// Sort processes by arrival time
		processes.sort((p1, p2) -> p1.arrivalTime - p2.arrivalTime);

		int currentTime = 0;
		int processesCompleted = 0;
		int index = 0; // To keep track of the process that needs to be added to the queue next

		// Loop until all processes are completed
		while (processesCompleted < processes.size()) {
			// Check and add processes to the queue based on the current time
			while (index < processes.size() && processes.get(index).arrivalTime <= currentTime) {
				if (!processesInQueue.contains(processes.get(index))) {
					queue.add(processes.get(index));
					processesInQueue.add(processes.get(index));
				}
				index++;
			}

			if (!queue.isEmpty()) {
				Process currentProcess = queue.poll();

				// Calculate the execution time for the current process
				int executionTime = Math.min(quantumTime, currentProcess.remainingBurstTime);
				currentProcess.remainingBurstTime -= executionTime;
				currentTime += executionTime; // Update current time

				// Check if the process has finished execution
				if (currentProcess.remainingBurstTime == 0) {
					currentProcess.completionTime = currentTime;
					currentProcess.turnaroundTime = currentProcess.completionTime - currentProcess.arrivalTime;
					currentProcess.waitingTime = currentProcess.turnaroundTime - currentProcess.burstTime;
					processesCompleted++;
				} else {
					// Check for new arrivals before re-queueing the current process
					for (int i = index; i < processes.size(); i++) {
						if (processes.get(i).arrivalTime <= currentTime
								&& !processesInQueue.contains(processes.get(i))) {
							queue.add(processes.get(i));
							processesInQueue.add(processes.get(i));
							index = i + 1;
						}
					}
					// If the process still has burst time left, add it back to the queue
					queue.add(currentProcess);
				}
			} else {
				// If the queue is empty, increment the current time
				currentTime++;
			}
		}

		// After scheduling, calculate total and average times
		calculateResults();
	}

	private void calculateResults() {
		int totalTurnaroundTime = 0, totalWaitingTime = 0;
		for (Process process : processes) {
			totalTurnaroundTime += process.turnaroundTime;
			totalWaitingTime += process.waitingTime;
		}
		double averageTurnaroundTime = (double) totalTurnaroundTime / processes.size();
		double averageWaitingTime = (double) totalWaitingTime / processes.size();

		// Use the view to display results
		view.printProcessDetails(processes);
		view.printAverageTimes(averageTurnaroundTime, averageWaitingTime);
	}
}
