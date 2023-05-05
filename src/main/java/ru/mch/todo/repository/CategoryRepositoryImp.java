package ru.mch.todo.repository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import ru.mch.todo.entity.Category;

import java.util.List;

@Slf4j
@Repository
@AllArgsConstructor
public class CategoryRepositoryImp implements CategoryRepository {

    private CrudRepository crudRepository;

    @Override
    public List<Category> findAll() {
        return crudRepository.query("FROM Category", Category.class);
    }

}
