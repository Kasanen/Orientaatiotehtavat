package Orientaatio3_6;

import eduni.distributions.*;

class Clock {

    private int currentTime;

    public Clock() {
        currentTime = 0;
    }

    public int getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(int time) {
        currentTime = time;
    }

    public void advanceTime(int amount) {
        currentTime += amount;
    }
}

class ArrivalProcess {

    private Uniform uniform;

    public ArrivalProcess(double min, double max) {
        uniform = new Uniform(min, max);
    }

    // Generate next inter-arrival time
    public double nextInterArrivalTime() {
        return uniform.sample();
    }

}

public class TestProgram {

    // Private static member to hold the unique instance
    private static TestProgram instance;

    private Clock clock;
    private ArrivalProcess arrivalProcess;

    // Private constructor to prevent instantiation from outside
    private TestProgram() {
        clock = new Clock();
        arrivalProcess = new ArrivalProcess(0, 10);
    }

    // Public static method to access the unique instance
    public static TestProgram getInstance() {
        if (instance == null) {
            instance = new TestProgram();
        }
        return instance;
    }

    public void simulateArrivals(int count) {
        System.out.println("Simulating " + count + " arrivals:");
        for (int i = 0; i < count; i++) {
            double interArrival = arrivalProcess.nextInterArrivalTime();
            clock.advanceTime((int) interArrival);
            System.out.println("Customer " + (i + 1) + " arrived at time " + clock.getCurrentTime() + " (interval: " + interArrival + ")");
        }
    }

    public static void main(String[] args) {
        TestProgram program = TestProgram.getInstance();
        program.simulateArrivals(5);
    }

    // Other methods and properties of the Singleton class
}
