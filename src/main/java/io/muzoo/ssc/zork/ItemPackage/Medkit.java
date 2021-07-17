package io.muzoo.ssc.zork.ItemPackage;

public class Medkit extends Item{

    public Medkit() {
        itemType = 1;
        name = "Medkit";
        description = "A Medkit, restores 20hp to the player.";
        buff = 20;
        debuff = 0;

    }
}
