
package io.muzoo.ssc.zork.Command;

import io.muzoo.ssc.zork.CommandList.exit;
import io.muzoo.ssc.zork.CommandList.help;
import io.muzoo.ssc.zork.ZorkGame;

import java.util.HashMap;
import java.util.Map;

public class CommandFactory {
    public static Map<String, Commands> commandMap = new HashMap<>();

    public void putInCommand(ZorkGame game){
        commandMap.put("exit", new exit(game));
        commandMap.put("help", new help(game));

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