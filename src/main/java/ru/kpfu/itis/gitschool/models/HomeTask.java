package ru.kpfu.itis.gitschool.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "home_tasks")
public class HomeTask {
    @Id
    @GeneratedValue
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @NotNull
    @Future
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date deadline;

    @NotNull
    @Size
    private String description;

    public HomeTask() {
    }

    public HomeTask(@NotNull @Future Date deadline, @NotNull @Size String description) {
        this.deadline = deadline;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HomeTask homeTask = (HomeTask) o;
        return id == homeTask.id &&
                Objects.equals(deadline, homeTask.deadline) &&
                Objects.equals(description, homeTask.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, deadline, description);
    }

    @Override
    public String toString() {
        return "HomeTask{" +
                "id=" + id +
                ", deadline=" + deadline +
                ", description='" + description + '\'' +
                '}';
    }
}
