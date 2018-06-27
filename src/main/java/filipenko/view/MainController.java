package filipenko.view;

import filipenko.Checkers;
import javafx.fxml.FXML;
import javafx.scene.control.Button;


public class MainController {

    @FXML
    Button playButton;

    public void initialize() {
        playButton.setOnMouseClicked(e -> {
            Checkers.get().play();
        });
    }
}
