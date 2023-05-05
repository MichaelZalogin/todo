package ru.mch.todo.repository;

import ru.mch.todo.entity.Category;

import java.util.List;

public interface CategoryRepository {

    List<Category> findAll();

}