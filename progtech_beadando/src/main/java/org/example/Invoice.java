package org.example;

import java.util.Objects;

public class Invoice {
    private String customerName;
    private String customerAddress;
    private int amount;
    private Console console;

    public Invoice(String customerName, String customerAddress, int amount, Console console) {
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.amount = amount;
        this.console = console;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Console getProduct() {
        return console;
    }

    public void setProduct(Console console) {
        this.console = console;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "customerName='" + customerName + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                ", amount=" + amount +
                ", console=" + console +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invoice invoice = (Invoice) o;
        return amount == invoice.amount &&
                Objects.equals(customerName, invoice.customerName) &&
                Objects.equals(customerAddress, invoice.customerAddress) &&
                Objects.equals(console, invoice.console);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerName, customerAddress, amount, console);
    }
}
