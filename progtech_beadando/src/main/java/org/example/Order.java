package org.example;

public class Order{
    MainStock mainStock;
    ICustomerStrategy customerStrategy;

    public Order(MainStock mainStock, ICustomerStrategy customerStrategy) {
        this.mainStock = mainStock;
        this.customerStrategy = customerStrategy;
    }

    public void order(Console console, double balance, int amount) throws PayFailed{
        customerStrategy.pay(console,balance,amount);
    }

    public void delete() {
        customerStrategy.deleteOrder();
    }
}

