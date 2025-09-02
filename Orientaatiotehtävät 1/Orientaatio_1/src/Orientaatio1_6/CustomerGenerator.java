package Orientaatio1_6;

import Customer;

public class CustomerGenerator {
    public static void generateCustomers(ServicePoint servicePoint, int count) {
        for (int i = 0; i < count; i++) {
            Customer c = new Customer();
            c.setStartTime(System.nanoTime());
            servicePoint.addToQueueue(c);
        }
    }
}
