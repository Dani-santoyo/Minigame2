package Minigame2.View;
/**Class: Software Development I
 * @author Daniel Santoyo
 * @version 1.0
 * Course: ITEC 3860 Summer 2024
 * Written: 6/5, 2024
 * Submachine.SubmachineMain.Submachine.java - a class that represents a text-based game called Submachine
 * where the aim is to escape without dying. There are various methods here that serve the purpose for starting the game
 * and keeping the game running and collecting input from the user.
 * VIEW
 */

import Minigame2.Controller.Game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Submachine {


    public static String runCommand(String inputStr, Game game) {
        String s;
        List<String> wordList;
        String lowStr = inputStr.trim().toLowerCase();

        if (lowStr.equals("")) {
            s = "You must enter a command";
        } else {

            s = game.processVerb(lowStr, game.getPlayer());
        }

        return s;
    }

    public static void intro() throws IOException{
        String input;
        BufferedReader in = new BufferedReader((new InputStreamReader(System.in)));
        String greeting = "Welcome adventurer to 'Submachine: The Game'! " +
                "\n Enter 'e' to start: ";
        String instructions = "Submachine is a text based adventure game, move through the rooms by entering:" +
                "\n 'n' to go North, 's' to go South, 'e' to go East, 'w' to go West, 'u' to go Up, and 'd' to go Down." +
                "\n You can enter the following commands at any point: " +
                "\n - 'take' to grab any item in the room." +
                "\n - 'drop' to drop any item from your inventory." +
                "\n - 'backpack' to check your inventory." +
                "\n - 'look' to check what room you are in"+
                "\n - 'inspect' to check for any items in the room." +
                "\n - 'q' to quit the game." +
                "\n - 'commands' to repeat this list of commands." +
                "\n" +
                "\n Please enter 'e' to start: ";

        System.out.println(greeting);
        System.out.print("> ");
        input = in.readLine();
        if (!"e".equals(input)){
            System.exit(0);
        }
        System.out.println(instructions);
        System.out.print("> ");
        input = in.readLine();
        if (!"e".equals(input)){
            System.exit(0);
        }


    }
    public static void main (String[] args) throws IOException {

        BufferedReader in;
        String input;
        String output;

        in = new BufferedReader((new InputStreamReader(System.in)));
        intro();
        Game game = new Game();
        System.out.println(game.getPlayer().getRoom());
        do{
            System.out.print("> ");
            input = in.readLine();
            output = runCommand(input, game);
            System.out.println(output);
        }while(!"q".equals(input));
    }
}
