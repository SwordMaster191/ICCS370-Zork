package io.muzoo.ssc.zork;

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
        System.out.println("play <map> to play the game.");
        System.out.println("load <name> to load from a save.");
        System.out.println("");
    }

}
