package io.muzoo.ssc.zork.CommandList;

import io.muzoo.ssc.zork.Command.Commands;
import io.muzoo.ssc.zork.ZorkGame;

public class exit extends Commands {

    private ZorkGame game;

    public exit(ZorkGame game){
        this.game = game;
    }

    @Override
    public int numArgs(){
        return 0;
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
