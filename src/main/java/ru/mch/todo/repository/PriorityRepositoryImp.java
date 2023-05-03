package ru.mch.todo.repository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import ru.mch.todo.entity.Priority;

import java.util.List;

@Slf4j
@Repository
@AllArgsConstructor
public class PriorityRepositoryImp implements PriorityRepository {

    private CrudRepository crudRepository;

    @Override
    public List<Priority> findAll() {
        return crudRepository.query("FROM Priority", Priority.class);
    }

}
