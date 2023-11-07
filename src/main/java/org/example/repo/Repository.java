package org.example.repo;

import java.util.Collection;
import java.util.Optional;

public interface Repository<T> {
    Optional<T> findById(String id);

    T save(T o);

    boolean delete(T user);

    Collection<T> getAll();
}
