package ru.kpfu.itis.gitschool.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

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

    public HomeTask() {
    }

    public HomeTask(@NotNull @Size(min = 1) String name, @NotNull @Size String type) {
        this.name = name;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HomeTask homeTask = (HomeTask) o;
        return id == homeTask.id &&
                Objects.equals(name, homeTask.name) &&
                Objects.equals(type, homeTask.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, type);
    }
}
