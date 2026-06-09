# Java_Inheritance-Encapsulation

🛒 Greenfield Lab: E-Commerce Fulfillment System Invariants
📖 The Scenario
You have joined an engineering team building a brand-new internal Order Fulfillment System for an e-commerce platform.

A junior developer pushed initial code changes, but the architecture is completely vulnerable. 
Currently, any external system can bypass tracking logic and change critical fields like isShipped manually. 
Even worse, our application allows orders to be marked as "Shipped" multiple times without state tracking validation, 
which will cause real-world double-shipping financial losses!

Your task is to refactor and implement the core engineering rules inside the fulfillment package to secure our application architecture.

🛠️ Step-by-Step Technical Requirements
1. Specifications for Order.java
   Field Configuration (Encapsulation):

Change the visibility modifiers of the three declared fields (orderId, customerEmail, and isShipped) to private.

Mark the identity fields (orderId and customerEmail) as immutable using the final modifier.

Constructor Logic:

Map the incoming constructor arguments explicitly to the instance fields using the this reference keyword.

Explicitly set the internal state flag this.isShipped to false to define the baseline invariant state.

State Mutation Logic (shipOrder()):

Implement a defensive guard clause at the very top of the method using an if condition.

If this.isShipped evaluates to true, instantly halt execution by throwing a new IllegalStateException with the exact literal string: "Order has already been shipped".

If the guard clause passes, alter the internal object state by assigning this.isShipped = true;.

API Accessors (Getters):

Implement public getters that precisely return their corresponding private field data.

Crucial Naming Rule: Ensure your boolean accessor matches the standard Java bean naming convention (public boolean isShipped()) rather than a generic get prefix.

2. Specifications for ExpressOrder.java
   Class Architecture (Inheritance):

Modify the class header to establish a strict parent-child hierarchy by inheriting from Order.

Subclass Field Isolation:

Declare an internal field named guaranteedDeliveryDays of type int.

Enforce strict encapsulation rules by marking it private and final.

Constructor Chaining:

Inside the ExpressOrder constructor block, your absolute first instruction must be an upstream invocation to the parent class constructor using super().

Polymorphic Overriding (toString()):

Implement a public toString() method that returns a descriptive layout string.

Place the @Override metadata annotation directly above the method declaration.

Encapsulation Constraint: Because the parent class properties are sealed under private access modifiers, 
you must access them polymorphically by executing the inherited public getter methods: getOrderId() and getCustomerEmail().