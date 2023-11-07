package org.example.service;

import org.example.entity.User;
import org.example.repo.UserRepository;

import java.util.Collection;
import java.util.Optional;

public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> findById(String id) {
        return userRepository.findById(id);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public boolean delete(User user) {
        return userRepository.delete(user);
    }

    public Collection<User> getAll() {
        return userRepository.getAll();
    }
}
