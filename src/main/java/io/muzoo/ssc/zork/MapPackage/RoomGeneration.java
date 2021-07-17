package io.muzoo.ssc.zork.MapPackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import io.muzoo.ssc.zork.EntityPackage.*;
import io.muzoo.ssc.zork.ItemPackage.ItemGeneration;


public class RoomGeneration extends Room{

    public String enemy = "";
    public String item = "";
    public ArrayList<Room> create(String filename) throws FileNotFoundException {
        ArrayList<Room> rooms = new ArrayList<Room>();
        File filePath= new File("D://MUIC//OOC//ICCS370-Zork//src//main//resources//" + filename);
        System.out.println(filePath.getName());
        Scanner scanner = new Scanner(filePath);


        while (scanner.hasNext()) {
            Room room = new Room();
            room.name = scanner.nextLine();
            room.desc = scanner.nextLine();

            String[] entity = scanner.nextLine().split(",");
            item = entity[0];
            if(item.equals("ITEM")) room.item = null;
            else room.item = ItemGeneration.createItem(item);
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
