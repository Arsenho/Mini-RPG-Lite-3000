package com.isep.rpg;

public class Potion implements Consumable{
    private int efficiency;

    public Potion(){

    }
    public Potion(int efficiency){
        this.efficiency = efficiency;
    }

    @Override
    public void changeEfficiency(int consumableEfficiency) {
        this.efficiency = consumableEfficiency;
    }

    public int getEfficiency() {
        return efficiency;
    }

    public void setEfficiency(int efficiency) {
        this.efficiency = efficiency;
    }
}
