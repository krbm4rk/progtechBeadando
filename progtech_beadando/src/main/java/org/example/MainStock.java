package org.example;

import java.util.ArrayList;

public final class MainStock implements IObserverInfo {

    static MainStock mainStock =null;

    public static MainStock getInstance(){
        if(mainStock ==null) mainStock = new MainStock();
        return mainStock;
    }
    private ArrayList<IObserver> observerList = new ArrayList<>();
    XboxStock xboxStock;
    PlaystationStock playstationStock;

    private MainStock(){
        this.xboxStock =new XboxStock(this);
        this.playstationStock =new PlaystationStock(this);
    }

    public XboxStock getXboxStorage() {
        return xboxStock;
    }

    public PlaystationStock getPlaystationStorage() {
        return playstationStock;
    }

    public void ConsoleImported(Console console, ConsoleSupplier consoleSupplier, int amount) {
        console.setConsoleSupplier(consoleSupplier);
        ObserverInform(console, amount);}

    @Override
    public void ObserverAdd(IObserver observer) {
    observerList.add(observer);
    }

    @Override
    public void ObserverInform(Console console, int amount) {
    for (IObserver observer:observerList){
        observer.update(console, amount);
    }
    }
}
