package filipenko.view;

import filipenko.Checkers;
import filipenko.planC.Deck;
import filipenko.planC.Game;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import java.util.Optional;

import static filipenko.planC.Deck.*;

public class GameController {

    private static final int CHIP_WIDTH = 40;

    private Deck deck;
    private Game game;
    private int player;

    @FXML
    Button menuButton;

    @FXML
    Label statusLabel;

    @FXML
    ImageView statusImage;

    @FXML
    GridPane boardPane;


    public void initialize() {
        game = Checkers.get().getGame();
        deck = game.getDeck();

        menuButton.setOnMouseClicked(e -> {
            toMenu();
        });

        updateStatus();

        updateChips();

        prepareToMove();
    }


    private void updateChips() {
        boardPane.getChildren().clear();
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                int chip = deck.get(row, col);
                switch (chip) {
                    case EMPTY:
                        break;
                    case BLACK:
                        drawImage("black.png", row, col, boardPane);
                        break;
                    case WHITE:
                        drawImage("white.png", row, col, boardPane);
                        break;
                    case BLACK_QUEEN:
                        drawImage("black_queen.png", row, col, boardPane);
                        break;
                    case WHITE_QUEEN:
                        drawImage("white_queen.png", row, col, boardPane);
                        break;
                }
            }
        }
    }

    private void updateStatus() {
        if (game.getWinner() == BLACK) {
            statusLabel.setText("Black wins!");
            statusImage.setImage(new Image("black.png", CHIP_WIDTH, CHIP_WIDTH, false, true));
        }
        if (game.getWinner() == WHITE) {
            statusLabel.setText("White wins!");
            statusImage.setImage(new Image("white.png", CHIP_WIDTH, CHIP_WIDTH, false, true));
        }
        player = game.getPlayer();
        if (player == BLACK) {
            statusLabel.setText("Black's turn");
            statusImage.setImage(new Image("black.png", CHIP_WIDTH, CHIP_WIDTH, false, true));
        } else {
            statusLabel.setText("White's turn");
            statusImage.setImage(new Image("white.png", CHIP_WIDTH, CHIP_WIDTH, false, true));
        }
    }

    private void drawImage(String url, int x, int y, GridPane gridPane) {
        ImageView imageView = new ImageView(new Image(url, CHIP_WIDTH, CHIP_WIDTH, false, true));
        boardPane.add(imageView, x, y);
    }

    private void moveChip(int x1, int y1) {
        boardPane.setOnMouseClicked(e -> {
            int x2 = (int) e.getX() / CHIP_WIDTH;
            int y2 = (int) e.getY() / CHIP_WIDTH;

            if (game.move(x1, y1, x2, y2)) {
                updateChips();
                updateStatus();
            }
            prepareToMove();
        });
    }

    private void prepareToMove() {
        boardPane.setOnMouseClicked(e -> {
            int x = (int) e.getX() / CHIP_WIDTH;
            int y = (int) e.getY() / CHIP_WIDTH;

            moveChip(x, y);
        });
    }

    private void toMenu() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("R U Sure, U wanna go to Menu?");
        alert.setContentText("You game will be lost!");
        Optional<ButtonType> res = alert.showAndWait();
        if (res.get() == ButtonType.OK) {
            Checkers.get().returnToMenu();
        } else {
            alert.close();
        }
    }

}
