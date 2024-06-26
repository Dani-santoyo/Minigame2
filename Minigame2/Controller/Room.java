package Minigame2.Controller;
/**Class: Software Development I
 * @author Daniel Santoyo
 * @version 1.0
 * Course: ITEC 3860 Summer 2024
 * Written: 6/5, 2024
 * Submachine.Controller.Room.java - The Room type extends from Thing class and adds 7 variables:
 * 6 int types for directional purposes, and one boolean type.
 */
public class Room extends Thing{
    private int n, s, w, e, u, d;
    private boolean visited;
    private Item item;
    private Monster monster;


    public Room(String name, String description, boolean visited, Item item, Monster monster,
                int n, int s, int e, int w, int u, int d) {
        super(name, description);
        this.visited = false;
        this.item = item;
        this.monster = monster;
        this.n = n;
        this.s = s;
        this.w = w;
        this.e = e;
        this.u = u;
        this.d = d;
    }

    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int getS() {
        return s;
    }

    public void setS(int s) {
        this.s = s;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getE() {
        return e;
    }

    public void setE(int e) {
        this.e = e;
    }

    public int getU() {
        return u;
    }

    public void setU(int u) {
        this.u = u;
    }

    public int getD() {
        return d;
    }

    public void setD(int d) {
        this.d = d;
    }

    @Override
    public String toString(){
        return getDescription();
    }
}
