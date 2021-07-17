package io.muzoo.ssc.zork.CommandList;

import io.muzoo.ssc.zork.CommandPackage.Commands;
import io.muzoo.ssc.zork.ZorkGame;

public class useCommand extends Commands {
    private ZorkGame game;

    public useCommand(ZorkGame game){this.game = game;}


    @Override
    public String desc() {
        return "Use an item on the player.";
    }

    @Override
    public String getCmd() {
        return "use";
    }

    @Override
    public void execute(ZorkGame game, String[] array) {

        if(array.length < 2) {
            System.out.println("Please use the proper format of this command! ([take <item>])");
            return;
        }

        if (ZorkGame.player.inventory.size() == 0){
            System.out.println("Cannot use an item if there's nothing in your inventory to begin with!");
            return;
        }
        else{
            String itemToUse = array[1];
            if (ZorkGame.player.inventory.containsKey(itemToUse)){
                if(ZorkGame.player.inventory.get(itemToUse).itemType == 1){
                    ZorkGame.player.hp += ZorkGame.player.inventory.get(itemToUse).buff;
                    ZorkGame.player.inventory.remove(itemToUse);
                    System.out.println("Used " + ZorkGame.player.inventory.get(itemToUse).name);
                }
                else if(ZorkGame.player.inventory.get(itemToUse).itemType == 0){
                    System.out.println("Error: " + ZorkGame.player.inventory.get(itemToUse) + " is not a valid name of the item!");
                    return;
                }
            }
            else{
                System.out.println("Cannot use as you don't have " + ZorkGame.player.inventory.get(itemToUse).name + " in your inventory!");
                return;
            }
        }




    }
}
