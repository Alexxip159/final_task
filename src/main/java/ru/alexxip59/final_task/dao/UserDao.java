package ru.alexxip59.final_task.dao;

import ru.alexxip59.final_task.model.User;

import java.util.List;

public interface UserDao {
    List<User> listUsers();
    User showUser(Long id);
    void addUser(User user);
    void removeUser(Long id);
    void updateUser(Long id, User user);
}
