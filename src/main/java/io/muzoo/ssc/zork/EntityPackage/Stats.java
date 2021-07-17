package io.muzoo.ssc.zork.EntityPackage;

import io.muzoo.ssc.zork.ItemPackage.Item;

import java.util.HashMap;

public abstract class Stats {
    public String name;
    public String description;
    public HashMap<String, Item> inventory;
    public int attack;
    public int defend;
    public int maxhp;
    public int hp;
}
