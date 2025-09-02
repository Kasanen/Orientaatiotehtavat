package Orientaatio1_6;


public class Customer {
    private static int nextId = 1;
    private int id;
    private long startTime;
    private long endTime;
    private long serviceTime;

    public Customer() {
        this.id = nextId++;
    }

    public int getId() {
        return id;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public long getTimeSpent() {
        return this.endTime - this.startTime;
    }

    public void setServiceTime(long serviceTime) {
        this.serviceTime = serviceTime;
    }

    public long getServiceTime() {
        return serviceTime;
    }
}
