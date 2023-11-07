package org.example;

import org.example.entity.User;
import org.example.repo.LeaderBoardRepository;
import org.example.repo.LeaderBoardTop5Repository;
import org.example.repo.UserInMemoryRepository;
import org.example.repo.UserRepository;
import org.example.service.*;

public class Main {
    public static void main(String[] args) {
        // create dependency
        UserRepository userRepository = new UserInMemoryRepository();
        LeaderBoardRepository leaderBoardTop5Repository = new LeaderBoardTop5Repository();
        UserService userService = new UserService(userRepository);
        PalindromeService palindromeService = new PalindromeServiceImpl();
        LeaderBoardService leaderBoardService = new LeaderBoardService(leaderBoardTop5Repository);
        GameSessionManager gameSessionManager = new GameSessionManager(userService, palindromeService, leaderBoardService);
        GameManager gameManager = new GameManager(gameSessionManager);

        var user1 = new User("user_id_1");
        var user2 = new User("user_id_2");
        var user3 = new User("user_id_3");

        // register user
        userService.save(user1);
        userService.save(user2);
        userService.save(user3);

        // launch game
        gameManager.game("user_id_1", "Аргентина манит негра");
        gameManager.game("user_id_1", "Аргентина манит негра");

        gameManager.game("user_id_2", "Аргентина манит негра");

        gameManager.game("user_id_2", "1Аргентина манит негра1");

        gameManager.game("user_id_3", "Топот");
        gameManager.game("user_id_3", "1Топот1");
        gameManager.game("user_id_3", "211Топот12");


        // print stats
        System.out.println("________________________________________________________");
        System.out.println();
        System.out.println("Leader Board:");
        System.out.println();
        leaderBoardService.topUsers().forEach(System.out::println);
        System.out.println();
        System.out.println("________________________________________________________");


        System.out.println("________________________________________________________");
        System.out.println();
        System.out.println("User repository:");
        System.out.println();
        userService.getAll().forEach(System.out::println);
        System.out.println();
        System.out.println("________________________________________________________");

    }
}