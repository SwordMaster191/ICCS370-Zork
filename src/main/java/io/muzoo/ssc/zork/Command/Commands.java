package io.muzoo.ssc.zork.Command;

import io.muzoo.ssc.zork.ZorkGame;

public abstract class Commands {
    public abstract int numArgs();
    public abstract String desc();
    public abstract String getCmd();
    public abstract void execute(ZorkGame game, String[] array);
}
