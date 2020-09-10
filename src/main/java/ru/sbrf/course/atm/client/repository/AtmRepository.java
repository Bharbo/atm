package ru.sbrf.course.atm.client.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.sbrf.course.atm.client.model.Atm;

@Repository
public interface AtmRepository extends CrudRepository<Atm, Long> {

}