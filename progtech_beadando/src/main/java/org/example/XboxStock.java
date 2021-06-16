package org.example;

import java.util.ArrayList;

public class XboxStock implements IObserver, IProductOperations{

    private final ArrayList<Console> xboxList = new ArrayList<>();
    private MainStock mainStock;

    public XboxStock(MainStock mainStock) {
        this.mainStock = mainStock;
        mainStock.ObserverAdd(this);}

    @Override
    public void update(Console console, int amount) {
        if (console.getType() == ProductTypeEnum.Xbox)
            for (int i = 0; i< amount; i++){
                xboxList.add(console);}
    }

    @Override
    public void addProduct(Console console) {
        this.xboxList.add(console);
    }

    @Override
    public void removeProduct(String name) {
        ArrayList<Console> list = mainStock.getXboxStorage().xboxList;
        for (int i=0;i<list.size();i++){
            if (list.get(i).getName().equals(name)){
                list.remove(i);
                return;
            }
        }
    }

    @Override
    public int getListSize() {
        return xboxList.size();
    }
}
