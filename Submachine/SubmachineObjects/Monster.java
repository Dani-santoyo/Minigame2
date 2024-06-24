package Submachine.SubmachineObjects;
/**Class: Software Development I
 * @author Daniel Santoyo
 * @version 1.0
 * Course: ITEC 3860 Summer 2024
 * Written: 6/5, 2024
 * Submachine.SubmachineObjects.Monster.java - The Monster type extends from Thing class. This object type is not
 * yet implemented but will be in future versions of the game.
 */
public class Monster extends Thing{
    private int lives;
    public Monster(String name, String description, int lives){
        super(name, description);
        this.lives = lives;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public String livesCounter(){
        String msg = "";
        if(lives == 0){
            msg = "You have beaten the " + getName() + "! You may now move forward.";
        }else if(lives == 1){
            msg = "The " + getName() + " has 1 life left.";
        }else {
            msg = "The" + getName() +" has " + lives + " lives left.";
        }
        return msg;
    }
}
