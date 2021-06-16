package org.example;

import org.junit.Assert;
import org.junit.Test;

public class InvoiceTest {

    MainStock mainStock = MainStock.getInstance();

    @Test
    public void GiveInvoice() throws PayFailed{
        Console console = new Console(ProductTypeEnum.Xbox, "Xbox 360", 87990);
        mainStock.ConsoleImported(console, new ConsoleSupplier("Konzolvilág","Budapest","0614451777"), 500);
        Customer customer = new Customer("Márk", "Szügy", 352000, new PersonCustomerStrategy(mainStock));
        Invoice actual = customer.Order(console, customer.getCusBalance(),4);
        Invoice expected = new Invoice("Márk", "Szügy", 4, console);
        Assert.assertEquals(expected, actual);
    }
}
