package org.example;

public interface CustomerStrategy {
    void pay (Console console, double balance, int amount) throws PayFailed;
    void deleteOrder();
}
