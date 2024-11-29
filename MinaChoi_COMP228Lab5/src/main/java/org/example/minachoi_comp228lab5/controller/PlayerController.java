package org.example.minachoi_comp228lab5.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.minachoi_comp228lab5.dao.PlayerDAO;
import org.example.minachoi_comp228lab5.model.Player;

import java.sql.SQLException;

public class PlayerController {

    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField addressField;
    @FXML
    private TextField postalCodeField;
    @FXML
    private TextField provinceField;
    @FXML
    private TextField phoneNumberField;

    @FXML
    private TableView<Player> playerTable;
    @FXML
    private TableColumn<Player, Integer> playerIdColumn;
    @FXML
    private TableColumn<Player, String> firstNameColumn;
    @FXML
    private TableColumn<Player, String> lastNameColumn;
    @FXML
    private TableColumn<Player, String> addressColumn;
    @FXML
    private TableColumn<Player, String> postalCodeColumn;
    @FXML
    private TableColumn<Player, String> provinceColumn;
    @FXML
    private TableColumn<Player, String> phoneNumberColumn;

    private ObservableList<Player> playerList = FXCollections.observableArrayList();
    private PlayerDAO playerDAO = new PlayerDAO();

    @FXML
    public void initialize() {
        // 테이블 컬럼 초기화
        playerIdColumn.setCellValueFactory(new PropertyValueFactory<>("playerId"));
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        addressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
        postalCodeColumn.setCellValueFactory(new PropertyValueFactory<>("postalCode"));
        provinceColumn.setCellValueFactory(new PropertyValueFactory<>("province"));
        phoneNumberColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));

        // 테이블 데이터 로드
        loadPlayers();
    }

    @FXML
    private void handleAddPlayer() {
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String address = addressField.getText();
        String postalCode = postalCodeField.getText();
        String province = provinceField.getText();
        String phoneNumber = phoneNumberField.getText();

        if (firstName.trim().isEmpty() || lastName.trim().isEmpty() || address.trim().isEmpty() ||
                postalCode.trim().isEmpty() || province.trim().isEmpty() || phoneNumber.trim().isEmpty()) {
            System.out.println("All fields are required.");
            return;
        }

        try {
            Player newPlayer = new Player(firstName, lastName, address, postalCode, province, phoneNumber);
            playerDAO.insertPlayer(newPlayer);
            playerList.add(newPlayer); // 테이블 갱신
            clearFields();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void loadPlayers() {
        try {
            playerList = FXCollections.observableArrayList(playerDAO.getAllPlayers());
            playerTable.setItems(playerList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void clearFields() {
        firstNameField.clear();
        lastNameField.clear();
        addressField.clear();
        postalCodeField.clear();
        provinceField.clear();
        phoneNumberField.clear();
    }
}
