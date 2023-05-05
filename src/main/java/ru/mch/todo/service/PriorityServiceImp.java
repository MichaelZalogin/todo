package ru.mch.todo.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.mch.todo.entity.Priority;
import ru.mch.todo.repository.PriorityRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class PriorityServiceImp implements PriorityService {

    private PriorityRepository priorityRepositoryImp;

    @Override
    public List<Priority> findAll() {
        return priorityRepositoryImp.findAll();
    }

}