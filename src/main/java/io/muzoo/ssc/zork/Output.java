package io.muzoo.ssc.zork;

import io.muzoo.ssc.zork.MapPackage.MapGeneration;
import io.muzoo.ssc.zork.MapPackage.Room;

public class Output {
    public void print(String msg){
        System.out.print(msg);
    }
    public void println(String msg){
        System.out.println(msg);
    }

    public static void display(){
        System.out.println("Welcome to Zork!");
        System.out.println("");
        System.out.println("<play <map>> to play the game.");
        System.out.println("<load <name>> to load from a save.");
        System.out.println("<help> to see list of commands.");
        System.out.println("<exit> to quit the game.");
        System.out.println("");
    }

    public static void displayRoom(){
        System.out.println("Current room: " + ZorkGame.currentRoom);

        for(Room room: MapGeneration.listOfRoom){
            if(ZorkGame.currentRoom.equals(room.name)){
                System.out.println(room.name);
                System.out.println(room.desc);
                System.out.println("");
                System.out.println("Where you can go: " + room.neighbours);
            }
        }
    }

    public static void displayMap(){
        if(MapGeneration.file.equals("map1.txt")){
            System.out.println("Now playing: Map 1");

            ZorkGame.currentRoom = MapGeneration.listOfRoom.get(0).name;
            System.out.println(MapGeneration.listOfRoom.get(0).name);
            System.out.println(MapGeneration.listOfRoom.get(0).desc);

            System.out.println("Where you can go: " + MapGeneration.listOfRoom.get(0).neighbours);
        }
    }

    public static void displayBattle(){
        for(Room room: MapGeneration.listOfRoom){
            if(ZorkGame.currentRoom.equals(room.name)){
                System.out.println("You have encountered an enemy: " + room.enemy.name);
                System.out.println(room.enemy.description);

                System.out.println("\nWhat will you do?");
                System.out.println("<attack>, <use>, <help>");
            }
        }
    }

}