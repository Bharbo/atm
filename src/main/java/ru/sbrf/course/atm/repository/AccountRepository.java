package ru.sbrf.course.atm.repository;

import org.springframework.data.repository.CrudRepository;
import ru.sbrf.course.atm.server.Account;

public interface AccountRepository extends CrudRepository<Account, Long> {

}
