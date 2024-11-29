package org.example.minachoi_comp228lab5.dao;

import org.example.minachoi_comp228lab5.DatabaseConnection;
import org.example.minachoi_comp228lab5.model.Game;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GameDAO {

    private static final String TABLE_NAME = "MINA_CHOI_GAME";

    public void insertGame(Game game) throws SQLException {
        String insertQuery = "INSERT INTO MINA_CHOI_GAME (game_title) VALUES (?)";
        String maxIdQuery = "SELECT MAX(game_id) AS max_id FROM MINA_CHOI_GAME";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement insertStatement = connection.prepareStatement(insertQuery)) {

            // 1. 새로운 게임 데이터 삽입
            insertStatement.setString(1, game.getGameTitle());
            insertStatement.executeUpdate();

            // 2. 현재 가장 큰 game_id 조회
            try (Statement maxIdStatement = connection.createStatement();
                 ResultSet resultSet = maxIdStatement.executeQuery(maxIdQuery)) {

                if (resultSet.next()) {
                    int generatedId = resultSet.getInt("max_id");
                    game.setGameId(generatedId);
                    System.out.println("Game added with ID: " + game.getGameId());
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }





    // Retrieve all games
    public List<Game> getAllGames() throws SQLException {
        List<Game> games = new ArrayList<>();
        String query = "SELECT * FROM " + TABLE_NAME;
        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                Game game = new Game(
                        resultSet.getInt("game_id"),
                        resultSet.getString("game_title")
                );
                games.add(game);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return games;
    }
}
