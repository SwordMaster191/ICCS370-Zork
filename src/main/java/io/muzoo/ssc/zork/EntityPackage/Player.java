package io.muzoo.ssc.zork.EntityPackage;

import io.muzoo.ssc.zork.ItemPackage.Item;

import java.util.HashMap;

public class Player extends Stats{
    public Player(){
        name = "You";
        hp = 100;
        maxhp = 150;
        agility = 0;
        attack = 10;
        defend = 0.1;
        boss = 0;
        inventory = new HashMap<String, Item>();
    }
}
