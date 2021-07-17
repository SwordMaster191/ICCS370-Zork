package io.muzoo.ssc.zork.EntityPackage;

import io.muzoo.ssc.zork.ItemPackage.Item;

import java.util.HashMap;

public class Player extends Stats{
    public Player(){
        name = "Bob";
        hp = 100;
        maxhp = 150;
        agility = 0;
        attack = 1;
        defend = 1;
        inventory = new HashMap<String, Item>();
    }
}
