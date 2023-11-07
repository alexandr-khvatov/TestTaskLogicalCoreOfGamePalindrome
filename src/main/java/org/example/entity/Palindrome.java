package org.example.entity;

public record Palindrome(String value) {
    public int score() {
        return this.value.length();
    }
}
