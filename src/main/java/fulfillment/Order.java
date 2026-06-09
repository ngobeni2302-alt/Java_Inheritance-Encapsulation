package fulfillment;

public class Order {
    // TODO: Apply encapsulation rules here (private and final modifiers)
    String orderId;
    String customerEmail;
    boolean isShipped;

    /**
     * Constructor to initialize a new Base Order.
     */
    public Order(String orderId, String customerEmail) {
        // TODO: Bind parameters to fields and establish the baseline state
    }

    /**
     * Updates the internal state of the order to shipped.
     * Guard clause protects against double-shipping.
     */
    public void shipOrder() {
        // TODO: Implement the defensive guard clause throwing IllegalStateException

        // TODO: Update the state safely if guard clause passes
    }

    // --- Public Getters ---

    // TODO: Implement public String getOrderId()

    // TODO: Implement public String getCustomerEmail()

    // TODO: Implement public boolean isShipped() (Watch the naming convention!)
}