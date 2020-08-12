package ru.sbrf.course.atm.client.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.sbrf.course.atm.server.Account;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
public class Client {
    private int id;
    private String firstname;
    private String lastname;
    private Set<Account> accounts;
}
