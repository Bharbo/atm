package ru.sbrf.course.atm.server.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.sbrf.course.atm.server.model.Bank;

@Repository
public interface BankRepository extends CrudRepository<Bank, Long> {

}

