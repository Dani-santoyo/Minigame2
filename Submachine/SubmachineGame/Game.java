package Submachine.SubmachineGame;
/**Class: Software Development I
 * @author Daniel Santoyo
 * @version 1.0
 * Course: ITEC 3860 Summer 2024
 * Written: 6/5, 2024
 * Submachine.SubmachineGame.Gamejava - The submachine game class that includes methods to help the navigation mechanics
 * for the game. This class has 4 variables: an Actor type, 2 List<String> types, and an ArrayList<Room> type.
 */

import java.util.*;
import Submachine.SubmachineObjects.Actor;
import Submachine.SubmachineObjects.Item;
import Submachine.SubmachineObjects.Monster;
import Submachine.SubmachineObjects.Room;
import Submachine.globals.Direction;

public class Game {

    private ArrayList<Room>map; // the map - an arrayList of Rooms
    List<Item> inventory = new ArrayList<>(); // the inventory - Player's List of Items

    Actor player;

    Item rod = new Item("rod", "The old fisherman's rod. Usefule for getting stuff out of water.");
    Item gauntlet = new Item("gauntlet","A rusty gauntlet found at the bottom of the cavern river.");
    Item key = new Item("key", "A key retrieved from the attic prisoner. Should open the door south of the Hallway");

    Monster giant = new Monster("giant", "A 10 ft tall behemoth that want's to throw you around " +
            "like one of his toys.", 3);
    Monster spiders = new Monster("spiders", "A group of spiders ready to spin you into their web", 3);

    List<String> commands = new ArrayList<>(Arrays.asList("take", "drop", "look", "attack", "block", "dodge", "backpack",
            "n", "s", "w", "e", "u", "d", "commands", "inspect"));
    List<String> objects = new ArrayList<>(Arrays.asList("gauntlet", "rod", "key"));


    public Game() {
        this.map = new ArrayList<Room>();
        //----constructs a new Adventure----
        //add Rooms to the map

        //Map Index: 0
        map.add(new Room("Hallway",
                "You are in a dimly lit hallway, portraits on the wall with watchful eyes that follow your movement. \n" +
                "The only way out of this creepy place is to find the key to the locked door behind you.\n" +
                "The only other door lies in front of you, unlocked...\n" +
                "You can only move NORTH from here.",
                false, null, null,
                1,Direction.NOEXIT, Direction.NOEXIT, Direction.NOEXIT, Direction.NOEXIT, Direction.NOEXIT));
        //Map Index: 1
        map.add(new Room(" the Main Room",
                "You enter into a big room with very different doors in every direction. \n" +
                "The door to the EAST has a very eerie fog crawling out from underneath it. \n" +
                "The door to the NORTH is surrounded by piles of precious gold coins. \n" +
                "The door to the WEST has what sounds like a child's voice calling out from the other side. \n" +
                "The door to the SOUTH has a sign that reads \"exit\" above it.\n" +
                "Where will you go?\n" +
                "You can move EAST, NORTH, WEST, and SOUTH from here.",
                false, null, null,
                4,0, 2, 3, Direction.NOEXIT, Direction.NOEXIT));
        //Map Index: 2
        map.add(new Room("the Fisherman's Room",
                "The wall's of this room are heavily decorated with trophy's, and old fishing pictures.\n" +
                        "Your eyes settle onto a very unfortunate scene:\n" +
                        "a withered old man struggling to get his last words out on his death bed. \n" +
                        "\"My name is old man Jenkins, I was the greatest fisherman that ever lived.. here son, take my rod. \n" +
                        "I've no need for it anymore...\", the old man mutters as he dissolves into dust.\n" +
                        "Use \"take\" command to pick up the rod.\n" +
                        "You can only go WEST from here.",
                false, rod, null,
                Direction.NOEXIT, Direction.NOEXIT, Direction.NOEXIT, 1, Direction.NOEXIT,Direction.NOEXIT));
        //Map Index: 3
        map.add(new Room("the Psych Ward",
                "There are toys absolutely everywhere in this room. \n" +
                        "There is a small child playing with a stuffed animal in the corner. \n" +
                        "\"There's a toy at the bottom of the cavern river, I want it! I want it!\", the child exclaims. \n" +
                        "As you scan the room you can see a hatch on the floor, almost buried by the toys.\n" +
                        "You can only move DOWN and EAST from here.",
                false, null, null,
                Direction.NOEXIT, Direction.NOEXIT,1, Direction.NOEXIT, Direction.NOEXIT, 5));
        //Map Index: 4
        map.add(new Room("the Spider Room",
                "You walk into a room excited by the idea of potential treasure. \n" +
                        "Unfortunately, all is not as it seems, there is no treasure. \n" +
                        "Instead, glowing red eyes come forward out of the darkness to reveal two monster spiders. \n" +
                        "You can move SOUTH or UP from here.",
                false, null, spiders,
                Direction.NOEXIT, 1, Direction.NOEXIT, Direction.NOEXIT, 6, Direction.NOEXIT));
        //Map Index: 5
        map.add(new Room("the Cavern",
                "As you finish climbing down a dingy sewer ladder you are met with a beautiful cavern, \n" +
                        "glistening with all different types of crystals.\n" +
                        "You hear the squeals of bats flying overhead." +
                        "\nThere is a river at the other end of the cavern.\n" +
                        "You peer over the river and see the \"toy\" that the child was talking about at the bottom of the river. \n" +
                        "Only it's not a toy, it looks to be something else... \n" +
                        "if only you had something to help get it out of the bottom of the water.\n" +
                        "Use the \"take\" command to grab the item at the bottom of the river" +
                        "\nYou can only move UP from here.",
                false, gauntlet,null,
                Direction.NOEXIT, Direction.NOEXIT, Direction.NOEXIT, Direction.NOEXIT, 3, Direction.NOEXIT));
        //Map Index: 6
        map.add(new Room("the Attic Chamber",
                "You are out of breath after climbing a long spiral staircase. \n" +
                        "You are in the attic and there is a cell. \n" +
                        "A prisoner is behind bars its bars as he begs you to free him. \n" +
                        "He promises to give you something in return if you do...",
                false, key,null,
                Direction.NOEXIT, Direction.NOEXIT, Direction.NOEXIT, Direction.NOEXIT, Direction.NOEXIT, 7));
        //Map Index: 7
        map.add(new Room("The Spider Room",
                "As you descend back the winding staircase you are met with the bodies of the spiders you have killed.\n" +
                        "You can only move SOUTH from here.",
                true, null,null,
                Direction.NOEXIT, 1, Direction.NOEXIT,Direction.NOEXIT,Direction.NOEXIT,Direction.NOEXIT));

        player = new Actor("player", "A righteous explorer", map.get(0), inventory, 3 );

    }

    public ArrayList getMap(){
        return map;
    }
    void setMap(ArrayList aMap){
        map = aMap;
    }

    public Actor getPlayer(){
        return player;
    }
    public void setPlayer(Actor aPlayer){
        player = aPlayer;
    }
    //move the player to a room
    public void moveActorTo(Actor p, Room aRoom){
        p.setRoom(aRoom);
    }
    // move an actor in direction 'dir'
    int moveTo(Actor anActor, Direction dir){
         Room r = anActor.getRoom();
         int exit = 0;

         switch (dir) {
             case NORTH:
                 exit = r.getN();
                 break;
             case SOUTH:
                 exit = r.getS();
                 break;
             case EAST:
                 exit = r.getE();
                 break;
             case WEST:
                 exit = r.getW();
                 break;
             case UP:
                 exit = r.getU();
                 break;
             case DOWN:
                 exit = r.getD();
                 break;
             default:
                 exit = Direction.NOEXIT;
                 break;
         }
         if (exit != Direction.NOEXIT){moveActorTo(anActor, map.get(exit));
         }
         return exit;
    }

    public int movePlayerTo(Direction dir){
        return moveTo(player, dir);
    }

    private void goN(){
        updateOutput(movePlayerTo(Direction.NORTH));
    }
    private void goS(){
        updateOutput(movePlayerTo(Direction.SOUTH));
    }
    private void goW(){
        updateOutput(movePlayerTo(Direction.WEST));
    }
    private void goE(){
        updateOutput(movePlayerTo(Direction.EAST));
    }
    private void goU(){
        updateOutput(movePlayerTo(Direction.UP));
    }
    private void goD(){
        updateOutput(movePlayerTo(Direction.DOWN));
    }

    public String inspect(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Which item do you want to inspect?");
        System.out.println(backpack());
        String item = scanner.next();
        String msg;
        String noItemMsg = "You dont have that in your inventory.";
        String itemLow = item.toLowerCase();
        switch (itemLow){
            case "rod":
                if (!player.getInventory().contains(rod)){
                    msg = "You don't have a rod to inspect";
                }else{
                    msg = rod.getDescription();
                }
                break;
            case "gauntlet":
                if (!player.getInventory().contains(gauntlet)){
                    msg = "You don't have a gauntlet to inspect";
                }else{
                    msg = gauntlet.getDescription();
                }
                break;
            case "key":
                if (!player.getInventory().contains(key)){
                    msg = "You don't have a key to inspect";
                }else{
                    msg = key.getDescription();
                }
                break;
            default:
                msg = noItemMsg;
                break;
        }
        return msg;
    }

    public String commands(){
        String instructions = "Submachine is a text based adventure game, move through the rooms by entering:" +
                "\n 'n' to go North, 's' to go South, 'e' to go East, 'w' to go West, 'u' to go Up, and 'd' to go Down." +
                "\n You can enter the following commands at any point: " +
                "\n - 'take' to grab any item in the room." +
                "\n - 'drop' to drop any item from your inventory." +
                "\n - 'backpack' to check your inventory." +
                "\n - 'look' to check what room you are in"+
                "\n - 'inspect' to read the description of an item." +
                "\n - 'q' to quit the game." +
                "\n - 'commands' to repeat this list of commands.";
        return instructions;
    }

    public String freePrisoner() {
        String msg = "";
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you free the prisoner?");
        System.out.print("> ");
        String input = scanner.next();
        String lowInput = input.toLowerCase();
        System.out.println("Please answer 'yes' or 'no'.");

        if (lowInput.equals("yes")) {
            player.getInventory().add(key);
            player.getRoom().setItem(null);
            msg = "You free the prisoner and as promised he gives you a key!"
            + "\n You are in the Attic Chamber and now have a key, you can only move DOWN from here.";
        } else if (lowInput.equals("no")) {
            System.out.println("You tell the poor prisoner that you are glad he is locked up." +
                "\n You would end up spending the rest of your days wandering the rooms, never making it out.."
                + "\n GAME OVER!");
            System.exit(0);
        }else{
            System.out.println(input + " is not an acceptable answer.");
            freePrisoner();
        }

        return msg;
    }

    public String look() {
        String msg = "";
        Room currentRoom = player.getRoom();
        if (currentRoom.getItem() == null) {
            System.out.println(("You are in " +
                    currentRoom.getName()) + "." + currentRoom.getDescription() +
                    "\n There are no items here.");
        } else {
            System.out.println("You are in " +
                    currentRoom.getName() + ". " + currentRoom.getDescription() +
                    "\n There is a "
                    + currentRoom.getItem().getName() + ".");
        }

        return msg;
    }

    public String backpack(){
        String inventory = "";
        if(player.getInventory().isEmpty()){
            inventory += "Your inventory is empty";
        }else if(player.getInventory().size() == 1){
            inventory += "You have a " + player.getInventory().get(0).getName();
        }else if(player.getInventory().size() == 2){
            inventory += "You have a " + player.getInventory().get(0).getName() +
                    " and a " + player.getInventory().get(1).getName();
        }else{
            inventory += "You have a " + player.getInventory().get(0).getName() +
                    ", a " + player.getInventory().get(1).getName() + ", and a " + player.getInventory().get(2).getName();
        }
        return inventory;
    }

    public String drop(String item){
        String msg;
        String noItemMsg = "You dont have that in your inventory.";
        String itemLow = item.toLowerCase();
        switch (itemLow){
            case "rod":
                if (!player.getInventory().contains(rod)){
                    msg = "You don't have a rod to drop";
                }else{
                    player.dropFromInventory(rod);
                    player.getRoom().setItem(rod);
                    msg = "You have dropped a rod in the " + player.getRoom().getName() + ".";
                }
                break;
            case "gauntlet":
                if (!player.getInventory().contains(gauntlet)){
                    msg = "You don't have a gauntlet to drop";
                }else{
                    player.dropFromInventory(gauntlet);
                    player.getRoom().setItem(gauntlet);
                    msg = "You have dropped a gauntlet in the " + player.getRoom().getName() + ".";
                }
                break;
            case "key":
                if (!player.getInventory().contains(key)){
                    msg = "You don't have a key to drop";
                }else{
                    player.dropFromInventory(key);
                    player.getRoom().setItem(key);
                    msg = "You have dropped a key in the " + player.getRoom().getName() + ".";
                }
                break;
            default:
                msg = noItemMsg;
                break;
        }
        return msg;
    }

    public String take(){
        String input;
        String msg;
        String noItemMsg = "That is not in this room";
        Scanner scanner = new Scanner(System.in);
        System.out.println("Which item do you want to take?");
        do{
            System.out.println("> ");
            input = scanner.next();
            if(objects.contains(input)){
                break;
            }
            else{
                System.out.println(noItemMsg);
            }
        }while(!objects.contains(input));

        Room currentRoom = player.getRoom();
        if(currentRoom.getItem() == null){
            System.out.println(("You are in " +
                    currentRoom.getName()) + ", there are no items here.");
        }
        else {
            System.out.println("You are in " +
                    currentRoom.getName() + ", there is a "
                    + currentRoom.getItem().getName() + ".");
        }
        switch(input){
            case "rod":
                if (player.getRoom().getItem() == rod){
                    player.addToInventory(rod);
                    msg = "You take the rod from the dying old man." +
                            "\nYou now have a fishing rod.";
                    player.getRoom().setItem(null);
                }else{
                    msg = noItemMsg;
                }
                break;
            case "gauntlet":
                if(player.getRoom().getItem() == gauntlet){
                    if(!player.getInventory().contains(rod)){
                        msg = "Unsuccessful! If only you had something that could reach the bottom of the river...";
                    }else {
                        player.addToInventory(gauntlet);
                        msg = "You fish the gauntlet out of the river." +
                                "\nYou now have a gauntlet: useful for fighting monsters.";
                        player.getRoom().setItem(null);
                    }
                }else{
                    msg = noItemMsg;
                }
                break;
            case "key":
                if(player.getRoom().getItem() == key){
                    player.addToInventory(key);
                    msg = "You have grabbed a key! Could it be the one that unlocks the hallway door?";
                    player.getRoom().setItem(null);
                }else{
                    msg = noItemMsg;
                }
                break;
            default:
                msg = noItemMsg;
                break;
        }

        return msg;
    }

    void updateOutput(int roomNumber) {
        String s = "";
        if (roomNumber == Direction.NOEXIT) {
            s = "No Exit!";
        } else if (roomNumber == 0 && player.getInventory().contains(key)) {
            String victoryMsg =
                    "You make it back to the main exit and unlock the door with the key!" +
                            "\nCongratulations adventurer, you have beaten Submachine!";
            System.out.println(victoryMsg);
            System.exit(0);
        } else if (roomNumber == 4) {
            if (player.getInventory().contains(gauntlet)) {//Spider fight method
                Room r = getPlayer().getRoom();
                s = "You are in " + r.getName() + ". " + r.getDescription()
                        + ". \nYou defeat the scary spiders with your trusty gauntlet! " +
                        "\nBehind the webs is a staircase with a stranger yelling for help upstairs."
                        + "\nYou can only move UP and SOUTH from here";
            } else {
                String deathMsg =
                        "You walk into a room excited by the idea of potential treasure. \n" +
                                "Unfortunately, all is not as it seems, there is no treasure. \n" +
                                "Instead, glowing red eyes come forward out of the darkness to reveal two monster spiders. \n" +
                        "Without a weapon you are hopeless against the spiders." +
                                "They spin you into their web and eat you for lunch." +
                                "\nGame Over!";
                System.out.println(deathMsg);
                System.exit(0);
            }
        } else if (roomNumber == 2 && player.getRoom().isVisited()) {
            if (player.getRoom().getItem() == null) {
                player.getRoom().setDescription("Nothing here except the empty bed of Old Man Jenkins.");
                Room r = getPlayer().getRoom();
                s = "You are in " + r.getName() + ". " + r.getDescription()
                        + ". \n You have already been to this room" + "\nYou can only move WEST from here.";
            } else {
                player.getRoom().setDescription("Nothing here except the empty bed of Old Man Jenkins and his fishing rod"
                        + "\n You have already been to this room"
                        + "\nYou can only move WEST from here.");
                Room r = getPlayer().getRoom();
                s = "You are in " + r.getName() + ". " + r.getDescription();
            }
        } else if (roomNumber == 3 && player.getRoom().isVisited()) {
            player.getRoom().setDescription("The child is still in the corner whining about the 'toy' at the " +
                    "bottom of the cavern river");
            Room r = getPlayer().getRoom();
            s = "You are in " + r.getName() + ". " + r.getDescription()
                    + ". \n You have already been to this room" + "\nYou can only move EAST and DOWN from here.";
        } else if (roomNumber == 3 && player.getRoom().isVisited() && player.getInventory().contains(gauntlet)) {
            //Giant monster fight method
        }else if(roomNumber == 6){
            if(player.getRoom().isVisited()){ //if attic chamber has been visited
                if(player.getRoom().getItem() == null){ // if main key has been taken
                    player.getRoom().setDescription("Nothing up here but an empty cell. The key taken from" +
                            " the prisoner might be useful somewhere..");
                    Room r = getPlayer().getRoom();
                    s = "You are in " + r.getName() + ". " + r.getDescription();
                }else{ // if main key has not been taken
                    player.getRoom().setDescription("The prisoner is still up here begging to be let out of his cell." +
                            " Maybe you should free him and see what he gives you.");
                    Room r = getPlayer().getRoom();
                    s = "You are in " + r.getName() + ". " + r.getDescription();
                    System.out.println(s);
                    take();
                }
            }else {
                player.getRoom().setDescription("You are out of breath after climbing a long spiral staircase. \n" +
                        "You are in the attic and there is a cell. \n" +
                        "A prisoner is behind bars its bars as he begs you to free him. \n" +
                        "He promises to give you something in return if you do...");
                Room r = getPlayer().getRoom();
                s = "You are in " + r.getName() + ". " + r.getDescription();
                System.out.println(s);
                s = freePrisoner();
            }
        } else{
            Room r = getPlayer().getRoom();
            if(r.isVisited()){
                s = "You are in " + r.getName() + ". " + r.getDescription()
                        + ". \n You have already been to this room";
            }else {
                s = "You are in "
                        + r.getName() + ". " + r.getDescription();
            }
            r.setVisited(true);
        }
        System.out.println(s);
    }

    public String processVerb(String verb, Actor player){
        String msg = "";
        if(!commands.contains(verb)){
            msg = verb + " is not a known verb!";
        } else {
            switch(verb) {
                case "n":
                    goN();
                    break;
                case "s":
                    goS();
                    break;
                case "w":
                    goW();
                    break;
                case "e":
                    goE();
                    break;
                case "u":
                    goU();
                    break;
                case "d":
                    goD();
                    break;
                case "backpack":
                    msg += backpack();
                    break;
                case "take":
                    if(player.getRoom().getItem() != null){
                        System.out.println("Current Room: " + player.getRoom().getName());
                        System.out.println("Item in current room: " + player.getRoom().getItem().getName());
                        msg = take();
                    }else{
                        msg += "There is no item you can take here";
                    }
                    break;
                case "look":
                    msg += look();
                    break;
                case "drop":
                    Scanner scanner = new Scanner (System.in);
                    if(player.getInventory() == null){
                        msg += backpack();
                        break;
                    }else {
                        System.out.println(backpack());
                        System.out.println("Which item do you want to drop?");
                        msg += drop(scanner.next());
                        break;
                    }
                case "commands":
                    msg += commands();
                    break;
                case "inspect":
                    msg += inspect();
                    break;
                default:
                    msg = verb + " (not yet implemented)";
                    break;
            }
        }
        return msg;
    }

}
