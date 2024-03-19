package life;

/* 
* @author Kristian Lubina
* @version 1.0
*/

public abstract class AbstractCell implements Cell {

     boolean alive = false;
     int x, y;
    
    public AbstractCell(int x, int y) {
       this.x = x;
       this.y = y;
    }
    
    @Override
    public void beBorn() {
       this.alive = true; 
    }

    @Override
    public boolean isAlive() {
       return this.alive;
    }    
    
    @Override
    public void die() {
       this.alive = false;
    }

    @Override
    public int getX() {
       return this.x;
    }

    @Override
    public int getY() {
       return this.y;
    }

    public abstract void setupNeighbours(Cell[][] cellGrid);
    public abstract void calculateNextState();
    public abstract void changeState();
}