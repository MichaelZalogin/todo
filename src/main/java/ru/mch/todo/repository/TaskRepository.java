package ru.mch.todo.repository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import ru.mch.todo.entity.Task;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Slf4j
@Repository
@AllArgsConstructor
public class TaskRepository {

    private CrudRepository crudRepository;

    /**
     * Сохранить в базе.
     *
     * @param task задача.
     * @return задача с установленныым id.
     */
    public Task add(Task task) {
        crudRepository.run(session -> session.persist(task));
        return task;
    }

    /**
     * Обновить имя и описание задачу.
     *
     * @param task задача.
     */
    public void update(Task task) {
        crudRepository.run(
                "UPDATE Task SET name = :fName, description = :fDescription WHERE id = :fId",
                Map.of("fName", task.getName(), "fDescription", task.getDescription(), "fId", task.getId())
        );
    }

    /**
     * Удалить задачу по id.
     *
     * @param id задачи.
     */
    public void deleteById(Long id) {
        crudRepository.run(
                "DELETE Task WHERE id = :fId",
                Map.of("fId", id)
        );
    }

    /**
     * Полный cписок задач отсортированных по id.
     *
     * @return список задач.
     */
    public List<Task> findAllOrderById() {
        return crudRepository.query("FROM Task ORDER BY id asc",
                Task.class);
    }

    /**
     * Найти задачу по id.
     *
     * @return задача.
     */
    public Optional<Task> findById(Long id) {
        return crudRepository.optional(
                "SELECT t FROM Task t JOIN FETCH t.categories WHERE t.id = :fId ", Task.class,
                Map.of("fId", id)
        );
    }

    /**
     * Список задач по статусу выполнения.
     *
     * @param status статус задачи.
     * @return список задач.
     */
    public List<Task> findStatusTasks(boolean status) {
        return crudRepository.query(
                "FROM Task WHERE done = :fDone", Task.class,
                Map.of("fDone", status)
        );
    }

    /**
     * Обновить статус у задачи.
     *
     * @param status статус задачи.
     * @param id     задачи.
     */
    public void updateStatus(Long id, boolean status) {
        crudRepository.run(
                "UPDATE Task SET done = :fDone WHERE id = :fId",
                Map.of("fDone", status, "fId", id)
        );
    }
}