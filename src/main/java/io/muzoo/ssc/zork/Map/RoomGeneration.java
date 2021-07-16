package io.muzoo.ssc.zork.Map;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
<<<<<<< HEAD
import io.muzoo.ssc.zork.EntityPackage.*;
=======
>>>>>>> 3597c58a74f553191ccddb999ac3145955354e16


public class RoomGeneration extends Room{

<<<<<<< HEAD
    private static String enemy = "";
=======

>>>>>>> 3597c58a74f553191ccddb999ac3145955354e16
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
<<<<<<< HEAD
            String[] entity = scanner.nextLine().split(",");
            enemy = entity[1];

            if (enemy.equals("MONSTER")) room.enemy = null;
            else room.enemy = monsterGeneration.createEnemy();
=======
            scanner.nextLine();
>>>>>>> 3597c58a74f553191ccddb999ac3145955354e16

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
<<<<<<< HEAD

    public String getEnemy() {
        return this.enemy;
    }
=======
>>>>>>> 3597c58a74f553191ccddb999ac3145955354e16
}
