package fulfillment;

public class Order {
    // TODO: Apply encapsulation rules here (private and final modifiers)
    private final String orderId;
    private final String customerEmail;
    private boolean isShipped;

    /**
     * Constructor to initialize a new Base Order.
     */
    public Order(String orderId, String customerEmail) {
        // TODO: Bind parameters to fields and establish the baseline state
        this.orderId = orderId;
        this.customerEmail = customerEmail;
        this.isShipped = false;
    }

    /**
     * Updates the internal state of the order to shipped.
     * Guard clause protects against double-shipping.
     */
    public void shipOrder() {
        // TODO: Implement the defensive guard clause throwing IllegalStateException
        if (isShipped){
            throw new IllegalStateException("Order has already been shipped");
        }
        // TODO: Update the state safely if guard clause passes
        this.isShipped = true;
    }

    // --- Public Getters ---

    // TODO: Implement public String getOrderId()
    public String getOrderId(){
        return this.orderId;
    }
    // TODO: Implement public String getCustomerEmail()
    public String getCustomerEmail(){
        return this.customerEmail;
    }
    // TODO: Implement public boolean isShipped() (Watch the naming convention!)

    public boolean isShipped() {
        return isShipped;
    }
}