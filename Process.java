// Process.java
public class Process {
    int processId;
    int arrivalTime;
    int burstTime;
    int remainingBurstTime;
    int completionTime;
    int turnaroundTime;
    int waitingTime;

    // Constructor, getters, and setters
    public Process(int processId, int arrivalTime, int burstTime) {
        this.processId = processId;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.remainingBurstTime = burstTime;
    }

    // Add getters and setters here
}
