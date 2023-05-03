package ru.mch.todo.service;

import ru.mch.todo.entity.Priority;

import java.util.List;

public interface PriorityService {

    List<Priority> findAll();

}
