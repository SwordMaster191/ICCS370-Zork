package io.muzoo.ssc.zork.CommandList;

import io.muzoo.ssc.zork.Command.CommandFactory;
import io.muzoo.ssc.zork.Command.Commands;
import io.muzoo.ssc.zork.ZorkGame;
import io.muzoo.ssc.zork.Map.MapGeneration;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

public class playCommand extends Commands {
    private ZorkGame game;
    public static String[] array;
    private Map<String, Commands> commandMap;
    MapGeneration generate = new MapGeneration();
    private CommandFactory commandFactory;

    public playCommand(ZorkGame game){
        this.game = game;
    }

    @Override
    public String desc(){
        return "Initializes the game.";
    }

    @Override
    public void execute(ZorkGame game, String[] array){
        this.array = array;

        try{
            generate.map(array);
            ZorkGame.gameStatus = 1;
            ZorkGame.quitStatus = 0;

        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

<<<<<<< HEAD
    @Override
    public String getCmd(){
        return "play";
    }
}
=======
   @Override
   public String getCmd(){
        return "play";
   }
}
>>>>>>> 3597c58a74f553191ccddb999ac3145955354e16
