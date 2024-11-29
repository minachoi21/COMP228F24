package org.example.minachoi_comp228lab5.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.minachoi_comp228lab5.dao.PlayerGameDAO;
import org.example.minachoi_comp228lab5.model.Game;
import org.example.minachoi_comp228lab5.model.PlayerGame;

import java.sql.SQLException;

public class PlayerGameController {

    @FXML
    private TableView<Game> gameTable;

    @FXML
    private TableColumn<Game, Integer> gameIdColumn;

    @FXML
    private TableColumn<Game, String> gameTitleColumn;

    @FXML
    private TableView<PlayerGame> playerGameTable;

    @FXML
    private TableColumn<PlayerGame, Integer> playerGameIdColumn;

    @FXML
    private TableColumn<PlayerGame, Integer> playerIdColumn;

    @FXML
    private TableColumn<PlayerGame, String> playingDateColumn;

    @FXML
    private TableColumn<PlayerGame, Integer> scoreColumn;

    @FXML
    private TextField playerIdField;

    @FXML
    private TextField scoreField;

    private ObservableList<Game> games = FXCollections.observableArrayList();
    private ObservableList<PlayerGame> playerGames = FXCollections.observableArrayList();

    private PlayerGameDAO playerGameDAO = new PlayerGameDAO();

    @FXML
    public void initialize() {
        gameIdColumn.setCellValueFactory(new PropertyValueFactory<>("gameId"));
        gameTitleColumn.setCellValueFactory(new PropertyValueFactory<>("gameTitle"));

        playerGameIdColumn.setCellValueFactory(new PropertyValueFactory<>("playerGameId"));
        playerIdColumn.setCellValueFactory(new PropertyValueFactory<>("playerId"));
        playingDateColumn.setCellValueFactory(new PropertyValueFactory<>("playingDate"));
        scoreColumn.setCellValueFactory(new PropertyValueFactory<>("score"));

        loadGames();
        setupGameSelectionListener();
    }

    private void loadGames() {
        try {
            games = FXCollections.observableArrayList(playerGameDAO.getAllGames());
            gameTable.setItems(games);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void setupGameSelectionListener() {
        gameTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, selectedGame) -> {
            if (selectedGame != null) {
                loadPlayerGames(selectedGame.getGameId());
            }
        });
    }

    private void loadPlayerGames(int gameId) {
        try {
            playerGames = FXCollections.observableArrayList(playerGameDAO.getPlayerGamesByGameId(gameId));
            playerGameTable.setItems(playerGames);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleAddPlayerGameRecord() {
        Game selectedGame = gameTable.getSelectionModel().getSelectedItem();
        if (selectedGame != null) {
            try {
                int gameId = selectedGame.getGameId();
                int playerId = Integer.parseInt(playerIdField.getText());
                int score = Integer.parseInt(scoreField.getText());

                playerGameDAO.addPlayerGameRecord(gameId, playerId, score);

                loadPlayerGames(gameId); // 새로고침
                playerIdField.clear();
                scoreField.clear();
            } catch (NumberFormatException e) {
                showError("Player ID and Score should be number.");
            } catch (SQLException e) {
                e.printStackTrace();
                showError("error in inserting");
            }
        } else {
            showError("choose a game");
        }
    }

    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
