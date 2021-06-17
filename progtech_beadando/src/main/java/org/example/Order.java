package org.example;

public class Order{
    MainStock mainStock;
    CustomerStrategy customerStrategy;

    public Order(MainStock mainStock, CustomerStrategy customerStrategy) {
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

