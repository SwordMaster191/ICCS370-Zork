package io.muzoo.ssc.zork.CommandList;

import io.muzoo.ssc.zork.CommandPackage.Commands;
import io.muzoo.ssc.zork.ZorkGame;

import java.io.FileNotFoundException;

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

    }
}
