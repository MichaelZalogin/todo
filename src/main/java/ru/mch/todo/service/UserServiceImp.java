package ru.mch.todo.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.mch.todo.entity.User;
import ru.mch.todo.repository.UserRepository;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImp implements UserService {

    private UserRepository userRepository;

    @Override
    public Optional<User> add(User user) {
        return userRepository.add(user);
    }

    @Override
    public Optional<User> findByLoginAndPassword(String login, String password) {
        return userRepository.findByLoginAndPassword(login, password);
    }

}