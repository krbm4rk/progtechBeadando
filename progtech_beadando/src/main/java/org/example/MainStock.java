package org.example;

import java.util.ArrayList;

public final class MainStock implements ObserverInfo {


    private ArrayList<Observer> observerList = new ArrayList<>();
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
        InformObserverFromConsole(console, amount);}

    @Override
    public void AddObserverToStock(Observer observer) {
    observerList.add(observer);
    }

    @Override
    public void InformObserverFromConsole(Console console, int amount) {
    for (Observer observer:observerList){
        observer.updateConsole(console, amount);
    }
    }

    private static MainStock mainStock =null;

    public static MainStock getInstance(){
        if(mainStock ==null) mainStock = new MainStock();
        return mainStock;
    }
}
