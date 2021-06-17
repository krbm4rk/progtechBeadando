package org.example;

import java.util.ArrayList;

public class PlaystationStock implements Observer, ProductOperations {

    private final ArrayList<Console> playstationList = new ArrayList<>();
    private MainStock mainStock;

    public PlaystationStock(MainStock mainStock) {
        this.mainStock = mainStock;
        mainStock.AddObserverToStock(this);}

    @Override
    public void updateConsole(Console console, int amount) {
        if (console.getType() == ProductTypeEnum.Playstation)
            for (int i = 0; i< amount; i++){
                playstationList.add(console);}
    }

    @Override
    public void addProduct(Console console) {
        this.playstationList.add(console);
    }

    @Override
    public void removeProduct(String name) {
        ArrayList<Console> list = mainStock.getPlaystationStorage().playstationList;
        for (int i=0;i<list.size();i++){
            if (list.get(i).getName().equals(name)){
                list.remove(i);
                return;
            }
        }
    }

    @Override
    public int getListSize() {
        return playstationList.size();
    }
}
