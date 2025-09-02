
class Customer {
    private static int nextId = 1;
    private int id;
    private long startTime;
    private long endTime;

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

    public long getTimeSpent(){
        return this.endTime - this.startTime;
    }
}


public class OrientationTask1_3 {
    public static void main(String[] args) {
        Customer c1 = new Customer();
        Customer c2 = new Customer();
        Customer c3 = new Customer();

        c1.setStartTime(System.currentTimeMillis());
        c2.setStartTime(System.currentTimeMillis());
        c3.setStartTime(System.currentTimeMillis());

        try { Thread.sleep(100); 
        } catch (InterruptedException e) { 
            e.printStackTrace();
        }

        c1.setEndTime(System.currentTimeMillis());
        c2.setEndTime(System.currentTimeMillis());
        c3.setEndTime(System.currentTimeMillis());

        System.out.println("Customer 1 ID: " + c1.getId() + ", Time spent: " + c1.getTimeSpent() + " ms");
        System.out.println("Customer 2 ID: " + c2.getId() + ", Time spent: " + c2.getTimeSpent() + " ms");
        System.out.println("Customer 3 ID: " + c3.getId() + ", Time spent: " + c3.getTimeSpent() + " ms");
    }
}
