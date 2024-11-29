package org.example.minachoi_comp228lab5.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.minachoi_comp228lab5.dao.GameDAO;
import org.example.minachoi_comp228lab5.model.Game;

import java.sql.SQLException;

public class GameController {

    @FXML
    private TextField titleField;

    @FXML
    private TableView<Game> gameTable;
    @FXML
    private TableColumn<Game, Integer> gameIdColumn;
    @FXML
    private TableColumn<Game, String> titleColumn;

    private ObservableList<Game> gameList = FXCollections.observableArrayList();
    private GameDAO gameDAO = new GameDAO();

    @FXML
    public void initialize() {
        // 테이블 컬럼 초기화
        gameIdColumn.setCellValueFactory(new PropertyValueFactory<>("gameId"));
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("gameTitle"));

        // 테이블 데이터 로드
        loadGames();
    }

    @FXML
    private void handleAddGame() {
        String title = titleField.getText();

        if (title == null || title.trim().isEmpty()) {
            System.out.println("Title is required.");
            return;
        }

        try {
            Game newGame = new Game(title);
            gameDAO.insertGame(newGame);
            gameList.add(newGame); // 테이블 갱신
            titleField.clear();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void loadGames() {
        try {
            gameList = FXCollections.observableArrayList(gameDAO.getAllGames());
            gameTable.setItems(gameList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
