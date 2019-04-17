package ru.kpfu.itis.gitschool.models;

import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "users_roles")
public class UserAuthority implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO) /* http://www.objectdb.com/java/jpa/entity/generated */
    private Integer id;

    @NotBlank
    @Length(max = 30)
    @Column(length = 30, nullable = false, unique = true)
    private String authority;


    @Override
    public String getAuthority() {
        return null;
    }
}
