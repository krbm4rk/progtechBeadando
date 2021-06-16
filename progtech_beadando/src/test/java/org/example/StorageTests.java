package org.example;

import org.junit.Assert;
import org.junit.Test;

public class StorageTests
{
    MainStock mainStock = MainStock.getInstance();

    @Test
    public void MainStorageSingleton() {
        MainStock mainStock1 = MainStock.getInstance();
        Object expected = mainStock;
        Object actual = mainStock1;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void XboxStorageTest() {
        int expected = mainStock.getXboxStorage().getListSize() + 500;
        mainStock.ConsoleImported(new Console(ProductTypeEnum.Xbox,"Xbox 360", 87900),
                new ConsoleSupplier("Konzolvilág","Budapest","0614451777"), 500);
        int actual = mainStock.getXboxStorage().getListSize();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void PlaystationStorageTest() {
        int expected = mainStock.getPlaystationStorage().getListSize() + 500;
        mainStock.ConsoleImported(new Console(ProductTypeEnum.Playstation,"Playstation 2", 85990),
                new ConsoleSupplier("Konzolvilág","Budapest","0614451777"), 500);
        int actual = mainStock.getPlaystationStorage().getListSize();
        Assert.assertEquals(expected, actual);
    }

}
