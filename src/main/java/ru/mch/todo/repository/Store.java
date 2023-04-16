package ru.mch.todo.repository;

import java.util.List;

public interface Store<K, E> {

    E add(E e);

    boolean replace(K id, E e);

    boolean delete(K id);

    List<E> findAll();

    List<E> findByName(String key);

    E findById(K id);
}