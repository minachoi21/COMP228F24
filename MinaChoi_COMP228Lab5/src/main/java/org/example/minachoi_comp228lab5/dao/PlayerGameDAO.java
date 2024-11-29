package org.example.minachoi_comp228lab5.dao;

import org.example.minachoi_comp228lab5.DatabaseConnection;
import org.example.minachoi_comp228lab5.model.Game;
import org.example.minachoi_comp228lab5.model.PlayerGame;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlayerGameDAO {

    private static final String GAME_TABLE = "MINA_CHOI_GAME";
    private static final String PLAYER_GAME_TABLE = "MINA_CHOI_PLAYER_AND_GAME";

    public List<Game> getAllGames() throws SQLException {
        String query = "SELECT game_id, game_title FROM " + GAME_TABLE;
        List<Game> games = new ArrayList<>();

        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                games.add(new Game(resultSet.getInt("game_id"), resultSet.getString("game_title")));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return games;
    }

    public List<PlayerGame> getPlayerGamesByGameId(int gameId) throws SQLException {
        String query = "SELECT player_game_id, game_id, player_id, playing_date, score " +
                "FROM " + PLAYER_GAME_TABLE + " WHERE game_id = ?";
        List<PlayerGame> playerGames = new ArrayList<>();

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, gameId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                playerGames.add(new PlayerGame(
                        resultSet.getInt("player_game_id"),
                        resultSet.getInt("game_id"),
                        resultSet.getInt("player_id"),
                        resultSet.getString("playing_date"),
                        resultSet.getInt("score")
                ));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return playerGames;
    }

    public void addPlayerGameRecord(int gameId, int playerId, int score) throws SQLException {
        String query = "INSERT INTO " + PLAYER_GAME_TABLE + " (game_id, player_id, playing_date, score) " +
                "VALUES (?, ?, SYSDATE, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, gameId);
            preparedStatement.setInt(2, playerId);
            preparedStatement.setInt(3, score);
            preparedStatement.executeUpdate();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
