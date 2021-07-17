package io.muzoo.ssc.zork.CommandList;

import io.muzoo.ssc.zork.CommandPackage.Commands;
import io.muzoo.ssc.zork.ZorkGame;

public class infoCommand extends Commands {
    private ZorkGame game;

    public infoCommand(ZorkGame game){
        this.game = game;
    }

    @Override
    public String desc(){
        return "Display statistic of the game, such as player, room and the monster/item in the room.";
    }

    @Override
    public String getCmd() {
        return "info";
    }

    @Override
    public void execute(ZorkGame game, String[] array){
        System.out.println("");
        System.out.println("=====Player statistic=====");
        System.out.println("Health Point (HP): " + game.player.hp);
        System.out.println("Defense point: " + game.player.defend);
        System.out.println("=====Room statistic=====");
        game.display.displayRoom();
        System.out.println("=====Inventory statistic=====");

        for (String key: game.player.inventory.keySet()){
            System.out.println((game.player.inventory.get(key).name) + ": " + game.player.inventory.get(key).description);
        }
        System.out.println("");

    }
}
