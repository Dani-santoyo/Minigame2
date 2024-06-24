package Submachine.SubmachineObjects;
/**Class: Software Development I
 * @author Daniel Santoyo
 * @version 1.0
 * Course: ITEC 3860 Summer 2024
 * Written: 6/5, 2024
 * Submachine.SubmachineObjects.Item.java - The Item type extends from Thing class and does not add any variables.
 */
public class Item extends Thing{
    public Item(String name, String description){
        super(name, description);
    }

    @Override
    public String toString(){
        return "";
    }
}
