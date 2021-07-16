package io.muzoo.ssc.zork.CommandList;

import io.muzoo.ssc.zork.Command.Commands;
import io.muzoo.ssc.zork.Map.MapGeneration;
import io.muzoo.ssc.zork.Map.Room;
import io.muzoo.ssc.zork.Output;
import io.muzoo.ssc.zork.ZorkGame;

import java.util.Arrays;

public class moveCommand extends Commands {

    private ZorkGame game;
    public moveCommand(ZorkGame game){
        this.game = game;
    }

    @Override
    public String desc(){
        return "Move to a certain direction specified by the player";
    }

    @Override
    public void execute(ZorkGame game, String[] string){
        if(string.length <= 1){
            System.out.println("Please enter a valid direction! (Example: <go east>)");
            return;
        }

        String currentRoom = ZorkGame.currentRoom;
        String direction = string[1]; //get from input
        String cmp;

        if(!Arrays.asList(new String[]{"north", "east", "south", "west"}).contains(direction)){
            System.out.println("Please enter a valid direction! (Example: <go east>)");
            return;
        }





        for(Room room: MapGeneration.listOfRoom){
            if(room.name.equals(currentRoom)){
                cmp = room.neighbours.get(direction);

                if(cmp.equals("null")) System.out.println("Room does not exist, cannot traverse there!");
                else ZorkGame.currentRoom = room.neighbours.get(direction); Output.displayRoom(); return;
            }
        }

    }

    @Override
    public String getCmd(){
        return "move";
    }
}
