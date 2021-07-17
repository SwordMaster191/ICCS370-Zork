package io.muzoo.ssc.zork;

import io.muzoo.ssc.zork.CommandPackage.Commands;
import io.muzoo.ssc.zork.CommandPackage.CommandFactory;
import io.muzoo.ssc.zork.CommandPackage.Handle;
import io.muzoo.ssc.zork.EntityPackage.Player;
import io.muzoo.ssc.zork.ItemPackage.Item;
import io.muzoo.ssc.zork.ItemPackage.Sword;
import io.muzoo.ssc.zork.MapPackage.MapGeneration;
import io.muzoo.ssc.zork.MapPackage.Room;

import java.util.Arrays;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.ArrayList;

public class ZorkGame {

    public static int gameStatus;
    public String[] menu = {"play", "help", "exit", "load"};
    public String[] game = {"go", "map", "quit", "save", "attack", "take", "use"};
    public String[] attack = {"attack", "help", "use"};

    public Output display = new Output();
    public ArrayList<String> save = new ArrayList<String>();

    private final CommandFactory factory = new CommandFactory();
    private final Handle handler = new Handle();

    public static int quitStatus = 0;
    public static int battleStatus = 0;
    public static Player player = new Player();
    public static String currentRoom;

    public void loop() throws FileNotFoundException{

        factory.putInCommand(this);
        Output.display();

        while(true){
            if (gameStatus == 1) inGame();

            Scanner scanner = new Scanner(System.in);
            System.out.print(">");
            String playerOption = scanner.nextLine().toLowerCase();
            save.add(playerOption);
            String[] words = handler.parser(playerOption);
            System.out.println("You have executed: " + words[0]);

            if(Arrays.asList(menu).contains(words[0])){
                Commands command = factory.lookupExecute(words);
                command.execute(this, words);
            }
            else System.out.println("Invalid command!");
        }
    }

    public void inGame() throws FileNotFoundException{
        System.out.println("In game!");
        factory.putInCommand(this);
        Output.displayMap();

        while(gameStatus == 1){
            if (quitStatus == 1) break;
            if(battleStatus == 1) inBattle();

            Scanner scanner = new Scanner(System.in);
            System.out.print(">");
            String playerOption = scanner.nextLine().toLowerCase();
            save.add(playerOption);
            String[] words = handler.parser(playerOption);
            System.out.println("You have executed: " + words[0]);

            if(Arrays.asList(game).contains(words[0])){
                Commands command = factory.lookupExecute(words);
                command.execute(this, words);
            }
            else System.out.println("Invalid command!");

        }
    }

    public static void battleMechanic(String command, String item){
        Item weapon = new Sword();
        String currentRoom = ZorkGame.currentRoom;

        if(item.equals("sword") || item.equals("Sword")) System.out.println("Equipping sword");
        else if(player.inventory.containsKey(item)){
            if (player.inventory.get(item).itemType == 0){
                weapon = player.inventory.get(item);
                System.out.println("Equipped: " + weapon.name);
            }
            else if (player.inventory.get(item).itemType == 1){
                System.out.println("Cannot equip " + player.inventory.get(item).name + " because it is not a weapon, will use sword.");
            }
        }
        else if(ZorkGame.player.inventory.size() == 0) System.out.println("Nothing is in inventory, will use sword.");
        else if(!player.inventory.containsKey(item)) System.out.println("Weapon does not exist in inventory, will use sword");

        for (Room room: MapGeneration.listOfRoom){
            if (currentRoom.equals(room.name) && room.enemy != null){

                Random rng = new Random();

                int maxPlayerAttack = (int) (weapon.debuff - (weapon.debuff * room.enemy.defend)); //Weapon attack - (Attack * def% of enemy) = max dmg u can deal to enemy
                int minPlayerAttack = (int) (0.6 * maxPlayerAttack);
                //player attack = Minimum player attack + differences between max and min * rng
                int playerAttack = (int) (minPlayerAttack + (maxPlayerAttack - minPlayerAttack) * rng.nextDouble());

                //chances that player will hit based on agility percentage.
                double hitChance = (1 - room.enemy.agility);
                if(hitChance <= 0.3){//30% to hit always, if lower, increase the number to 0.4.
                    hitChance += 0.3;
                }

                int randomto100 = rng.nextInt(100-0+1) + 0;

                if (randomto100 >= hitChance*100){
                    System.out.println("You missed!");
                }
                else{
                    System.out.println("===============================");
                    System.out.println("Attacking: " + room.enemy.name);
                    System.out.println(("Weapon of choice: " + weapon.name));
                    room.enemy.hp = room.enemy.hp - playerAttack;
                    System.out.println("===============================");
                    System.out.println("Success!");
                    System.out.println("Damage dealt to " + room.enemy.name + ": " + playerAttack + "\n");
                    System.out.println("===============================");

                }

                int maxEnemyAttack = (int) (room.enemy.attack - (room.enemy.attack * player.defend));
                int minEnemyAttack = (int) (0.6 * maxEnemyAttack);

                int enemyAttack = (int) (minEnemyAttack + (maxEnemyAttack-minEnemyAttack) * rng.nextDouble());

                double enemyHitChance = (1-player.agility);

                if (enemyHitChance < 0.3){
                    enemyHitChance+=0.3;
                }

                randomto100 = rng.nextInt(100-0+1) + 0;
                System.out.println("===============================");
                if (randomto100 >= enemyHitChance) System.out.println("The enemy missed their attack on you");
                else{
                    ZorkGame.player.hp = ZorkGame.player.hp - enemyAttack;

                    System.out.println("In return, you receive " + enemyAttack + " from " + room.enemy.name);

                }
                System.out.println("===============================");
/*




                if (ZorkGame.player.hp <= 0){
                    System.out.println("You died, game's over!");
                    System.out.println("You will be returned to the menu shortly...");
                    ZorkGame.quitStatus = 1;
                    ZorkGame.battleStatus = 0;
                    Output.display();
                    return;
                }*/

                if(room.enemy.hp <= 0){
                    System.out.println("You're winner, you have defeated " + room.enemy.name + "!");
                    room.enemy = null;
                    return;
                }
            }

        }

    }

    public void inBattle() throws FileNotFoundException{
        while(battleStatus == 1){
            Output.displayBattle();

            Scanner scanner = new Scanner(System.in);
            System.out.print(">");
            String playerOption = scanner.nextLine().toLowerCase();
            save.add(playerOption);
            String[] words = handler.parser(playerOption);
            System.out.println("You have executed: " + words[0]);

            if(Arrays.asList(attack).contains(words[0])){
                Commands command = factory.lookupExecute(words);
                if (words.length < 2) System.out.println("Invalid move, please try again! (Type <help> for assistance)");
                else if(words[0].equals("use") || words[0].equals("attack")) battleMechanic(words[0], words[1]);
                else command.execute(this, words);
            }
            else System.out.println("Invalid command!");
        }


    }

    public void exit(){
        System.exit(0);
    }
}
