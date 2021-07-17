package io.muzoo.ssc.zork.CommandList;

import io.muzoo.ssc.zork.CommandPackage.Commands;
import io.muzoo.ssc.zork.MapPackage.MapGeneration;
import io.muzoo.ssc.zork.MapPackage.Room;
import io.muzoo.ssc.zork.ZorkGame;
public class attackCommand extends Commands {

    private ZorkGame game;

    public attackCommand(ZorkGame game){
        this.game = game;
    }

    @Override
    public String desc(){
        return "Attack the enemy with a specified weapon";
    }

    @Override
    public String getCmd() {
        return "attack";
    }

    @Override
    public void execute(ZorkGame game, String[] string){
        String weapon = "sword";
        String currentRoom = ZorkGame.currentRoom;

        for (Room room: MapGeneration.listOfRoom){
            if(ZorkGame.currentRoom.equals(room.name)){
                if (room.enemy == null) {
                    System.out.println("===============================");
                    System.out.println("Good news! I've scouted left and right and there seems to be no enemy in this room!");
                    return;
                }

            }
        }
        if (string.length < 2) {
            System.out.println("Invalid attack command, please use <attack [weapon]> to attack!");
            return;
        }

        ZorkGame.battleStatus = 1;
        System.out.println("There are enemy in this room, launching attack...");
        ZorkGame.battleMechanic(string[0], string[1]);

    }
}
