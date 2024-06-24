package Submachine.SubmachineObjects;
/**Class: Software Development I
 * @author Daniel Santoyo
 * @version 1.0
 * Course: ITEC 3860 Summer 2024
 * Written: 6/5, 2024
 * Submachine.SubmachineObjects.Actor.java - The actor type extends from Thing class and adds 3 variables:
 * A List<Item> type, a Room type, and an int type.
 */
import java.util.List;

public class Actor extends Thing {
    private List<Item> inventory;
    private int lives;
    private Room room;
    public Actor(String name, String description, Room room, List<Item> inventory, int lives ){
        super(name, description);
        this.room = room;
        this.inventory = inventory;
    }

    public void setRoom(Room room){
        this.room = room;
    }
    public Room getRoom(){
        return this.room;
    }

    public List<Item> getInventory(){
        return inventory;
    }
    public void addToInventory(Item item){
        inventory.add(item);
    }
    public void dropFromInventory(Item item){
        inventory.remove(item);
    }
}
