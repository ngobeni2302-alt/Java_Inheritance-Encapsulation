package fulfillment;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Testing Base Order Protection ---");
        Order standardOrder = new Order("ORD-101", "alice@example.com");
        System.out.println("Shipped status before: " + standardOrder.isShipped());

        standardOrder.shipOrder();
        System.out.println("Shipped status after: " + standardOrder.isShipped());

        try {
            System.out.println("Attempting to ship again (Should fail)...");
            standardOrder.shipOrder();
        } catch (IllegalStateException e) {
            System.out.println("Success! Caught expected security breach: " + e.getMessage());
        }

        System.out.println("\n--- Testing Subclass Inheritance ---");
        ExpressOrder express = new ExpressOrder("EXP-999", "bob@example.com", 1);
        System.out.println(express.toString());
    }
}