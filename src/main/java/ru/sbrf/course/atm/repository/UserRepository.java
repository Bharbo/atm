package ru.sbrf.course.atm.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.sbrf.course.atm.server.Account;
import ru.sbrf.course.atm.server.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
