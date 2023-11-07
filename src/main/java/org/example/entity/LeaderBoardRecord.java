package org.example.entity;

public record LeaderBoardRecord(Long score, User user) implements Comparable<LeaderBoardRecord> {
    @Override
    public int compareTo(LeaderBoardRecord leaderBoardRecord) {
        return Long.compare(this.score, leaderBoardRecord.score());
    }
}
