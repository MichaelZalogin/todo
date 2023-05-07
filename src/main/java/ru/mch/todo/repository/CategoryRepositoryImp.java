package ru.mch.todo.repository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import ru.mch.todo.entity.Category;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Repository
@AllArgsConstructor
public class CategoryRepositoryImp implements CategoryRepository {

    private CrudRepository crudRepository;

    @Override
    public List<Category> findAll() {
        return crudRepository.query("FROM Category", Category.class);
    }

    public List<Category> getCategoriesById(List<Long> categoriesId) {
        Map<String, Object> args = new HashMap<>();
        args.put("list", categoriesId);
        return crudRepository.query("FROM Category WHERE id IN :list", Category.class, args);
    }

}