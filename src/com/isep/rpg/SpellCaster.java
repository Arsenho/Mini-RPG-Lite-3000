package com.isep.rpg;

public abstract class SpellCaster extends Hero{
    protected  int manaPoints;

    public int getManaPoints(){
        return this.manaPoints;
    }

    public void setManaPoints(int manaPoints){
        this.manaPoints = manaPoints;
    }

    public void castSpell(String spellType){
        switch (spellType){
            case "ORDINARY":
                if(canCastSpell(spellType))
                    this.manaPoints -= 5;
                break;
            case "SUPER":
                if(canCastSpell(spellType))
                    this.manaPoints -= 10;
                break;
        }
    }

    public boolean canCastSpell(String spellType){
        boolean res = false;
        switch (spellType){
            case "ORDINARY":
                if (this.manaPoints >= 5)
                    res = true;
                break;
            case "SUPER":
                if (this.manaPoints >= 10)
                    res = true;
                break;
        }
        return res;
    }
}
