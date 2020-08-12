package ru.sbrf.course.atm.server;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
public class User {
    private int id;
    private String firstname;
    private String lastname;
    private Set<Account> accounts;
}
