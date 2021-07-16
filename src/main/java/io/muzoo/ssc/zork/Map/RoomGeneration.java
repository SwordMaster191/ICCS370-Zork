package io.muzoo.ssc.zork.Map;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import io.muzoo.ssc.zork.EntityPackage.*;


public class RoomGeneration extends Room{

    private static String enemy = "";
    public static ArrayList<Room> create(String filename) throws FileNotFoundException {
        ArrayList<Room> rooms = new ArrayList<Room>();
        File filePath= new File("D://MUIC//OOC//ICCS370-Zork//src//main//resources//" + filename);
        System.out.println(filePath.getName());
        Scanner scanner = new Scanner(filePath);


        while (scanner.hasNext()) {
            Room room = new Room();
            room.name = scanner.nextLine();
            room.desc = scanner.nextLine();

            //skip items and monsters for now
            String[] entity = scanner.nextLine().split(",");
            enemy = entity[1];

            if (enemy.equals("MONSTER")) room.enemy = null;
            else room.enemy = monsterGeneration.createEnemy();

            String[] line = scanner.nextLine().split(",");

            room.neighbours.put("north", line[0]);
            room.neighbours.put("east", line[1]);
            room.neighbours.put("south", line[2]);
            room.neighbours.put("west", line[3]);

            rooms.add(room);

        }
        scanner.close();

        return rooms;
    }

    public String getEnemy() {
        return this.enemy;
    }
}
