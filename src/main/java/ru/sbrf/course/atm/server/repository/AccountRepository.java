package ru.sbrf.course.atm.server.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.sbrf.course.atm.server.model.Account;

import java.util.Optional;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {
    Account findByCardNumber(String cardNumber);
    Optional<Account> findById(Long id);
}
