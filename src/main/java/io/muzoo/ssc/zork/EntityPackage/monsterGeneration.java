package io.muzoo.ssc.zork.EntityPackage;

import io.muzoo.ssc.zork.MapPackage.RoomGeneration;

public class monsterGeneration {

    private static RoomGeneration roomGenerate = new RoomGeneration();
    public static String enemy = roomGenerate.getEnemy();

    public static Stats createEnemy(){
        if(enemy.equals("Guard")) {
            return new Guard();
        }
        if(enemy.equals("Ninja")){
            return new Ninja();
        }
        return null;
    }
}
