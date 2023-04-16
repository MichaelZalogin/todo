package ru.mch.todo.repository;

import java.util.List;
import java.util.Optional;

public interface CrudRepository<K, E> {

    E add(E e);

    boolean replace(K id, E e);

    boolean delete(K id);

    List<E> findAll();

    Optional<E> findById(K id);
}