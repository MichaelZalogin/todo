package ru.mch.todo.repository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ru.mch.todo.entity.User;

import java.util.Optional;

@Slf4j
@Repository
@AllArgsConstructor
public class UserRepositoryImp implements UserRepository {

    private final SessionFactory sf;

    @Override
    public Optional<User> add(User user) {
        Session session = sf.openSession();
        try {
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
            return Optional.of(user);
        } catch (Exception e) {
            session.getTransaction().rollback();
            log.error("Rollback transaction", e);
        } finally {
            session.close();
        }
        return Optional.empty();
    }

    @Override
    public Optional<User> findByLoginAndPassword(String login, String password) {
        Session session = sf.openSession();
        Optional<User> optionalUser = Optional.empty();
        try {
            session.beginTransaction();
            var query = session.createQuery("""
                            FROM User
                            WHERE login LIKE :fLogin AND
                            password LIKE :fPassword
                            """, User.class)
                    .setParameter("fLogin", login)
                    .setParameter("fPassword", password);
            optionalUser = query.uniqueResultOptional();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            log.error("Rollback transaction", e);
        } finally {
            session.close();
        }
        return optionalUser;
    }
}