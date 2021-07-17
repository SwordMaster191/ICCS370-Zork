package io.muzoo.ssc.zork.CommandList;

import io.muzoo.ssc.zork.CommandPackage.Commands;
import io.muzoo.ssc.zork.Output;
import io.muzoo.ssc.zork.ZorkGame;

import java.io.FileNotFoundException;

public class runCommand extends Commands {
    private ZorkGame game;
    public runCommand(ZorkGame game){
        this.game = game;
    }
    @Override
    public String desc() {
        return "Run away from current battle, will lose progress on existing enemy.";
    }

    @Override
    public String getCmd() {
        return "run";
    }

    @Override
    public void execute(ZorkGame game, String[] array) throws FileNotFoundException {
        System.out.println("Running away from current battle...");
        ZorkGame.battleStatus = 0;
        Output.displayRoom();

    }
}
