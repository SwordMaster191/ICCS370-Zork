package io.muzoo.ssc.zork.CommandList;

import io.muzoo.ssc.zork.CommandPackage.CommandFactory;
import io.muzoo.ssc.zork.CommandPackage.Commands;
import io.muzoo.ssc.zork.CommandPackage.Handle;
import io.muzoo.ssc.zork.ZorkGame;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class loadCommand extends Commands {
    public ZorkGame game;

    public loadCommand(ZorkGame game){
        this.game = game;
    }

    @Override
    public String desc() {
        return "Load a save from a file.";
    }

    @Override
    public String getCmd() {
        return "load";
    }

    @Override
    public void execute(ZorkGame game, String[] array) throws FileNotFoundException {
        Handle handler = new Handle();
        CommandFactory factory = new CommandFactory();

        try{
            String path = "D://MUIC//OOC//ICCS370-Zork//src//main//resources//zorkSaveGame.txt";
            File file= new File(path);

            Scanner scanner = new Scanner(file);

            while(scanner.hasNext()){
                String commandExecute = scanner.nextLine();
                System.out.println(commandExecute);
                String[] word = handler.parser(commandExecute);
                Commands cmd = factory.lookupExecute(word);
                cmd.execute(game, word);
            }

        }
        catch (IOException e){
            System.err.println(e);
        }
    }
}
