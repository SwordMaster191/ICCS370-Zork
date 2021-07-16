package io.muzoo.ssc.zork.Map;

import io.muzoo.ssc.zork.ZorkGame;
import io.muzoo.ssc.zork.Map.*;


import java.io.FileNotFoundException;
import java.util.ArrayList;

public class MapGeneration {
    public static ArrayList<Room> listOfRoom;
    public static String file;
    private static RoomGeneration generateRooms = new RoomGeneration();
    private static Room room;

    public static void map(String[] array) throws FileNotFoundException{
        if(array.length <= 1){
            System.out.println("Please input a map! (Avaliable map: Map1)");
            return;
        }

        if (array[1].equals("map1")){
            file = "map1.txt";
            ZorkGame.gameStatus = 1;
        }
        else {
            System.out.println("Incorrect file/map name!");
            return;
        }

        listOfRoom = generateRooms.create(file);
        room = listOfRoom.get(0);
    }
}

