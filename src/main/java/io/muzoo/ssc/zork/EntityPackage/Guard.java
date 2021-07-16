package io.muzoo.ssc.zork.EntityPackage;

public class Guard extends Stats{
    public Guard(){
        name = "Bob";
        hp = 100;
        maxhp = 150;
        attack = 10;
        defend = 1;
    }

    public Guard(int hp, int attack, int defend){
        this.hp = hp;
        this.attack = attack;
        this.defend = defend;
    }

}
