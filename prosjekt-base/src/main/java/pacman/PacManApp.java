package pacman;

import java.io.IOException;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class PacManApp extends Application{
    private FXMLLoader loader;
    private Parent root;
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setTitle("PacMan");
        loader = new FXMLLoader(getClass().getResource("PacMan.fxml"));
        root = loader.load();
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        Scene mainScene = primaryStage.getScene();
        PacManController controller = loader.<PacManController>getController();
        mainScene.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent e) {
                // System.out.println("Hallo" + e.getCode());
                if (e.getCode() == KeyCode.LEFT) {
                    controller.handleLeft();
                } else if (e.getCode() == KeyCode.UP) {
                    controller.handleUp();
                } else if (e.getCode() == KeyCode.DOWN) {
                    controller.handleDown();
                } else if (e.getCode() == KeyCode.RIGHT) {
                    controller.handleRight();
                } 


            }
        });
    }
}