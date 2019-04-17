package ru.kpfu.itis.gitschool.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.gitschool.models.UserAuthority;

@Repository
public interface UserAuthorityRepository extends CrudRepository<UserAuthority, Integer> {
    UserAuthority findByAuthority(String authority);
}
