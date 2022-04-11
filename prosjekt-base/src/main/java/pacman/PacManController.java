package pacman;

import javafx.fxml.FXML;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;



public class PacManController{

    private PacMan pacMan;

    

    @FXML
    Pane board;

    @FXML 
    Text pointDisplay;

    @FXML
    Text gameOverText;

    @FXML
    Text levelText;


    @FXML
    public void initialize() {
        pacMan = new PacMan();
        board.getChildren().clear();
        for (int y = 0; y < pacMan.getBoard().length; y++) {
            for (int x = 0; x < pacMan.getBoard()[0].length; x++) {
                Pane tile = new Pane();
                tile.setTranslateX(x * 20);
                tile.setTranslateY(y * 20);
                tile.setPrefWidth(20);
                tile.setPrefHeight(20);
                board.getChildren().add(tile);
            }
        }
        updateBoard();
        gameOverText.setVisible(false);
    }

    @FXML
    void handleRight() {
        pacMan.moveRight();
        updateBoard();
        updatePoints();
        setGameOver();
        setLevel();
    }

    @FXML
    void handleDown() {
        pacMan.moveDown();
        updateBoard();
        updatePoints();
        setGameOver();
        setLevel();
    }

    @FXML
    void handleLeft() {
        pacMan.moveLeft();
        updateBoard();
        updatePoints();
        setGameOver();
        setLevel();
    }

    @FXML
    void handleUp() {
        pacMan.moveUp();
        updateBoard();
        updatePoints();
        setGameOver();
        setLevel();
    }


    private String getColor(Integer i) {
            if (i == 0) {
                return "#0000FF";
            }
            else if (i == 1) {
                return "#FAEBD7";
            }
            else if (i == 2) {
                return "#000000";
            }
            else if (i == 3) {
                return "#9ACD32";
            }
            else if (i == 4) {
                return "#FF0000";
            }
            else {
                return "#FF00FF";
            }
        }
    
    @FXML
    private void updatePoints() {
        int points = pacMan.getPoints();
        pointDisplay.setText("Poeng: " + points);
    }

    @FXML
    private void setLevel() {
        int lvl = pacMan.getLevel();
        levelText.setText("Level: " + lvl);
    }

    @FXML
    private void setGameOver() {
        if (!pacMan.isAlive()) {
            gameOverText.setVisible(true);
        }
    }
    
    
    private void updateBoard() {
        for (int i = 0; i < pacMan.getBoard().length; i++) {
            for (int j = 0; j < pacMan.getBoard()[0].length; j++) {
                board.getChildren().get(i * pacMan.getBoard()[0].length + j).setStyle("-fx-background-color: " + getColor(pacMan.getBoard()[i][j]));
            }
        }
    }



}
