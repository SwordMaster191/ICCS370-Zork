
package io.muzoo.ssc.zork.Command;

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
        commandMap.put("move", new moveCommand(game));
<<<<<<< HEAD
        commandMap.put("attack", new attackCommand(game));
=======
>>>>>>> 3597c58a74f553191ccddb999ac3145955354e16

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