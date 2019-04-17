//package ru.kpfu.itis.gitschool.models;
//
//import javax.persistence.*;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Objects;
//
//@Entity
//@Table(name = "students")
//public class Student {
//    @Id
//    @GeneratedValue
//    @Column(name = "id", unique = true, nullable = false)
//    private int id;
//
//    @ManyToMany(fetch = FetchType.EAGER, cascade={CascadeType.MERGE})
//    @JoinTable(
//            name = "students_home_tasks",
//            joinColumns = @JoinColumn(name = "students"),
//            inverseJoinColumns = @JoinColumn(name = "home_tasks"))
//    private List<HomeTask> homeTasks = new ArrayList<>();
//
//    @NotNull
//    @Size(min = 1)
//    private String name;
//
//    public Student(){}
//
//    public Student(List<HomeTask> homeTasks, @NotNull @Size(min = 1) String name) {
//        this.homeTasks = homeTasks;
//        this.name = name;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public List<HomeTask> getHomeTasks() {
//        return homeTasks;
//    }
//
//    public void setHomeTasks(List<HomeTask> homeTasks) {
//        this.homeTasks = homeTasks;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Student student = (Student) o;
//        return id == student.id &&
//                homeTasks.equals(student.homeTasks) &&
//                name.equals(student.name);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, homeTasks, name);
//    }
//}
