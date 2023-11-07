package org.example.repo;

import org.example.entity.User;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class UserInMemoryRepository implements UserRepository {
    private final Map<String, User> users = new HashMap<>();

    @Override
    public Optional<User> findById(String id) {
        if (users.containsKey(id)) {
            return Optional.of(users.get(id));
        }
        return Optional.empty();
    }

    @Override
    public User save(User user) {
        return users.put(user.getId(), user);
    }

    @Override
    public boolean delete(User user) {
        return users.remove(user.getId(), user);
    }

    @Override
    public Collection<User> getAll() {
        return users.values();
    }
}
