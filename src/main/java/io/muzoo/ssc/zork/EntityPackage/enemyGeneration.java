package io.muzoo.ssc.zork.EntityPackage;

import io.muzoo.ssc.zork.MapPackage.RoomGeneration;

public class enemyGeneration {

    private static RoomGeneration roomGenerate = new RoomGeneration();

    public static Stats createEnemy(String enemy){
        if(enemy.equals("Guard")) {
            return new Guard();
        }
        if(enemy.equals("Ninja")){
            return new Ninja();
        }
        if(enemy.equals("Samurai")){
            return new Samurai();
        }
        return null;
    }
}
