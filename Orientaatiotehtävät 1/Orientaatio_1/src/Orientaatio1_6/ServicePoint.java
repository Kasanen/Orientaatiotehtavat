package Orientaatio1_6;

import java.util.LinkedList;

public class ServicePoint {
    private LinkedList<Customer> queue;
    private LinkedList<Customer> servedCustomers = new LinkedList<>();

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

    public void serve() {
        while (!queue.isEmpty()) {
            Customer customer = removeFromQueueue();
            if (customer != null) {
                long serviceStart = System.nanoTime();
                int sleeptime = 100 + (int) (Math.random() * 900);
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
                customer.setServiceTime(serviceTime);
                servedCustomers.add(customer);
                long responseTime = serviceEnd - customer.getStartTime();
                System.out.println("Customer " + customer.getId() + " finished. Response time: " + responseTime + " ns, Waiting time: " + waitingTime + " ns, Service time: " + serviceTime + " ns");
            }
        }
    }

    public LinkedList<Customer> getServedCustomers() {
        return servedCustomers;
    }
}
