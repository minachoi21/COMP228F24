package org.example.minachoi_comp228lab5.model;

public class PlayerGame {
    private int playerGameId;    // Player Game ID
    private int gameId;          // Game ID
    private int playerId;        // Player ID
    private String playingDate;  // Playing Date
    private int score;           // Score

    // Constructor
    public PlayerGame(int playerGameId, int gameId, int playerId, String playingDate, int score) {
        this.playerGameId = playerGameId;
        this.gameId = gameId;
        this.playerId = playerId;
        this.playingDate = playingDate;
        this.score = score;
    }

    // Getters and Setters
    public int getPlayerGameId() {
        return playerGameId;
    }

    public void setPlayerGameId(int playerGameId) {
        this.playerGameId = playerGameId;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public String getPlayingDate() {
        return playingDate;
    }

    public void setPlayingDate(String playingDate) {
        this.playingDate = playingDate;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
