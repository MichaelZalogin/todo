package ru.mch.todo.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.mch.todo.entity.Category;
import ru.mch.todo.repository.CategoryRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class CategoryServiceImp implements CategoryService {

    private CategoryRepository categoryRepositoryImp;

    @Override
    public List<Category> findAll() {
        return categoryRepositoryImp.findAll();
    }

    @Override
    public Set<Category> getCategoriesById(List<Long> categoriesId) {
        return new HashSet<Category>(categoryRepositoryImp.getCategoriesById(categoriesId));
    }

}