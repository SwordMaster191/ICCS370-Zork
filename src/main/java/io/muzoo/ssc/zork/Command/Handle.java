package io.muzoo.ssc.zork.Command;


public class Handle { //get player input
    public String[] parser(String input){
        return input.trim().split(" ");
    }
}
