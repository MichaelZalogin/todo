package ru.mch.todo.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.mch.todo.entity.Category;
import ru.mch.todo.repository.CategoryRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryServiceImp implements CategoryService {

    private CategoryRepository categoryRepositoryImp;

    @Override
    public List<Category> findAll() {
        return categoryRepositoryImp.findAll();
    }

}