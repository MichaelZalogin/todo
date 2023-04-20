package ru.mch.todo.repository;

import java.util.List;
import java.util.Optional;

public interface CrudRepository<K, E> {

    E add(E e);

    boolean update(E e);

    boolean deleteById(K id);

    List<E> findAll();

    Optional<E> findById(K id);
}