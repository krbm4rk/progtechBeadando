package org.example;

public class Customer {
    private String cusName;
    private String cusAddress;
    private double cusBalance;
    Order orders;

    public Customer(String cusName, String cusAddress, double cusBalance, ICustomerStrategy customerStrategy) {
        this.cusName = cusName;
        this.cusAddress = cusAddress;
        this.cusBalance = cusBalance;
        this.orders = new Order(MainStock.getInstance(),customerStrategy);
    }

    public String getCusName() {
        return cusName;
    }

    public String getCusAddress() {
        return cusAddress;
    }

    public double getCusBalance() {
        return cusBalance;
    }


    public Invoice Order(Console console, double balance, int amount) throws PayFailed{
        Invoice invoice = new Invoice(getCusName(),getCusAddress(),amount, console);
        orders.order(console,balance,amount);
        return invoice;
    }

    public void deleteOrder(){orders.delete();
    }
}
