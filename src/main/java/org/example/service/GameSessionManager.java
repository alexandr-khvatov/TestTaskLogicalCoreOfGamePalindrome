package org.example.service;

import org.example.entity.GameSessionResult;
import org.example.exception.UserNotFoundException;

public class GameSessionManager {
    private final UserService userService;
    private final PalindromeService palindromeService;
    private final LeaderBoardService leaderBoardService;

    public GameSessionManager(UserService userService, PalindromeService palindromeService, LeaderBoardService leaderBoardService) {
        this.userService = userService;
        this.palindromeService = palindromeService;
        this.leaderBoardService = leaderBoardService;
    }

    public GameSession createGameSession(String userId) {
        var user = userService.findById(userId)
                .orElseThrow(() -> {
                    throw new UserNotFoundException("User with id:{} not found".formatted(userId));
                });
        return new GameSession(user, palindromeService);
    }

    public void upgradeUserStatistics(GameSessionResult gameSessionResult) {
        var user = gameSessionResult.user();
        userService.save(user);
        if (gameSessionResult.isGrowStats()) {
            leaderBoardService.offer(user);
        }
    }
}

