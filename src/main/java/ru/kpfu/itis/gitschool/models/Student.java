package ru.kpfu.itis.gitschool.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @ManyToMany(fetch = FetchType.EAGER, cascade={CascadeType.MERGE})
    @JoinTable(
            name = "students_home_tasks",
            joinColumns = @JoinColumn(name = "students"),
            inverseJoinColumns = @JoinColumn(name = "home_tasks"))
    private List<HomeTask> homeTask = new ArrayList<>();

    @NotNull
    @Size(min = 1)
    private String name;
}
