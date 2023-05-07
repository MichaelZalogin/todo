package ru.mch.todo.service;

import ru.mch.todo.entity.Category;

import java.util.List;
import java.util.Set;

public interface CategoryService {

    List<Category> findAll();

    Set<Category> getCategoriesById(List<Long> categoriesId);

}
