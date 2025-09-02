import java.util.LinkedList;
import java.util.Scanner;

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

public class OrientationTask1_4 {
    public static void main(String[] args) {
        LinkedList<Customer> queue = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("Queue program. Select an action by number:");
        System.out.println("1 - Queue (add customer)\n2 - Dequeue (remove customer)\n3 - Exit");
        while (running) {
            System.out.print("Selection (1/2/3): ");
            String input = scanner.nextLine().trim();
            switch (input) {
                case "1":
                    Customer c = new Customer();
                    c.setStartTime(System.nanoTime());
                    queue.addFirst(c);
                    System.out.println("Customer " + c.getId() + " added to queue.");
                    break;
                case "2":
                    if (queue.isEmpty()) {
                        System.out.println("Queue is empty.");
                    } else {
                        Customer removed = queue.removeLast();
                        removed.setEndTime(System.nanoTime());
                        long timeSpent = removed.getTimeSpent();
                        System.out.println("Customer " + removed.getId() + " removed. Time spent in queue: " + timeSpent + " ns");
                    }
                    break;
                case "3":
                    running = false;
                    break;
                default:
                    System.out.println("Unknown selection. Please type 1, 2, or 3.");
            }
        }
        scanner.close();
        System.out.println("Program ended.");
    }
}
