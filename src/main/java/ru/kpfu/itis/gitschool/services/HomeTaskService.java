package ru.kpfu.itis.gitschool.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.gitschool.models.HomeTask;
import ru.kpfu.itis.gitschool.models.User;
import ru.kpfu.itis.gitschool.repositories.UserRepository;

@Service
public class HomeTaskService {
    @Autowired
    private UserRepository userRepo;

    public void assignHomeTask(User user, HomeTask homeTask) {
        user.assignHomeTask(homeTask);
        userRepo.save(user);
    }
}
