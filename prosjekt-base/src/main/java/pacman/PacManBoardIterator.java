package pacman;

import java.util.Iterator;

public class PacManBoardIterator implements Iterator<Integer> {

    private PacManBoard pacManBoard;
    private int yPos;
    private int xPos;

    
    
    
    public PacManBoardIterator(PacManBoard pacManBoard) {
        this.pacManBoard = pacManBoard;
    }

    @Override
    public boolean hasNext() {
        if (yPos < 26) {
            if (xPos < 20) {
                xPos++;
                return true;
            }
            else {
                xPos = 0;
                yPos++;
                return true;
            }
        }
        return false;
    }

    @Override
    public Integer next() {
        if (yPos < 26) {
            if (xPos < 20) {
                xPos++;
                return pacManBoard.getBoard()[yPos][xPos-1];
                
            }
            else {
                xPos = 0;
                yPos++;
                return pacManBoard.getBoard()[yPos-1][20];
                
            }
        }
        return null;
    }
    
}
