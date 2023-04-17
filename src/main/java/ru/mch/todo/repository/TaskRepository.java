package ru.mch.todo.repository;

import lombok.AllArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import ru.mch.todo.entity.Task;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class TaskRepository implements CrudRepository<Long, Task> {

    private final SessionFactory sf;

    @Override
    public Task add(Task task) {
        Session session = sf.openSession();
        try {
            session.beginTransaction();
            session.save(task);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return task;
    }

    @Override
    public boolean replace(Long id, Task task) {
        var session = sf.openSession();
        boolean result = false;
        try {
            session.beginTransaction();
            var query = session.createQuery("""
                            UPDATE Task
                            SET description = :fDescription
                            WHERE id = :fId
                                    """)
                    .setParameter("fDescription", task.getDescription())
                    .setParameter("fId", id);
            result = query.executeUpdate() > 0;
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return result;
    }

    @Override
    public boolean delete(Long id) {
        var session = sf.openSession();
        boolean result = false;
        try {
            session.beginTransaction();
            var query = session.createQuery("""
                            DELETE Task
                            WHERE id = :fId
                                    """)
                    .setParameter("fId", id);
            result = query.executeUpdate() > 0;
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return result;
    }

    @Override
    public List<Task> findAll() {
        var session = sf.openSession();
        List<Task> itemList = new ArrayList<>();
        try {
            session.beginTransaction();
            Query<Task> query = session.createQuery("FROM Task");
            itemList = query.list();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return itemList;
    }

    @Override
    public Optional<Task> findById(Long id) {
        Session session = sf.openSession();
        Optional<Task> taskOptional = Optional.empty();
        try {
            Query<Task> query = session.createQuery("""
                            FROM Task 
                            WHERE id = :fId
                            """)
                    .setParameter("fId", id);
            taskOptional = query.uniqueResultOptional();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return taskOptional;
    }
}