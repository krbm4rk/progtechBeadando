package org.example;

public class ConsoleSupplier {

    private String suppName;
    private String address;
    private String phoneNumber;

    public String getSuppName() {
        return suppName;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public ConsoleSupplier(String suppName, String address, String phoneNumber) {
        this.suppName = suppName;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

}
