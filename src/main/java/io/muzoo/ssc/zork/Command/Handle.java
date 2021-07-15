package io.muzoo.ssc.zork.Command;


public class Handle {
    public String[] parser(String input){
        return input.trim().split(" ");
    }
}
