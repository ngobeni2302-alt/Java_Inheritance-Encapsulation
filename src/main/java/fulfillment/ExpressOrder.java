package fulfillment;

// TODO: Establish inheritance relationship with Order
public class ExpressOrder extends Order{

    // TODO: Declare a private final int field named guaranteedDeliveryDays
    public final int guaranteedDeliveryDays;
    /**
     * Constructor for ExpressOrder.
     */
    public ExpressOrder(String orderId, String customerEmail, int guaranteedDeliveryDays) {
        // TODO: Perform constructor chaining to the parent class first
        super(orderId, customerEmail);

        // TODO: Assign the local subclass field
        this.guaranteedDeliveryDays = guaranteedDeliveryDays;
    }

    // TODO: Implement public int getGuaranteedDeliveryDays()
    public int getGuaranteedDeliveryDays() {
        return this.guaranteedDeliveryDays;
    }
    @Override

    public String toString(){
        return "ExpressOrder [ID="+getOrderId() +", Email='"+getCustomerEmail()+"', Days="+this.guaranteedDeliveryDays+"]";
    }
    // TODO: Override the default toString() method using public getters from the parent
    // Exact format expected: "ExpressOrder [ID=xxx, Email='xxx', Days=x]"
}