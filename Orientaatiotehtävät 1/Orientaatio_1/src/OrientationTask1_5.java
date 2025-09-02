import java.util.LinkedList;

class CustomerGenerator {
    public static void generateCustomers(ServicePoint servicePoint, int count) {
        for (int i = 0; i < count; i++) {
            Customer c = new Customer();
            c.setStartTime(System.nanoTime());
            servicePoint.addToQueueue(c);
        }
    }
}

class ServicePoint {
    public void serve() {
        while (!queue.isEmpty()) {
            Customer customer = removeFromQueueue();
            if (customer != null) {
                long serviceStart = System.nanoTime();
                int sleeptime = 100 + (int)(Math.random() * 900);
                System.out.println("Serving customer " + customer.getId() + " (service time: " + sleeptime + " ms)");
                try {
                    Thread.sleep(sleeptime);
                } catch (InterruptedException e) {
                    System.out.println("Service interrupted for customer " + customer.getId());
                }
                long serviceEnd = System.nanoTime();
                customer.setEndTime(serviceEnd);
                long waitingTime = serviceStart - customer.getStartTime();
                long serviceTime = serviceEnd - serviceStart;
                long responseTime = serviceEnd - customer.getStartTime();
                System.out.println("Customer " + customer.getId() + " finished. Response time: " + responseTime + " ns, Waiting time: " + waitingTime + " ns, Service time: " + serviceTime + " ns");
            }
        }
    }
    private LinkedList<Customer> queue;

    public ServicePoint(LinkedList<Customer> queue) {
        this.queue = queue;
    }

    public void addToQueueue(Customer a) {
        queue.addFirst(a);
    }

    public Customer removeFromQueueue() {
        if (queue.isEmpty()) {
            return null;
        }
        return queue.removeLast();
    }
}


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

public class OrientationTask1_5 {
    public static void main(String[] args) {
        LinkedList<Customer> queue = new LinkedList<>();
        ServicePoint servicePoint = new ServicePoint(queue);

        int customerCount = 5; 
        CustomerGenerator.generateCustomers(servicePoint, customerCount);

        servicePoint.serve();

        System.out.println("All customers served. Program ended.");
    }
}
