package io.muzoo.ssc.zork.CommandList;

import io.muzoo.ssc.zork.CommandPackage.Commands;
import io.muzoo.ssc.zork.MapPackage.MapGeneration;
import io.muzoo.ssc.zork.MapPackage.Room;
import io.muzoo.ssc.zork.Output;
import io.muzoo.ssc.zork.ZorkGame;

import java.util.Arrays;

public class goCommand extends Commands {

    private ZorkGame game;
    public goCommand(ZorkGame game){
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
                else ZorkGame.currentRoom = room.neighbours.get(direction);
                {
                    Output.displayRoom();

                    if(ZorkGame.player.hp < ZorkGame.player.maxhp){
                        if(ZorkGame.player.hp + 10 >= ZorkGame.player.maxhp){
                            ZorkGame.player.hp = 150;
                            System.out.println("You have regenerated to your max HP level");
                            return;
                        }

                        ZorkGame.player.hp += 10;
                        System.out.println("You have generated 10hp, your current hp is: " + ZorkGame.player.hp);
                    }
                    else {
                        return;
                    }
                    return;
                }
            }
        }

    }

    @Override
    public String getCmd(){
        return "move";
    }
}