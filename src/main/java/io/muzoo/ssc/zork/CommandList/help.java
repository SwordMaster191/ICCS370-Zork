package io.muzoo.ssc.zork.CommandList;

import io.muzoo.ssc.zork.Command.CommandFactory;
import io.muzoo.ssc.zork.Command.Commands;
import io.muzoo.ssc.zork.ZorkGame;

public class help extends Commands {

    private ZorkGame game;

    public help(ZorkGame game){
        this.game = game;
    }

    @Override
    public int numArgs(){
        return 0;
    }

    @Override
    public String desc(){
        return "Shows the help command.";
    }

    @Override
    public void execute(ZorkGame game, String[] array){
        for(String cmd: CommandFactory.getCommandMap().keySet()){
            game.display.println(cmd + ": " + CommandFactory.getCommandMap().get(cmd).desc());
        }
    }

    @Override
    public String getCmd(){
        return "help";
    }

}
