package org.example.repo;

import org.example.entity.LeaderBoardRecord;
import org.example.entity.User;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;


public class LeaderBoardTop5Repository implements LeaderBoardRepository {
    private final int topCapacity;
    private final PriorityQueue<LeaderBoardRecord> topUsers;

    public LeaderBoardTop5Repository() {
        this.topCapacity = 5;
        this.topUsers = new PriorityQueue<>();
    }

    @Override
    public void offer(User user) {
        topUsers.add(new LeaderBoardRecord(user.getScore(), new User(user)));
        if (topUsers.size() > topCapacity) {
            topUsers.poll();
        }
    }

    @Override
    public List<LeaderBoardRecord> topUsers() {
        return new ArrayList<>(topUsers).stream().sorted(Comparator.reverseOrder()).toList();
    }
}
