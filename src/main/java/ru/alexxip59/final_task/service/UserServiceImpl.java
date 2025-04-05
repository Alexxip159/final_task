package ru.alexxip59.final_task.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.alexxip59.final_task.model.User;
import ru.alexxip59.final_task.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

//    @Qualifier("userDaoJPAImpl")
//    private final UserDao repository;
    private final UserRepository repository;

    @Transactional(readOnly = true)
    @Override
    public List<User> listUsers() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public User showUser(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public void addUser(User user) {
        repository.save(user);
    }

    @Transactional
    @Override
    public void removeUser(Long id) {
        repository.deleteById(id);
    }

    @Transactional
    @Override
    public void updateUser(Long id, User user) {
        repository.save(user);
    }
}
