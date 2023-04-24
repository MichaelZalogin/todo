package ru.mch.todo.repository;

import ru.mch.todo.entity.User;
import java.util.Optional;

public interface UserRepository {

    User add(User user);

    Optional<User> findByLoginAndPassword(String login, String password);

}