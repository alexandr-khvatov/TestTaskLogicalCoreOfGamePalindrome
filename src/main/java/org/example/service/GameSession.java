package org.example.service;

import org.example.entity.GameSessionResult;
import org.example.entity.User;

public class GameSession {
    private final User user;
    private final PalindromeService palindromeService;

    public GameSession(User user, PalindromeService palindromeService) {
        this.user = user;
        this.palindromeService = palindromeService;
    }

    public GameSessionResult game(String palindrome) {
        var previousScore = user.getScore();
        palindromeService.isPalindrome(palindrome).ifPresent(user::grow);
        return new GameSessionResult(user, previousScore != user.getScore());
    }
}
