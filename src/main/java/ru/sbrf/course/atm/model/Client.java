package ru.sbrf.course.atm.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

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
