package io.muzoo.ssc.zork.CommandList;

import io.muzoo.ssc.zork.CommandPackage.Commands;
import io.muzoo.ssc.zork.ZorkGame;

public class exitCommand extends Commands {

    private ZorkGame game;

    public exitCommand(ZorkGame game){
        this.game = game;
    }

    @Override
    public String desc(){
        return "Quits the game";
    }

    @Override
    public void execute(ZorkGame game, String[] array){
        game.display.println("Exiting game");
        game.exit();
    }

    @Override
    public String getCmd(){
        return "exit";
    }

}