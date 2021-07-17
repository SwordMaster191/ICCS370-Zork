package io.muzoo.ssc.zork.CommandList;

import io.muzoo.ssc.zork.CommandPackage.Commands;
import io.muzoo.ssc.zork.ZorkGame;

public class dropCommand extends Commands {
    private ZorkGame game;

    public dropCommand(ZorkGame game){
        this.game = game;
    }

    @Override
    public String desc(){
        return("Drops a specified item from the inventory. The item will be lost forever..");
    }

    @Override
    public String getCmd() {
        return "drop";
    }

    @Override
    public void execute(ZorkGame game, String[] array){
        if (array.length < 2) {
            System.out.println("Invalid drop command, please try again with <drop [item]>!");
            return;
        }
        if (ZorkGame.player.inventory.size() == 0) {
            System.out.println("Nothing to drop! (No item in inventory)");
            return;
        }
        else{
            String itemToDrop = array[1];
            if (ZorkGame.player.inventory.containsKey(itemToDrop)){
                ZorkGame.player.inventory.remove(itemToDrop);
                System.out.println("Successfully dropped " + ZorkGame.player.inventory.get(itemToDrop).name);
                return;
            }
            else if(!ZorkGame.player.inventory.containsKey(itemToDrop)){
                System.out.println("Item " + ZorkGame.player.inventory.get(itemToDrop).name + " is not in inventory!");
                return;
            }
        }
    }
}
