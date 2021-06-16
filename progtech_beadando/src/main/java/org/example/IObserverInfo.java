package org.example;

public interface IObserverInfo {
    void ObserverAdd(IObserver observer);
    void ObserverInform(Console console, int quantity);
}
