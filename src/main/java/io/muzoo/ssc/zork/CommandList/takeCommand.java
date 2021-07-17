package io.muzoo.ssc.zork.CommandList;

import io.muzoo.ssc.zork.CommandPackage.Commands;
import io.muzoo.ssc.zork.ItemPackage.Item;
import io.muzoo.ssc.zork.MapPackage.MapGeneration;
import io.muzoo.ssc.zork.MapPackage.Room;
import io.muzoo.ssc.zork.ZorkGame;

public class takeCommand extends Commands {
    private ZorkGame game;

    public takeCommand(ZorkGame game){
        this.game = game;
    }

    @Override
    public String desc(){
        return "take an item in the room";
    }

    @Override
    public String getCmd() {
        return "take";
    }

    @Override
    public void execute(ZorkGame game, String[] string){
        if(string.length < 2) {
            System.out.println("Please use the proper format of this command! ([take <item>])");
            return;
        }

        String item = string[1];

        for(Room room: MapGeneration.listOfRoom){
            if (room.item == null){
                System.out.println("No item in the current room.");
                return;
            }
            else{
                if(!item.equals(room.item.name.toLowerCase())){
                    System.out.println("Item does not exist in the room!");
                    System.out.println("You can take the following item from this room: " + room.item.name);
                    return;
                }
                if(item.equals(room.item.name.toLowerCase())){
                    Item putInInventory = room.item;
                    game.player.inventory.put(item, putInInventory);
                    room.item = null;
                    System.out.println("You have successfully taken " + room.item.name + " from this room!");
                    return;
                }
            }
        }

    }
}
