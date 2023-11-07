package org.example.entity;

import java.util.HashSet;

public class User implements Comparable<User> {
    private final String id;
    private long score = 0L;
    private final HashSet<Palindrome> usedPalindromes = new HashSet<>(100);


    public User(User user) {
        this.id = user.getId();
        this.score = user.getScore();
        usedPalindromes.addAll(user.getUsedPalindromes());
    }


    public User(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (score != user.score) return false;
        if (!id.equals(user.id)) return false;
        return usedPalindromes.equals(user.usedPalindromes);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (int) (score ^ (score >>> 32));
        result = 31 * result + usedPalindromes.hashCode();
        return result;
    }

    public HashSet<Palindrome> getUsedPalindromes() {
        return usedPalindromes;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", score=" + score +
                ", usedPalindromes=" + usedPalindromes +
                '}';
    }

    public User(String id, long score) {
        this.id = id;
        this.score = score;
    }

    public String getId() {
        return this.id;
    }

    public long getScore() {
        return this.score;
    }

    private void increaseScore(long score) {
        if (score < 0) {
            throw new IllegalArgumentException("Не должно быть отрицательным {}".formatted(score));
        }
        this.score += score;
    }

    private boolean addPalindrome(Palindrome palindrome) {
        if (!this.usedPalindromes.contains(palindrome)) {
            return this.usedPalindromes.add(palindrome);
        } else {
            return false;
        }
    }

    public long grow(Palindrome palindrome) {
        if (addPalindrome(palindrome)) {
            increaseScore(palindrome.score());
        }
        return this.score;
    }

    @Override
    public int compareTo(User user) {
        return Long.compare(this.score, user.score);
    }
}
