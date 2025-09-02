package Orientaatio1_6;
import java.util.LinkedList;

import Customer;

public class OrientationTask1_6 {

    public static void main(String[] args) {
        LinkedList<Customer> queue = new LinkedList<>();
        ServicePoint servicePoint = new ServicePoint(queue);

        int customerCount = 5;
        CustomerGenerator.generateCustomers(servicePoint, customerCount);

        servicePoint.serve();

        LinkedList<Customer> served = servicePoint.getServedCustomers();
        long totalServiceTime = 0;
        for (Customer c : served) {
            totalServiceTime += c.getServiceTime();
        }
        double avgServiceTime = served.isEmpty() ? 0 : (double) totalServiceTime / served.size();
        System.out.println("Average service time: " + avgServiceTime + " ns");

        System.out.println("All customers served. Program ended.");
    }
}
