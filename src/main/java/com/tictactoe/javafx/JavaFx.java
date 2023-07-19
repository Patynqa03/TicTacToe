package com.tictactoe.javafx;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Random;

public class JavaFx extends Application {

    private Scene scene1;
    private Scene scene2;


    private Button[][] buttons = new Button[3][3];

    private boolean isXNext = true;
    private boolean isComputerGame = false;
    private Label chooseGame;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        StackPane stackPane = new StackPane();
        Button button1 = new Button("Gra z graczem");
        button1.setPrefSize(200, 100);
        Button button2 = new Button("Gra z komputerem");
        button2.setPrefSize(200, 100);

        button1.setTranslateY(-100);
        button2.setTranslateY(100);

        button1.setOnAction(event -> {
            primaryStage.setScene(scene2);
        });

        button2.setOnAction(event -> {
            isComputerGame = true;
            primaryStage.setScene(scene2);
        });

        chooseGame = new Label("Wybierz tryb gry");
        chooseGame.setStyle("-fx-font-size: 30px;");

        stackPane.getChildren().addAll(button1, button2);
        stackPane.getChildren().add(chooseGame);


        scene1 = new Scene(stackPane, 500, 500, Color.BLACK);
        primaryStage.setScene(scene1);

        primaryStage.setWidth(400);
        primaryStage.setHeight(400);

        primaryStage.setTitle("Kolko i Krzyzyk");
        primaryStage.show();

        GridPane gridPane = new GridPane();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Button button = new Button();
                button.setOnAction(event -> {
                    Button clickedButton = (Button) event.getSource();
                    makeMove(clickedButton);
                });
                button.setPrefSize(100, 100);
                gridPane.add(button, i, j);
                buttons[i][j] = button;
            }
        }
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        scene2 = new Scene(gridPane, 500, 500, Color.BLACK);
    }
    private void makeMove(Button button) {
        if (button.getText().isEmpty()) {
            if (isXNext) {
                button.setText("X");
            } else {
                button.setText("O");
            }
            isXNext = !isXNext;
            winnerCheck();

            if (isComputerGame && !isXNext) {
                makeComputerMove();
            }
        }
    }
    private void winnerCheck() {
        String[][] board = new String[3][3];
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col] = buttons[row][col].getText();
            }
        }

        for (int i = 0; i < 3; i++) {
            if (board[i][0].equals(board[i][1]) && board[i][0].equals(board[i][2]) && !board[i][0].isEmpty()) {
                showWinnerAlert(board[i][0]);
                return;
            }

            if (board[0][i].equals(board[1][i]) && board[0][i].equals(board[2][i]) && !board[0][i].isEmpty()) {
                showWinnerAlert(board[0][i]);
                return;
            }
        }

        if (board[0][0].equals(board[1][1]) && board[0][0].equals(board[2][2]) && !board[0][0].isEmpty()) {
            showWinnerAlert(board[0][0]);
            return;
        }

        if (board[0][2].equals(board[1][1]) && board[0][2].equals(board[2][0]) && !board[0][2].isEmpty()) {
            showWinnerAlert(board[0][2]);
        } else {
            boolean isBoardFull = true;
            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {
                    if (buttons[row][col].getText().isEmpty()) {
                        isBoardFull = false;
                        break;
                    }
                }
            }
            if (isBoardFull) {
                drawAlert();
            }
        }
    }

    private void showWinnerAlert(String winner) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Kolko i krzyzyk");
        alert.setHeaderText(null);
        alert.setContentText("WYGRYWA: " + winner);
        alert.showAndWait();
        resetGame();
    }

    private void drawAlert() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Kolko i krzyzyk");
        alert.setHeaderText(null);
        alert.setContentText("REMIS!");
        alert.showAndWait();
        resetGame();
    }

    private void resetGame() {
        isXNext = true;
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                buttons[row][col].setText("");
            }
        }
    }
    private void makeComputerMove() {

        Random random = new Random();
        int row, col;
        boolean isEmpty = false;

        while (!isEmpty) {
            row = random.nextInt(3);
            col = random.nextInt(3);

            if (buttons[row][col].getText().isEmpty()) {
                buttons[row][col].setText("O");
                isEmpty = true;
            }
        }
        isXNext = true;
        winnerCheck();
    }
}