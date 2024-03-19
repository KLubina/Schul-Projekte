package life;

import java.util.ArrayList;
import java.util.List;

/* 
* @author Kristian Lubina
* @version 1.0
*/

public class LifeCell extends AbstractCell {
     private boolean nextState;
     private List<Cell> neighbourCells;
     
    public LifeCell(int x, int y) {
       super(x, y);
       neighbourCells = new ArrayList<>();
    }

    @Override
    public void setupNeighbours(Cell[][] cellGrid) {
         int[] directions = {-1, 0, 1};
            for (int dx : directions) {
                for (int dy : directions) {
                    if (dx == 0 && dy == 0) continue;
                    
                    int newX = x + dx;
                    int newY = y + dy;
                    
                    if (newX >= 0 && newX < cellGrid.length && newY >= 0 && newY < cellGrid[0].length) {
                        neighbourCells.add(cellGrid[newX][newY]);
                    }
                }
            }
                
    }

    @Override
    public void changeState() {
          int aliveCounter = 0;
       for( Cell neighbour : neighbourCells) {
          if(neighbour.isAlive()) {
             aliveCounter++;
          }
       }
       this.alive = (aliveCounter ==3 || aliveCounter == 2  && alive);
    }

    @Override
    public void calculateNextState() {
       int aliveCounter = 0;
       for( Cell cell : neighbourCells) {
          if(cell.isAlive()) {
             aliveCounter++;
       }
       }
    }

    @Override
    public void beBorn() {
       alive = true;
    }

    @Override
    public void die() {
       alive = false;
    }

    @Override
    public boolean isAlive() {
       return alive;
    }

    @Override
    public int getX() {
       return x;
    }

    @Override
    public int getY() {
       return y;
    }

    @Override
    public List<Cell> getNeighbours() {
       return neighbourCells;
    }
}