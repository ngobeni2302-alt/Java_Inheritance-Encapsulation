package fulfillment;

import org.junit.jupiter.api.Test;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import static org.junit.jupiter.api.Assertions.*;

public class OrderTest {

    @Test
    public void testOrderFieldsArePrivateAndFinal() throws NoSuchFieldException {
        Field idField = Order.class.getDeclaredField("orderId");
        Field emailField = Order.class.getDeclaredField("customerEmail");
        Field shippedField = Order.class.getDeclaredField("isShipped");

        // Verify all fields are strictly private
        assertTrue(Modifier.isPrivate(idField.getModifiers()), "orderId must be private");
        assertTrue(Modifier.isPrivate(emailField.getModifiers()), "customerEmail must be private");
        assertTrue(Modifier.isPrivate(shippedField.getModifiers()), "isShipped must be private");

        // Verify identifiers are final (immutable)
        assertTrue(Modifier.isFinal(idField.getModifiers()), "orderId must be final");
        assertTrue(Modifier.isFinal(emailField.getModifiers()), "customerEmail must be final");
    }

    @Test
    public void testInitialOrderState() {
        Order order = new Order("ORD-123", "test@example.com");
        assertEquals("ORD-123", order.getOrderId());
        assertEquals("test@example.com", order.getCustomerEmail());
        assertFalse(order.isShipped(), "New orders must default to an un-shipped state");
    }

    @Test
    public void testSuccessfulOrderShipping() {
        Order order = new Order("ORD-123", "test@example.com");
        order.shipOrder();
        assertTrue(order.isShipped(), "State flag must register as true after shipping process completes");
    }

    @Test
    public void testDoubleShippingThrowsException() {
        Order order = new Order("ORD-123", "test@example.com");
        order.shipOrder(); // First shipment passes safely

        // Second shipment must trigger defensive state block
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> {
            order.shipOrder();
        });

        assertEquals("Order has already been shipped", exception.getMessage(),
                "The exception message must explicitly match structural business rules");
    }

    @Test
    public void testExpressOrderInheritanceAndPolymorphism() {
        ExpressOrder expressOrder = new ExpressOrder("EXP-555", "speedy@example.com", 2);

        // Test parent getters work via inheritance
        assertEquals("EXP-555", expressOrder.getOrderId());
        assertEquals("speedy@example.com", expressOrder.getCustomerEmail());
        assertEquals(2, expressOrder.getGuaranteedDeliveryDays());

        // Test custom overriding format requirements
        String expectedString = "ExpressOrder [ID=EXP-555, Email='speedy@example.com', Days=2]";
        assertEquals(expectedString, expressOrder.toString(), "toString layout formatting mismatch");
    }
}