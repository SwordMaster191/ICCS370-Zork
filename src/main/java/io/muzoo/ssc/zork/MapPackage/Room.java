package io.muzoo.ssc.zork.MapPackage;


import io.muzoo.ssc.zork.EntityPackage.Stats;
import io.muzoo.ssc.zork.ItemPackage.Item;

import java.util.HashMap;

public class Room {
    public String name;
    public String desc;
    public Stats enemy;
    public Item item;
    public HashMap<String, String> neighbours = new HashMap<String, String>();



}