package io.muzoo.ssc.zork.EntityPackage;

public class Guard extends Stats{
    public Guard(){
        name = "Bob";
        description = "A normal looking guard, deals weak attack to the player.";
        hp = 100;
        maxhp = 150;
        attack = 5;
        agility = 0.1;
        defend = 0.2;
        inventory = null;
    }

}
