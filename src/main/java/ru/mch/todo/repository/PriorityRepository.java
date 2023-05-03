package ru.mch.todo.repository;

import ru.mch.todo.entity.Priority;

import java.util.List;

public interface PriorityRepository {

    List<Priority> findAll();

}