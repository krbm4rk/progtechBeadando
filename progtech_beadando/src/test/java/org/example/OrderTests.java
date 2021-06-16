package org.example;

import org.junit.Assert;
import org.junit.Test;

public class OrderTests {

    MainStock mainStock = MainStock.getInstance();

    @Test
    public void OrderPlaystationTest() throws PayFailed{
        mainStock.ConsoleImported(new Console(ProductTypeEnum.Playstation,"Playstation 3", 145000),
                new ConsoleSupplier("Konzolvilág","Budapest","0614451777"), 500);
        int expected = mainStock.getPlaystationStorage().getListSize()-5;
        Customer customer = new Customer("Simon", "Szügy", 8000000, new PersonCustomerStrategy(mainStock));
        customer.Order(new Console(ProductTypeEnum.Playstation,"Playstation 3", 145000), customer.getCusBalance(),5);
        int actual = mainStock.getPlaystationStorage().getListSize();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void OrderXboxTest() throws PayFailed{
        mainStock.ConsoleImported(new Console(ProductTypeEnum.Xbox,"Xbox 360", 87990),
                new ConsoleSupplier("Konzolvilág","Budapest","0614451777"), 500);
        int expected = mainStock.getXboxStorage().getListSize()-2;
        Customer customer = new Customer("Márk", "Szügy", 200000, new PersonCustomerStrategy(mainStock));
        customer.Order(new Console(ProductTypeEnum.Xbox,"Xbox 360", 87990), customer.getCusBalance(),2);
        int actual = mainStock.getXboxStorage().getListSize();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void DeletePlaystationOrder() throws PayFailed{
        mainStock.ConsoleImported(new Console(ProductTypeEnum.Playstation,"Playstation 4", 116000),
                new ConsoleSupplier("Konzolvilág","Budapest","0614451777"), 500);
        int expected = mainStock.getPlaystationStorage().getListSize();
        Customer customer = new Customer("Simon", "Szügy", 400000, new PersonCustomerStrategy(mainStock));
        customer.Order(new Console(ProductTypeEnum.Playstation,"Playstation 4", 150000), customer.getCusBalance(),2);
        customer.deleteOrder();
        int actual = mainStock.getPlaystationStorage().getListSize();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void DeleteXboxOrder() throws PayFailed{
        mainStock.ConsoleImported(new Console(ProductTypeEnum.Xbox,"Xbox One", 116000),
                new ConsoleSupplier("Konzolvilág","Budapest","0614451777"), 500);
        int expected = mainStock.getPlaystationStorage().getListSize();
        Customer customer = new Customer("Márk", "Szügy", 600000, new PersonCustomerStrategy(mainStock));
        customer.Order(new Console(ProductTypeEnum.Xbox,"Xbox One", 116000), customer.getCusBalance(),4);
        customer.deleteOrder();
        int actual = mainStock.getPlaystationStorage().getListSize();
        Assert.assertEquals(expected, actual);
    }
}

