package filipenko;

import filipenko.planC.Game;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Checkers extends Application {

    private static Checkers checkers;

    public static Checkers get() {
        return checkers;
    }

    private Stage stage;
    private Game game;

    public Game getGame() {
        return game;
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        checkers = this;

        this.stage = primaryStage;
        stage.setTitle("checkers");
        stage.setResizable(false);

        try {
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("main.fxml"));
            primaryStage.setScene(new Scene(root));
        } catch (IOException exc) {
            exc.printStackTrace();
            System.exit(404);
        }

        primaryStage.show();
    }

    public void play() {

        game = new Game();

        try {
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("game.fxml"));
            stage.setScene(new Scene(root));
        } catch (IOException exc) {
            exc.printStackTrace();
            System.exit(404);

        }
    }

    public void returnToMenu() {
        try {
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("main.fxml"));
            stage.setScene(new Scene(root));
        } catch (IOException exc) {
            exc.printStackTrace();
            System.exit(404);
        }
    }


}
