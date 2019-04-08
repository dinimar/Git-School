package ru.kpfu.itis.gitschool.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.gitschool.models.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {}
