package pacman;

import java.util.ArrayList;
import java.util.Random;

public class PacMan implements PacManBoard{

    private boolean alive = true;
    private Integer xPos = 10;
    private Integer yPos = 21;
    private Board b = new Board();
    private Integer[][] board = b.getBoard();
    private int points = 0;
    private ArrayList<Ghost> ghostList = new ArrayList<>();
    private int counter = 0;
    private int level = 1;
    Runnable runnable;
    
    PacMan()
    {
        runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("");
            }
        };
    }
    
    public void resetBoard() {
        b = new Board();
        this.board = b.getBoard();
        this.level++;
        this.xPos = 10;
        this.yPos = 21;
        this.ghostList.clear();
        this.counter = 0;
    }
    
    private Integer getPacManxPos() {
        return xPos;
    }

    private Integer getPacManyPos() {
        return yPos;
    }

    public void setGhost() {
        board[5][10] = 4;
    }

    

    private int getYDiff(Ghost ghost) {
        return getPacManyPos() - ghost.getGhostyPos();
    }

    private int getXDiff(Ghost ghost) {
        return getPacManxPos() - ghost.getGhostxPos();
    }

    public char moveSmartGhost(Ghost ghost) {
        int diffX = getXDiff(ghost);
        int diffY = getYDiff(ghost);

        if (diffX > diffY) {
            
            if (diffY > 0) {
                if (ghost.isMoveValid(board[ghost.getGhostyPos() + 1][ghost.getGhostxPos()])){
                    return 'D';
                } else {
                    //Right
                    if (ghost.isMoveValid(board[ghost.getGhostyPos()][ghost.getGhostxPos() + 1])) {
                        return 'R';
                    } else if (ghost.isMoveValid(board[ghost.getGhostyPos()][ghost.getGhostxPos() - 1])) {
                        return 'L';
                    } else {
                        return 'U';
                    }
                } 
                
            }else if (diffY < 0) {
                if (ghost.isMoveValid(board[ghost.getGhostyPos() - 1][ghost.getGhostxPos()])){
                    return 'U';
                } else if (diffX > 0) {
                    //Right
                    if (ghost.isMoveValid(board[ghost.getGhostyPos()][ghost.getGhostxPos() + 1])) {
                        return 'R';
                    } else if (ghost.isMoveValid(board[ghost.getGhostyPos()][ghost.getGhostxPos() - 1])) {
                        return 'L';
                    } else {
                        return 'D';
                    }
                }
            } else {
                //På samme rad!
                if (diffX > 0) {
                    //Ned
                    if (ghost.isMoveValid(board[ghost.getGhostyPos()][ghost.getGhostxPos() + 1])) {
                        return 'R';
                    } else if (ghost.isMoveValid(board[ghost.getGhostyPos() - 1][ghost.getGhostxPos()]) && ghost.isMoveValid(board[ghost.getGhostyPos() + 1][ghost.getGhostxPos()])) {
                        Random r = new Random();
                        char c = r.nextBoolean() ? 'U' : 'D';
                        return c;
                    } else if (ghost.isMoveValid(board[ghost.getGhostyPos()][xPos])) { //////// ER HER
                        return 'L';

                    } else {
                        return 'R';
                    }
                } else {
                    if (ghost.isMoveValid(board[ghost.getGhostyPos() - 1][ghost.getGhostxPos()])) {
                        return 'U';
                    } else if (ghost.isMoveValid(board[ghost.getGhostyPos()][ghost.getGhostxPos() - 1]) && ghost.isMoveValid(board[ghost.getGhostyPos()][ghost.getGhostxPos() + 1])) {
                        Random r = new Random();
                        char c = r.nextBoolean() ? 'R' : 'L';
                        return c;
                    } else if (ghost.isMoveValid(board[ghost.getGhostyPos()][ghost.getGhostxPos() - 1])) {
                        return 'L';

                    } else {
                        return 'R';
                    }
                    
                }

            }
            
        } else if (diffX < diffY) {
            if (diffX > 0) {
                if (ghost.isMoveValid(board[ghost.getGhostyPos()][ghost.getGhostxPos() + 1])){
                    return 'R';
                } 
                else {
                    //Right
                    if (ghost.isMoveValid(board[ghost.getGhostyPos() + 1][ghost.getGhostxPos()])) {
                        return 'D';
                    } else if (isMoveValid(board[ghost.getGhostyPos() - 1][ghost.getGhostxPos()])){
                        return 'U';
                    }return 'L';
                } 
            }else if (diffX < 0) {
                if (ghost.isMoveValid(board[ghost.getGhostyPos()][ghost.getGhostxPos()-1])){
                    return 'L';
                } 
                else if (diffY > 0) {
                    if (ghost.isMoveValid(board[ghost.getGhostyPos() + 1][ghost.getGhostxPos()])) {
                        return 'D';
                    } else if (ghost.isMoveValid(board[ghost.getGhostyPos() - 1][ghost.getGhostxPos()])){
                        return 'U';
                    }
                    return 'R';
                }
                else if(diffY < 0) {
                    if (ghost.isMoveValid(board[ghost.getGhostyPos() - 1][ghost.getGhostxPos()])) {
                        return 'U';
                    } else if (ghost.isMoveValid(board[ghost.getGhostyPos() + 1][ghost.getGhostxPos()])){
                        return 'D';
                    }
                    return 'R';
                }
            }

            else {
                //På samme kolonne!
                if (diffY > 0) {
                    //Ned
                    if (ghost.isMoveValid(board[ghost.getGhostyPos() + 1][ghost.getGhostxPos()])) {
                        return 'D';
                    } else if (ghost.isMoveValid(board[ghost.getGhostyPos()][ghost.getGhostxPos()] - 1) && ghost.isMoveValid(board[ghost.getGhostyPos()][ghost.getGhostxPos()] + 1)) {
                        Random r = new Random();
                        char c = r.nextBoolean() ? 'L' : 'R';
                        return c;
                    } else if (ghost.isMoveValid(board[ghost.getGhostyPos() + 1][ghost.getGhostxPos()])) {
                        return 'U';

                    } else {
                        return 'U';
                    }
                } else {
                    if (ghost.isMoveValid(board[ghost.getGhostyPos()][ghost.getGhostxPos() - 1])) {
                        return 'L';
                    } else if (ghost.isMoveValid(board[ghost.getGhostyPos() - 1][ghost.getGhostxPos()]) && ghost.isMoveValid(board[ghost.getGhostyPos() + 1][ghost.getGhostxPos()])) {
                        Random r = new Random();
                        char c = r.nextBoolean() ? 'D' : 'U';
                        return c;
                    } else if (ghost.isMoveValid(board[ghost.getGhostyPos() - 1][ghost.getGhostxPos()])) {
                        return 'U';

                    } else {
                        return 'D';
                    }
                    
                }
            }
        } else {
            return 'S';
        } return 'S'; 
    }

    private boolean checkAddGhost() {
        if (counter == 10 || counter == 20 || counter == 30 || counter == 40) {
            return true;
        }
        return false;
    }

    private void addGhost(Ghost ghost) {
        ghostList.add(ghost);
        setGhost();
    }

    //I moveUp,down osv må vi legge til en på antall trekk, så første spøkelse kommer etter 10 trekk, andre kommer etter 20 trekk osv
    //Vi må også sjekke for hver gang om pacman er i live
    public void moveUp() {
        if (b.hasOne(getBoard())) {
            if (isMoveValid(board[yPos - 1][xPos])) {
                if (isPoint(board[yPos - 1][xPos])) {
                    points++;
                }
                if (dies(board[yPos - 1][xPos], board[yPos][xPos])) {
                    alive = false;
                }
                board[yPos - 1][xPos] = 3;
                board[yPos][xPos] = 2;
                yPos -= 1;
                counter += 1;
                if (points > 100) {
                    
                }
                if (ghostList.size() != 4 && checkAddGhost()) {
                    Ghost ghost = new Ghost();
                    addGhost(ghost);
                }
                if (!ghostList.isEmpty()) {
                    for (Ghost ghost : ghostList) {
                        if (level == 1) {
                            Random rand = new Random();
                            if (rand.nextInt(100) < 10) {
                                board = ghost.move(moveSmartGhost(ghost), board);
                            }
                            else {
                                board = ghost.move('S', board);
                            }
                        }
                        else if (level == 2) {
                            Random rand = new Random();
                            if (rand.nextInt(100) < ((2/3)*100)) {
                                board = ghost.move(moveSmartGhost(ghost), board);
                            }
                            else {
                                board = ghost.move('S', board);
                            }
                        }
                        else {
                            board = ghost.move(moveSmartGhost(ghost), board);
                        }
                        //board = ghost.move(moveSmartGhost(ghost), board);
                    }
                }
            }
        }
        else {
            resetBoard();
        }
    }

    public void moveRight() {
        if (b.hasOne(getBoard())) {
            if (isMoveValid(board[yPos][xPos + 1])) {
                if (isPoint(board[yPos][xPos + 1])) {
                    points++;
                }
                if (dies(board[yPos][xPos + 1], board[yPos][xPos])) {
                    alive = false;
                }
                board[yPos][xPos + 1] = 3;
                board[yPos][xPos] = 2;
                xPos += 1;
                counter += 1;
                if (ghostList.size() != 4 && checkAddGhost()) {
                    Ghost ghost = new Ghost();
                    addGhost(ghost);
                }
                if (!ghostList.isEmpty()) {
                    for (Ghost ghost : ghostList) {
                        if (level == 1) {
                            Random rand = new Random();
                            if (rand.nextInt(100) < 10) {
                                board = ghost.move(moveSmartGhost(ghost), board);
                            }
                            else {
                                board = ghost.move('S', board);
                            }
                        }
                        else if (level == 2) {
                            Random rand = new Random();
                            if (rand.nextInt(100) < ((2/3)*100)) {
                                board = ghost.move(moveSmartGhost(ghost), board);
                            }
                            else {
                                board = ghost.move('S', board);
                            }
                        }
                        else {
                            board = ghost.move(moveSmartGhost(ghost), board);
                        }
                    //board = ghost.move(moveSmartGhost(ghost), board);
                    }
                }
            }
            else if (xPos == 19 && yPos == 13) {
                if (isPoint(board[13][1])) {
                    points++;
                }
                if (dies(board[13][1], board[13][19])) {
                    alive = false;
                }
                board[13][1] = 3;
                board[yPos][xPos] = 2;
                xPos = 1;
                counter += 1;
                if (ghostList.size() != 4 && checkAddGhost()) {
                    Ghost ghost = new Ghost();
                    addGhost(ghost);
                }
                if (!ghostList.isEmpty()) {
                    for (Ghost ghost : ghostList) {
                        if (level == 1) {
                            Random rand = new Random();
                            if (rand.nextInt(100) < 10) {
                                board = ghost.move(moveSmartGhost(ghost), board);
                            }
                            else {
                                board = ghost.move('S', board);
                            }
                        }
                        else if (level == 2) {
                            Random rand = new Random();
                            if (rand.nextInt(100) < ((2/3)*100)) {
                                board = ghost.move(moveSmartGhost(ghost), board);
                            }
                            else {
                                board = ghost.move('S', board);
                            }
                        }
                        else {
                            board = ghost.move(moveSmartGhost(ghost), board);
                        }
                    //board = ghost.move(moveSmartGhost(ghost), board);
                    }
                }
            }
        }
        else {
            resetBoard();
        }
    }

    public void moveDown() {
        if (b.hasOne(getBoard())) {
            if (isMoveValid(board[yPos + 1][xPos])) {
                if (isPoint(board[yPos + 1][xPos])) {
                    points++;
                }
                if (dies(board[yPos + 1][xPos], board[yPos][xPos])) {
                    alive = false;
                }
                board[yPos + 1][xPos] = 3;
                board[yPos][xPos] = 2;
                yPos += 1;
                counter += 1;
                if (ghostList.size() != 4 && checkAddGhost()) {
                    Ghost ghost = new Ghost();
                    addGhost(ghost);
                }
                if (!ghostList.isEmpty()) {
                    for (Ghost ghost : ghostList) {
                        if (level == 1) {
                            Random rand = new Random();
                            if (rand.nextInt(100) < 10) {
                                board = ghost.move(moveSmartGhost(ghost), board);
                            }
                            else {
                                board = ghost.move('S', board);
                            }
                        }
                        else if (level == 2) {
                            Random rand = new Random();
                            if (rand.nextInt(100) < ((2/3)*100)) {
                                board = ghost.move(moveSmartGhost(ghost), board);
                            }
                            else {
                                board = ghost.move('S', board);
                            }
                        }
                        else {
                            board = ghost.move(moveSmartGhost(ghost), board);
                        }
                    //board = ghost.move(moveSmartGhost(ghost), board);
                    }
                    
                }
            }
        }
        else {
            resetBoard();
        }
    }
        
    public void moveLeft() {
        if (b.hasOne(getBoard())) {
            if (isMoveValid(board[yPos][xPos - 1])) {
                if (isPoint(board[yPos][xPos - 1])) {
                    points++;
                }
                if (dies(board[yPos][xPos - 1], board[yPos][xPos])) {
                    alive = false;
                }
                board[yPos][xPos - 1] = 3;
                board[yPos][xPos] = 2;
                xPos -= 1;
                counter += 1;
                if (ghostList.size() != 4 && checkAddGhost()) {
                    Ghost ghost = new Ghost();
                    addGhost(ghost);
                }
                if (!ghostList.isEmpty()) {
                    for (Ghost ghost : ghostList) {
                        if (level == 1) {
                            Random rand = new Random();
                            if (rand.nextInt(100) < 10) {
                                board = ghost.move(moveSmartGhost(ghost), board);
                            }
                            else {
                                board = ghost.move('S', board);
                            }
                        }
                        else if (level == 2) {
                            Random rand = new Random();
                            if (rand.nextInt(100) < ((2/3)*100)) {
                                board = ghost.move(moveSmartGhost(ghost), board);
                            }
                            else {
                                board = ghost.move('S', board);
                            }
                        }
                        else {
                            board = ghost.move(moveSmartGhost(ghost), board);
                        }
                    //board = ghost.move(moveSmartGhost(ghost), board);
                    }
                }
            }
            else if (xPos == 1 && yPos == 13) {
                if (isPoint(board[13][19])) {
                    points++;
                }
                if (dies(board[13][19], board[13][1])) {
                    alive = false;
                }
                board[13][19] = 3;
                board[yPos][xPos] = 2;
                xPos = 19;
                counter += 1;
                if (ghostList.size() != 4 && checkAddGhost()) {
                    Ghost ghost = new Ghost();
                    addGhost(ghost);
                }
                if (!ghostList.isEmpty()) {
                    for (Ghost ghost : ghostList) {
                        if (level == 1) {
                            Random rand = new Random();
                            if (rand.nextInt(100) < 10) {
                                board = ghost.move(moveSmartGhost(ghost), board);
                            }
                            else {
                                board = ghost.move('S', board);
                            }
                        }
                        else if (level == 2) {
                            Random rand = new Random();
                            if (rand.nextInt(100) < ((2/3)*100)) {
                                board = ghost.move(moveSmartGhost(ghost), board);
                            }
                            else {
                                board = ghost.move('S', board);
                            }
                        }
                        else {
                            board = ghost.move(moveSmartGhost(ghost), board);
                        }
                    //board = ghost.move(moveSmartGhost(ghost), board);
                    }
                }
            }
        }
        else {
            resetBoard();
        } 
    }

    private boolean isMoveValid(int nextSquare) {
        
        if (nextSquare > 0 && isAlive()) {
            return true;
        }
        return false;
    }

    private boolean isPoint(int nextSquare) {
        if (nextSquare == 1) {
            return true;
        }
        else if (nextSquare == 5) {
            points += 10;
        }
        return false;
    }

    private boolean dies(int nextSquare1, int nextSquare2) {
        if (nextSquare1 == 4 || nextSquare2 == 4) {
            return true;
        }
        return false;
    }

    public boolean isAlive() {
        if (alive == true) {
            return true;
        }
        else {
            return false;
        }
    }

    public Integer[][] getBoard() {
        return board;
    }

    private String getPosition() {
        return "[" + yPos + ", " + xPos + "]";
    }

    public int getPoints() {
        return points;
    }

    public int getLevel() {
        return level;
    }

    public static void main(String[] args) {
        PacMan pacman = new PacMan();
        //System.out.println(pacman[1][2]);
        System.out.println(pacman.getBoard());
        System.out.println(pacman.getPosition());
        System.out.println(pacman.points);
        for (int i = 0; i <5;i++) {
            pacman.moveRight();
        }
        for (int i = 0; i < 8;i++) {
            pacman.moveUp();
        }
        for (int i = 0; i < 8;i++) {
            pacman.moveRight();
        }
        pacman.moveDown();
        pacman.moveLeft();
        System.out.println(pacman.getBoard());
        System.out.println(pacman.getPosition());
        
        pacman.moveUp();
        System.out.println(pacman.getBoard());
    }

    
}
