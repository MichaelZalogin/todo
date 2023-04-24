package ru.mch.todo.service;

import ru.mch.todo.entity.User;
import java.util.Optional;

public interface UserService {

    User add(User user);

    Optional<User> findByLoginAndPassword(String login, String password);

}
