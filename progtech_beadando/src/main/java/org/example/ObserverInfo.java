package org.example;

public interface ObserverInfo {
    void AddObserverToStock(Observer observer);
    void InformObserverFromConsole(Console console, int amount);
}
