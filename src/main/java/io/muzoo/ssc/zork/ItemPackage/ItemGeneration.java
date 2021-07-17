package io.muzoo.ssc.zork.ItemPackage;

import io.muzoo.ssc.zork.EntityPackage.Stats;
import io.muzoo.ssc.zork.EntityPackage.Ninja;
import io.muzoo.ssc.zork.MapPackage.RoomGeneration;

public class ItemGeneration {
    private static RoomGeneration roomGenerate = new RoomGeneration();

    public static Item createItem(String item){
        if(item.equals("Medkit")){
            return new Medkit();
        }
        if(item.equals("Greatsword")){
            return new Greatsword();
        }
        if(item.equals("Armor")){
            return new Armor();
        }
        if(item.equals("Smite")){
            return new Smite();
        }
        return null;
    }
}
