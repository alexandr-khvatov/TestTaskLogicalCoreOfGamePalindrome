package org.example.service;

import org.example.entity.LeaderBoardRecord;
import org.example.entity.User;
import org.example.repo.LeaderBoardRepository;

import java.util.List;

public class LeaderBoardService {
    private final LeaderBoardRepository leaderBoardRepository;

    public LeaderBoardService(LeaderBoardRepository leaderBoardRepository) {
        this.leaderBoardRepository = leaderBoardRepository;
    }

    public void offer(User user) {
        leaderBoardRepository.offer(user);
    }

    public List<LeaderBoardRecord> topUsers() {
        return leaderBoardRepository.topUsers();
    }
}
