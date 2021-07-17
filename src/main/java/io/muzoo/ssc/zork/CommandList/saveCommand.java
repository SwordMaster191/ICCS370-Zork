package io.muzoo.ssc.zork.CommandList;

import io.muzoo.ssc.zork.CommandPackage.Commands;
import io.muzoo.ssc.zork.ZorkGame;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

public class saveCommand extends Commands {
    private ZorkGame game;

    public saveCommand(ZorkGame game){
        this.game = game;
    }

    @Override
    public String desc() {
        return "Saves the current state of the game.";
    }

    @Override
    public String getCmd() {
        return "save";
    }

    @Override
    public void execute(ZorkGame game, String[] array) throws FileNotFoundException {
        game.save.remove(game.save.size()-1);

        try(FileOutputStream output = new FileOutputStream("//MUIC//OOC//ICCS370-Zork//src//main//resources//zorkSaveGame.txt")){

            Iterator<String> loop = game.save.iterator();
            PrintWriter print = new PrintWriter(output, true);

            while(loop.hasNext()){
                String cmd = loop.next();
                print.println(cmd);
            }
            print.close();

            System.out.println("Save successful!");

        }
        catch(IOException e){
            System.err.println(e);
            return;
        }

    }
}
