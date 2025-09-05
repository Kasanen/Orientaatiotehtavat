package Orientaatio3_5;

class Clock {

    private int currentTime;

    private Clock() {
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

public class TestProgram {

    // Private static member to hold the unique instance
    private static TestProgram instance;

    // Private constructor to prevent instantiation from outside
    private TestProgram() {
    }

    // Public static method to access the unique instance
    public static TestProgram getInstance() {
        if (instance == null) {
            instance = new TestProgram();
        }
        return instance;
    }

    // Other methods and properties of the Singleton class
}
