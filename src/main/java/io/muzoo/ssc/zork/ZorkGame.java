package io.muzoo.ssc.zork;

import io.muzoo.ssc.zork.Command.Commands;
import io.muzoo.ssc.zork.Command.CommandFactory;
import io.muzoo.ssc.zork.Command.Handle;
import io.muzoo.ssc.zork.EntityPackage.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ZorkGame {

    public static int gameStatus;
    public String[] menu = {"play", "help", "exit", "load"};
    public String[] game = {"move", "map", "end", "save", "attack", "take"};

    public Output display = new Output();
    private final CommandFactory factory = new CommandFactory();
    private final Handle handler = new Handle();
    public static int quitStatus = 0;
    public static Player player = new Player();
    public static String currentRoom;

    public void loop(){

        factory.putInCommand(this);
        Output.display();

        while(true){
            if (gameStatus == 1) inGame();

            Scanner scanner = new Scanner(System.in);
            System.out.print(">");
            String playerOption = scanner.nextLine().toLowerCase();

            String[] words = handler.parser(playerOption);
            System.out.println("You have executed: " + words[0]);

            if(Arrays.asList(menu).contains(words[0])){
                Commands command = factory.lookupExecute(words);
                command.execute(this, words);
            }
            else System.out.println("Invalid command!");
        }
    }

    public void inGame(){
        System.out.println("In game!");
        factory.putInCommand(this);
        Output.displayMap();

        while(true){
            if (quitStatus == 1) return;

            Scanner scanner = new Scanner(System.in);
            System.out.print(">");
            String playerOption = scanner.nextLine().toLowerCase();

            String[] words = handler.parser(playerOption);
            System.out.println("You have executed: " + words[0]);

            if(Arrays.asList(game).contains(words[0])){
                Commands command = factory.lookupExecute(words);
                command.execute(this, words);
            }
            else System.out.println("Invalid command!");

        }
    }
    public void exit(){
        System.exit(0);
    }
}
