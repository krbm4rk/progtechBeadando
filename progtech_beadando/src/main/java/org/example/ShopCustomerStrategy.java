package org.example;

public class ShopCustomerStrategy implements CustomerStrategy {

    MainStock mainStock;

    private boolean deleteOrder=false;
    private Console console;
    private int amount;

    public ShopCustomerStrategy(MainStock mainStock) {
        this.mainStock = mainStock;
    }

    @Override
    public void pay(Console console, double balance, int amount) throws PayFailed{
        this.console = console;
        this.amount = amount;

        if (console.getType() == ProductTypeEnum.Xbox){
            if (console.getPrice()* amount >balance){
                throw new PayFailed("You don't have enough money to pay for the order.");
            }
            for (int i = 0; i < amount; i++) {
                mainStock.getXboxStorage().removeProduct(console.getName());
            }
        }
        else if (console.getType()==ProductTypeEnum.Playstation){
            if (console.getPrice()* amount >balance){
                throw new PayFailed("You don't have enough money to pay for the order.");
            }
            for (int i = 0; i < amount; i++) {
                mainStock.getPlaystationStorage().removeProduct(console.getName());
            }
        }
        deleteOrder = true;
    }

    @Override
    public void deleteOrder() {
        if (deleteOrder){
            if (console.getType()==ProductTypeEnum.Xbox){
                for (int i = 0; i < amount; i++) {
                    mainStock.getXboxStorage().addProduct(console);
                }
            }
            else if (console.getType()==ProductTypeEnum.Playstation){
                for (int i = 0; i < amount; i++) {
                    mainStock.getPlaystationStorage().addProduct(console);
                }
            }
            deleteOrder = true;
        }
    }
}
