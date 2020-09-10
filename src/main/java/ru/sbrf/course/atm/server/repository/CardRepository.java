package ru.sbrf.course.atm.server.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.sbrf.course.atm.server.model.Card;

@Repository
public interface CardRepository extends CrudRepository<Card, Long> {
    Card findByNumber(String cardNumber);
}
