package ru.kpfu.itis.gitschool.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.gitschool.models.HomeTask;
import ru.kpfu.itis.gitschool.models.User;
import ru.kpfu.itis.gitschool.repositories.HomeTaskRepository;
import ru.kpfu.itis.gitschool.repositories.UserRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaBuilder;
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

    public void submitHomeTask(User user, List<HomeTask> homeTasks) {
        user.setSubmittedHomeTasks(homeTasks);
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

    public void updateHomeTask(HomeTask homeTask) {
        HomeTask foundHT = homeTaskRepo.findById(homeTask.getId()).get();
        foundHT.setDeadline(homeTask.getDeadline());
        foundHT.setDescription(homeTask.getDescription());

        homeTaskRepo.save(homeTask);
    }

    public void deleteHomeTask(User user, HomeTask homeTask) {
        User fUser = userRepo.findByEmail(user.getEmail());

        List<HomeTask> tasks = fUser.getAssignedHomeTasks();
        tasks.remove(homeTask);
        fUser.setAssignedHomeTasks(tasks);

        userRepo.save(fUser);
        homeTaskRepo.deleteById(homeTask.getId());
    }
}
