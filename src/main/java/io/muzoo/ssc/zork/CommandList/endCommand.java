package io.muzoo.ssc.zork.CommandList;

import io.muzoo.ssc.zork.Command.Commands;
import io.muzoo.ssc.zork.Output;
import io.muzoo.ssc.zork.ZorkGame;

public class endCommand extends Commands {
    private ZorkGame game;
    public endCommand(ZorkGame game){
        this.game = game;
    }

    @Override
    public String desc(){
        return "Ends the current game session and return to the menu without saving.";
    }

    @Override
    public void execute(ZorkGame game, String[] array){
        System.out.println("Ending game without saving...");
        game.quitStatus = 1;
        System.out.println("");
        Output.display();
    }

    @Override
    public String getCmd(){
        return "quit";
    }

}