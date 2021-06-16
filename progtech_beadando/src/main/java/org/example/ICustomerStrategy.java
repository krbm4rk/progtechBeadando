package org.example;

public interface ICustomerStrategy {
    void pay (Console console, double balance, int amount) throws PayFailed;
    void deleteOrder();
}
