package org.example.minachoi_comp228lab5.dao;

import org.example.minachoi_comp228lab5.DatabaseConnection;
import org.example.minachoi_comp228lab5.model.Player;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlayerDAO {

    private static final String TABLE_NAME = "MINA_CHOI_PLAYER";

    // Insert a new player
    public void insertPlayer(Player player) throws SQLException {
        String query = "INSERT INTO " + TABLE_NAME +
                " (first_name, last_name, address, postal_code, province, phone_number) " +
                "VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, player.getFirstName());
            preparedStatement.setString(2, player.getLastName());
            preparedStatement.setString(3, player.getAddress());
            preparedStatement.setString(4, player.getPostalCode());
            preparedStatement.setString(5, player.getProvince());
            preparedStatement.setString(6, player.getPhoneNumber());
            preparedStatement.executeUpdate();

            // Retrieve the generated player_id
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                String maxIdQuery = "SELECT MAX(player_id) FROM " + TABLE_NAME;
                try (Statement maxIdStatement = connection.createStatement();
                     ResultSet maxIdResultSet = maxIdStatement.executeQuery(maxIdQuery)) {
                    if (maxIdResultSet.next()) {
                        int maxId = maxIdResultSet.getInt(1);
                        player.setPlayerId(maxId + 1); // 가장 큰 ID에 +1
                        System.out.println("Player added with calculated ID: " + player.getPlayerId());
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Retrieve all players
    public List<Player> getAllPlayers() throws SQLException {
        List<Player> players = new ArrayList<>();
        String query = "SELECT * FROM " + TABLE_NAME;
        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                System.out.println("Generated Key: " + resultSet.getInt("player_id"));
                Player player = new Player(
                        resultSet.getInt("player_id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("address"),
                        resultSet.getString("postal_code"),
                        resultSet.getString("province"),
                        resultSet.getString("phone_number")
                );
                players.add(player);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return players;
    }

    // Get player by ID
    public Player getPlayerById(int playerId) throws SQLException {
        String query = "SELECT * FROM " + TABLE_NAME + " WHERE player_id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, playerId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return new Player(
                        resultSet.getInt("player_id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("address"),
                        resultSet.getString("postal_code"),
                        resultSet.getString("province"),
                        resultSet.getString("phone_number")
                );
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null; // Player not found
    }
}
