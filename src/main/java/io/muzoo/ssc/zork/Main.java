package io.muzoo.ssc.zork;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        ZorkGame game = new ZorkGame();
        game.loop();
    }
}