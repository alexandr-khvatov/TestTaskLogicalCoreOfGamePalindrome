package org.example.service;

public class GameManager {
    private final GameSessionManager gameSessionManager;

    public GameManager(GameSessionManager gameSessionManager) {
        this.gameSessionManager = gameSessionManager;
    }

    public void game(String userId, String palindrome) {
        var gameSession = gameSessionManager.createGameSession(userId);
        var gameResult = gameSession.game(palindrome);
        gameSessionManager.upgradeUserStatistics(gameResult);
    }
}
