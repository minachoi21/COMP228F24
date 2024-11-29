package org.example.minachoi_comp228lab5.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainController {

    @FXML
    public void initialize() {
    }

    public void handleManagePlayers() throws Exception {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/minachoi_comp228lab5/PlayerView.fxml"));
        stage.setScene(new Scene(loader.load()));
        stage.setTitle("Player Management");
        stage.show();
    }

    public void handleManageGames() throws Exception {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/minachoi_comp228lab5/GameView.fxml"));
        stage.setScene(new Scene(loader.load()));
        stage.setTitle("Game Management");
        stage.show();
    }

    public void handleManagePlayerRecords() throws Exception {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/minachoi_comp228lab5/PlayerGameView.fxml"));
        stage.setScene(new Scene(loader.load()));
        stage.setTitle("Player Game Record Management");
        stage.show();
    }
}
