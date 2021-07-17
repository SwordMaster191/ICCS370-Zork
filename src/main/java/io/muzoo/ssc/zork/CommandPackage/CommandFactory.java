
package io.muzoo.ssc.zork.CommandPackage;

import io.muzoo.ssc.zork.CommandList.*;
import io.muzoo.ssc.zork.ZorkGame;

import java.util.HashMap;
import java.util.Map;

public class CommandFactory {
    public static Map<String, Commands> commandMap = new HashMap<>();

    public void putInCommand(ZorkGame game){
        commandMap.put("exit", new exitCommand(game));
        commandMap.put("help", new helpCommand(game));
        commandMap.put("quit", new quitCommand(game));
        commandMap.put("play", new playCommand(game));
        commandMap.put("go", new goCommand(game));
        commandMap.put("attack", new attackCommand(game));
        commandMap.put("use", new useCommand(game));
        commandMap.put("take", new takeCommand(game));
        commandMap.put("drop", new dropCommand(game));
        commandMap.put("info", new infoCommand(game));
        commandMap.put("load", new loadCommand(game));
        commandMap.put("save", new saveCommand(game));
        commandMap.put("run", new runCommand(game));

    }
    public static Map<String, Commands> getCommandMap() {
        return commandMap;
    }


    public static Commands lookupExecute(String[] array){
        for (String key: commandMap.keySet()) {
            if (array[0].equals(key))
                return commandMap.get(key);
        }
        return null;
    }
}