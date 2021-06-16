package org.example;

import java.util.Objects;

public class Console {

    private ProductTypeEnum type;
    private String name;
    private double price;
    ConsoleSupplier consoleSupplier;

    public Console(ProductTypeEnum type, String name, double price){
        this.type=type;
        this.name=name;
        this.price=price;
    }

    public void setConsoleSupplier(ConsoleSupplier consoleSupplier){this.consoleSupplier = consoleSupplier;}

    public ProductTypeEnum getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Console console = (Console) o;
        return Double.compare(console.price, price) == 0 &&
                Objects.equals(name, console.name) &&
                type == console.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, type);
    }
}
