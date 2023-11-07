package org.example.repo;

import org.example.entity.LeaderBoardRecord;
import org.example.entity.User;

import java.util.List;

public interface LeaderBoardRepository {
    void offer(User user);

    List<LeaderBoardRecord> topUsers();
}
