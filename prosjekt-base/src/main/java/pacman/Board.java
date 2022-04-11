package pacman;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.Collectors;

public class Board implements PacManBoard{

     private Integer[][] board = {
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,0}, 
        {0,1,0,0,0,1,0,0,0,1,0,1,0,0,0,1,0,0,0,1,0},
        {0,1,0,0,0,1,0,0,0,1,0,1,0,0,0,1,0,0,0,1,0},
        {0,1,0,0,0,1,0,0,0,1,0,1,0,0,0,1,0,0,0,1,0},
        {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
        {0,1,0,0,0,1,0,1,0,0,0,0,0,1,0,1,0,0,0,1,0},
        {0,1,0,0,0,1,0,1,0,0,0,0,0,1,0,1,0,0,0,1,0},
        {0,1,1,1,1,1,0,1,1,1,0,1,1,1,0,1,1,1,1,1,0},
        {0,0,0,0,0,1,0,0,0,1,0,1,0,0,0,1,0,0,0,0,0},
        {0,0,0,0,0,1,0,0,0,1,0,1,0,0,0,1,0,0,0,0,0},
        {0,0,0,0,0,1,0,0,0,1,0,1,0,0,0,1,0,0,0,0,0},
        {0,0,0,0,0,1,0,0,0,1,0,1,0,0,0,1,0,0,0,0,0},
        {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
        {0,0,0,0,0,1,0,0,0,1,0,1,0,0,0,1,0,0,0,0,0},
        {0,0,0,0,0,1,0,0,0,1,0,1,0,0,0,1,0,0,0,0,0},
        {0,0,0,0,0,1,0,0,0,1,0,1,0,0,0,1,0,0,0,0,0},
        {0,0,0,0,0,1,0,0,0,1,0,1,0,0,0,1,0,0,0,0,0},
        {0,1,1,1,1,1,0,1,1,1,0,1,1,1,0,1,1,1,1,1,0},
        {0,1,0,0,0,1,0,1,0,0,0,0,0,1,0,1,0,0,0,1,0},
        {0,1,0,0,0,1,0,1,0,0,0,0,0,1,0,1,0,0,0,1,0},
        {0,1,1,1,1,1,1,1,1,1,3,1,1,1,1,1,1,1,1,1,0},
        {0,1,0,0,0,1,0,0,0,1,0,1,0,0,0,1,0,0,0,1,0},
        {0,1,0,0,0,1,0,0,0,1,0,1,0,0,0,1,0,0,0,1,0},
        {0,1,0,0,0,1,0,0,0,1,0,1,0,0,0,1,0,0,0,1,0},
        {0,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,0}, 
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    };

    
    public Integer[][] getBoard() {
        return board;
    }

    public boolean hasOne(Integer[][] board) {
        ArrayList<Integer> boardList = new ArrayList<Integer>(Arrays.stream(board)
        .flatMap(Arrays::stream).collect(Collectors.toList())); //hentet fra StackOverflow: https://stackoverflow.com/questions/11447780/convert-two-dimensional-array-to-list-in-java
        return boardList.stream().anyMatch(i -> i == 1);
    }

    // @Override
    // public Iterator<Integer> iterator() {
    //     return new PacManBoardIterator(this);
    // }

    public static void main(String[] args) {
        Board board1 = new Board();
        // System.out.println(board1.getBoard().length);
        // System.out.println(board1.getBoard()[1][1]);
        // System.out.println(board1.getBoard());
        // System.out.println(board1.getBoard().length);
        // System.out.println(board1.getBoard()[1].length);
    }

    
    
}