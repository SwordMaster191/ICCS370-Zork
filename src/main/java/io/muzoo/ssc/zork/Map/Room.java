package io.muzoo.ssc.zork.Map;


import io.muzoo.ssc.zork.EntityPackage.Stats;
import java.util.HashMap;
import java.util.List;

public class Room {
    public String name;
    public String desc;
    public Stats enemy;
    public HashMap<String, String> neighbours = new HashMap<String, String>();



}