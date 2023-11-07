package org.example;

import org.example.entity.LeaderBoardRecord;
import org.example.entity.User;
import org.example.repo.LeaderBoardTop5Repository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

class LeaderBoardTop5RepositoryTest {

    private LeaderBoardTop5Repository leaderBoardTop5;

    @BeforeEach
    void setUp() {
        leaderBoardTop5 = new LeaderBoardTop5Repository();
    }

    @Test
    void offer_shouldAddOneUserInBoard() {
        var user = new User(UUID.randomUUID().toString(), 1);
        leaderBoardTop5.offer(user);

        Assertions.assertEquals(1, leaderBoardTop5.topUsers().size());
    }

    @Test
    void offer_shouldSizeRemainSame() {
        var user1 = new User(UUID.randomUUID().toString(), 1);
        var user2 = new User(UUID.randomUUID().toString(), 2);
        var user3 = new User(UUID.randomUUID().toString(), 3);
        var user4 = new User(UUID.randomUUID().toString(), 4);
        var user5 = new User(UUID.randomUUID().toString(), 5);
        leaderBoardTop5.offer(user1);
        leaderBoardTop5.offer(user2);
        leaderBoardTop5.offer(user3);
        leaderBoardTop5.offer(user4);
        leaderBoardTop5.offer(user5);

        Assertions.assertEquals(5, leaderBoardTop5.topUsers().size());
        var user6 = new User(UUID.randomUUID().toString(), 6);
        leaderBoardTop5.offer(user6);
        Assertions.assertEquals(5, leaderBoardTop5.topUsers().size());
    }

    @Test
    void offer_shouldUpdateTopUser() {
        var user1 = new User(UUID.randomUUID().toString(), 1);
        var user2 = new User(UUID.randomUUID().toString(), 2);
        var user3 = new User(UUID.randomUUID().toString(), 3);
        var user4 = new User(UUID.randomUUID().toString(), 4);
        var user5 = new User(UUID.randomUUID().toString(), 5);
        leaderBoardTop5.offer(user1);
        leaderBoardTop5.offer(user2);
        leaderBoardTop5.offer(user3);
        leaderBoardTop5.offer(user4);
        leaderBoardTop5.offer(user5);

        var user6 = new User(UUID.randomUUID().toString(), 6);
        leaderBoardTop5.offer(user6);

        Assertions.assertTrue(leaderBoardTop5.topUsers().contains(new LeaderBoardRecord(user6.getScore(), user6)));
        Assertions.assertTrue(leaderBoardTop5.topUsers().contains(new LeaderBoardRecord(user5.getScore(), user5)));
        Assertions.assertTrue(leaderBoardTop5.topUsers().contains(new LeaderBoardRecord(user4.getScore(), user4)));
        Assertions.assertTrue(leaderBoardTop5.topUsers().contains(new LeaderBoardRecord(user3.getScore(), user3)));
        Assertions.assertTrue(leaderBoardTop5.topUsers().contains(new LeaderBoardRecord(user2.getScore(), user2)));
        Assertions.assertFalse(leaderBoardTop5.topUsers().contains(new LeaderBoardRecord(user1.getScore(), user1)));
    }

    @Test
    void topUsers_shouldEmptyTopUsers() {
        Assertions.assertTrue(leaderBoardTop5.topUsers().isEmpty());
    }

    @Test
    void topUsers_shouldSortedDescTopUsers() {

        var expected = new LeaderBoardRecord[]{
                new LeaderBoardRecord(5L, new User("1", 5)),
                new LeaderBoardRecord(4L, new User("UUID.randomUUID().toString()", 4)),
                new LeaderBoardRecord(3L, new User("UUID.randomUUID().toString()", 3)),
                new LeaderBoardRecord(2L, new User("UUID.randomUUID().toString()", 2)),
                new LeaderBoardRecord(1L, new User("UUID.randomUUID().toString()", 1)),
        };

        Assertions.assertTrue(leaderBoardTop5.topUsers().isEmpty());

        leaderBoardTop5.offer(new User("UUID.randomUUID().toString()", 1));
        leaderBoardTop5.offer(new User("UUID.randomUUID().toString()", 2));
        leaderBoardTop5.offer(new User("UUID.randomUUID().toString()", 3));
        leaderBoardTop5.offer(new User("UUID.randomUUID().toString()", 4));
        leaderBoardTop5.offer(new User("1", 5));

        Assertions.assertEquals(5, leaderBoardTop5.topUsers().size());
        Assertions.assertArrayEquals(expected, leaderBoardTop5.topUsers().toArray());
    }

    @Test
    void topUsers_shouldReturnSizeEqOne() {
        var user = new User(UUID.randomUUID().toString(), 1);
        leaderBoardTop5.offer(user);
        Assertions.assertEquals(1, leaderBoardTop5.topUsers().size());
    }
}
