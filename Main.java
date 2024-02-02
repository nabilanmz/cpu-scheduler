import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<Process> processes = new ArrayList<>();

		System.out.println("Enter quantum time:");
		int quantumTime = scanner.nextInt();

		System.out.println("Enter number of processes (between 3 and 10):");
		int processCount = scanner.nextInt();

		for (int i = 0; i < processCount; i++) {
			System.out.println("Enter arrival time for process " + (i + 1) + ":");
			int arrivalTime = scanner.nextInt();
			System.out.println("Enter burst time for process " + (i + 1) + ":");
			int burstTime = scanner.nextInt();
			processes.add(new Process(i + 1, arrivalTime, burstTime));
		}

		SchedulerView view = new SchedulerView();
		SchedulerController controller = new SchedulerController(processes, quantumTime, view);
		controller.schedule();
	}
}
