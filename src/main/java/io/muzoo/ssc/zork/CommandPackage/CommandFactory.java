
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
        commandMap.put("end", new endCommand(game));
        commandMap.put("play", new playCommand(game));
        commandMap.put("move", new goCommand(game));
        commandMap.put("attack", new attackCommand(game));
        commandMap.put("use", new useCommand(game));
        commandMap.put("take", new takeCommand(game));
        commandMap.put("drop", new dropCommand(game));

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