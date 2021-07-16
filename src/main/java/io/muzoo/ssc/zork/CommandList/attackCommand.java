package io.muzoo.ssc.zork.CommandList;

import io.muzoo.ssc.zork.Command.Commands;
import io.muzoo.ssc.zork.EntityPackage.Stats;
import io.muzoo.ssc.zork.Map.MapGeneration;
import io.muzoo.ssc.zork.Map.Room;
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
            if (currentRoom.equals(room.name) && room.enemy != null){
                System.out.println("===============================");
                System.out.println("Attacking: " + room.enemy.name);
                System.out.println(("Weapon of choice: " + weapon));
                room.enemy.hp = room.enemy.hp - ZorkGame.player.attack;
                ZorkGame.player.hp = ZorkGame.player.hp - room.enemy.attack;
                System.out.println("===============================");
                System.out.println("Success!");
                System.out.println("Damage dealt to " + room.enemy.name + ": " + ZorkGame.player.attack + "\n");
                System.out.println("In return, you receive " + room.enemy.attack + " from " + room.enemy.name);
                System.out.println("===============================");



                if (ZorkGame.player.hp <= 0){
                    System.out.println("You died, game's over!");
                    System.out.println("You will be returned to the menu shortly...");
                    ZorkGame.quitStatus = 1;
                    return;
                }

                if(room.enemy.hp <= 0){
                    System.out.println("You're winner, you have defeated " + room.enemy.name + "!");
                    room.enemy = null;
                    return;
                }
            }

            if (room.enemy == null){
                System.out.println("===============================");
                System.out.println("Good news! I've scouted left and right and there seems to be no enemy in this room!");
                return;
            }
        }
    }
}
