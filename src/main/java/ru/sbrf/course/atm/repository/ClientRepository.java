package ru.sbrf.course.atm.repository;

import org.springframework.data.repository.CrudRepository;
import ru.sbrf.course.atm.client.model.Client;

public interface ClientRepository extends CrudRepository<Client, Long> {

}