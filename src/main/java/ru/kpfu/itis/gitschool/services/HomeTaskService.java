package ru.kpfu.itis.gitschool.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.gitschool.models.HomeTask;
import ru.kpfu.itis.gitschool.models.User;
import ru.kpfu.itis.gitschool.repositories.HomeTaskRepository;
import ru.kpfu.itis.gitschool.repositories.UserRepository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class HomeTaskService {
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private HomeTaskRepository homeTaskRepo;


    public void assignHomeTask(User user, HomeTask homeTask) {
        user.assignHomeTask(homeTask);
        userRepo.save(user);
    }

    public void submitHomeTask(User user, HomeTask homeTask) {
        user.submitHomeTask(homeTask);
        userRepo.save(user);
    }

    public List<HomeTask> getAll() {
        Iterator<HomeTask> allHomeTasks = homeTaskRepo.findAll().iterator();
        List<HomeTask> list = new ArrayList<>();

        while (allHomeTasks.hasNext()) {
            list.add(allHomeTasks.next());
        }

        return list;
    }
}
