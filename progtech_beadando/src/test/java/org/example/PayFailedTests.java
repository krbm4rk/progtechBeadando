package org.example;

import org.junit.Assert;
import org.junit.Test;

public class PayFailedTests {

    MainStock mainStock = MainStock.getInstance();

    @Test
    public void PersonCanPayTest() throws PayFailed{
        Console console = new Console(ProductTypeEnum.Playstation, "Playstation 2", 85900);
        mainStock.ConsoleImported(console, new ConsoleSupplier("Konzolvilág","Budapest","0614451777"), 500);
        int expected = mainStock.getPlaystationStorage().getListSize()-4;
        Customer customer = new Customer("Márk", "Szügy", 344000, new PersonCustomerStrategy(mainStock));
        customer.Order(console, customer.getCusBalance(),4);
        int actual = mainStock.getPlaystationStorage().getListSize();
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = PayFailed.class)
    public void PersonCanNotPayTest() throws PayFailed{
        Console console = new Console(ProductTypeEnum.Playstation, "Playstation 2", 85900);
        mainStock.ConsoleImported(console, new ConsoleSupplier("Konzolvilág","Budapest","0614451777"), 500);
        Customer customer = new Customer("Márk", "Szügy", 30000, new PersonCustomerStrategy(mainStock));
        customer.Order(console, customer.getCusBalance(),4);
    }

    @Test
    public void ShopCanPayTest() throws PayFailed{
        Console console = new Console(ProductTypeEnum.Playstation, "Playstation 2", 85900);
        mainStock.ConsoleImported(console, new ConsoleSupplier("Konzolvilág","Budapest","0614451777"), 500);
        int expected = mainStock.getPlaystationStorage().getListSize()-65;
        Customer customer = new Customer("Alza", "Budapest", 5584000, new ShopCustomerStrategy(mainStock));
        customer.Order(console, customer.getCusBalance(),65);
        int actual = mainStock.getPlaystationStorage().getListSize();
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = PayFailed.class)
    public void ShopCanNotPayTest() throws PayFailed{
        Console console = new Console(ProductTypeEnum.Playstation, "Playstation 2", 85900);
        mainStock.ConsoleImported(console, new ConsoleSupplier("Konzolvilág","Budapest","0614451777"), 500);
        Customer customer = new Customer("Alza", "Budapest", 1000000, new ShopCustomerStrategy(mainStock));
        customer.Order(console, customer.getCusBalance(),100);
    }


}
