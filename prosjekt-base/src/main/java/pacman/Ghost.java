package pacman;

import java.util.Timer;
import java.util.TimerTask;

public class Ghost {
    
    //private boolean alive = true;
    private Integer xPos = 10;
    private Integer yPos = 5;
    private Board b = new Board();
    private Integer[][] board = b.getBoard();
    private Integer nextMoveValue;
    private Integer onSquare = 1;
    private Timer timer;

    //private Integer previousMoveValue;
    

    Ghost() {
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                moveGhost();
            }
        }, 0, 1000);
    }
    
    public Integer getGhostxPos() {
        return xPos;
    }

    public Integer getGhostyPos() {
        return yPos;
    }

    public boolean isMoveValid(int nextSquare) {
        if (nextSquare > 0 && nextSquare != 4) {
            return true;
        }
        return false;
    }



    
    public Integer[][] move(char direction, Integer[][] bo) {

        if (direction == 'U') {
            //Up
            
            nextMoveValue = bo[yPos - 1][xPos];
            bo[yPos - 1][xPos] = 4;
            bo[yPos][xPos] = onSquare;
            onSquare = nextMoveValue;
            if (onSquare == 4) {
                onSquare = 5;
            }
            yPos -= 1;
            
            

        } else if (direction == 'R') {
            //Right
            nextMoveValue = bo[yPos][xPos + 1];
            bo[yPos][xPos + 1] = 4;
            bo[yPos][xPos] = onSquare; 
            onSquare = nextMoveValue;
            if (onSquare == 4) {
                onSquare = 5;
            }
            xPos += 1;
            
            

        } else if (direction == 'D') {
            //Down
            nextMoveValue = bo[yPos + 1][xPos];
            bo[yPos + 1][xPos] = 4;
            bo[yPos][xPos] = onSquare;
            onSquare = nextMoveValue;
            if (onSquare == 4) {
                onSquare = 5;
            }
            yPos += 1;
            
            

        } else if (direction == 'L') {
            //Left
            nextMoveValue = bo[yPos][xPos - 1];
            bo[yPos][xPos - 1] = 4;
            bo[yPos][xPos] = onSquare;
            onSquare = nextMoveValue;
            if (onSquare == 4) {
                onSquare = 5;
            }
            xPos -= 1;
        
        } else {
            moveStupid(bo);
        }
        return bo;
        
    }

    public Integer[][] moveStupid(Integer[][] bo) {
        for (int index = 0; index < 10; index++) {
            int random = randomMove();
            if (random == 0 && isMoveValid(bo[yPos - 1][xPos])) {
                //Up
                nextMoveValue = bo[yPos - 1][xPos];
                bo[yPos - 1][xPos] = 4;
                bo[yPos][xPos] = onSquare;
                onSquare = nextMoveValue;
                yPos -= 1;
                break;
                
                

            } else if (random == 1 && isMoveValid(bo[yPos][xPos + 1])) {
                //Right
                nextMoveValue = bo[yPos][xPos + 1];
                bo[yPos][xPos + 1] = 4;
                bo[yPos][xPos] = onSquare;
                onSquare = nextMoveValue;
                xPos += 1;
                break;
                
                

            } else if (random == 2 && isMoveValid(bo[yPos + 1][xPos])) {
                //Down
                nextMoveValue = bo[yPos + 1][xPos];
                bo[yPos + 1][xPos] = 4;
                bo[yPos][xPos] = onSquare;
                onSquare = nextMoveValue;
                yPos += 1;
                break;
                
                

            } else if (random == 3 && isMoveValid(bo[yPos][xPos - 1])) {
                //Left
                nextMoveValue = bo[yPos][xPos - 1];
                bo[yPos][xPos - 1] = 4;
                bo[yPos][xPos] = onSquare;
                onSquare = nextMoveValue;
                xPos -= 1;
                break;
                
            } //else {
            //     moveStupid(bo);
            // }
            
        } return bo;
    }
    
    public int randomMove() {
        int moveInt = (int) ((Math.random() * (4 - 0)) + 0);
        return moveInt;
    }

    

    private String getPosition() {
        return "[" + yPos + ", " + xPos + "]";
    }

    public Integer[][] getBoard() {
        return board;
    }

    public boolean pacManDies(int nextSquare) {
        if (nextMoveValue == 3) {
            return true;
        }
        return false;
    }
    
    // public static void main(String[] args) {
    // Ghost ghost = new Ghost();
    // for (int i = 0; i <100; i++) {
    //     System.out.println(ghost.getPosition());
    //     ghost.move();    
    // }
    
   
    
    // }

}
