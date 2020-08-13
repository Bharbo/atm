package ru.sbrf.course.atm.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.sbrf.course.atm.client.model.Client;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {

}