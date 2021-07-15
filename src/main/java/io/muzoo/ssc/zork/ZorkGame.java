package io.muzoo.ssc.zork;

import io.muzoo.ssc.zork.Command.Commands;
import io.muzoo.ssc.zork.Command.CommandFactory;
import io.muzoo.ssc.zork.Command.Handle;

import java.util.Scanner;

public class ZorkGame {

    public Output display = new Output();
    private final CommandFactory factory = new CommandFactory();
    private final Handle handler = new Handle();

    public void loop(){
        factory.putInCommand(this);
        Output.display();

        while(true){
            Scanner scanner = new Scanner(System.in);
            System.out.print(">");
            String playerOption = scanner.nextLine();

            String[] words = handler.parser(playerOption);
            System.out.println(words[0]);
            Commands command = factory.lookupExecute(words);

            command.execute(this, words);
        }
    }
    public void exit(){
        System.exit(0);
    }
}
