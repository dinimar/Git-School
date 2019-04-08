package ru.kpfu.itis.gitschool.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "home_tasks")
public class HomeTask {
    @Id
    @GeneratedValue
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @NotNull
    @Size(min = 1)
    private String name;

    @NotNull
    @Size
    private String type;
}
