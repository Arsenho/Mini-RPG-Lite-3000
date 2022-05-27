package com.isep.rpg;

public class Food implements Consumable {
    private int efficiency;

    public Food(){

    }
    public Food(int efficiency){
        this.efficiency = efficiency;
    }

    @Override
    public void changeEfficiency(int consumableEfficiency) {
        this.efficiency = consumableEfficiency;
    }

    public int getEfficiency() {
        return efficiency;
    }

}
